package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.RAMService;
import TakaZada.Model.Case;
import TakaZada.Model.RAM;
import TakaZada.Model.UserLogin;

@Controller
public class RAMController {
	RAMService _ramService;
	public RAMController() {
		_ramService = new RAMService();
	}
	@RequestMapping(value = {"/ListRAM"}, method = RequestMethod.GET)
	public String ListRAM(@Autowired HttpServletRequest request)
	{
		ArrayList<RAM> listram = _ramService.Load();
		request.setAttribute("ListRAM", listram);
		request.setAttribute("domainname", request.getContextPath());
		return "ListRAM";
	}
	@RequestMapping(value = {"/ListRAM/{trademark}"}, method = RequestMethod.GET)
	public String ListRAMByTradeMark(@Autowired HttpServletRequest request,@PathVariable("trademark") String trademark)
	{
		ArrayList<RAM> listram = _ramService.LoadByTrademark(trademark);
		request.setAttribute("ListRAM", listram);
		request.setAttribute("domainname", request.getContextPath());
		return "ListRAM";
	}
	@RequestMapping(value = "/RAMDetail/{ramId}", method = RequestMethod.GET)
	public String RAMDetail(@Autowired HttpServletRequest request,@PathVariable("ramId") int ramId)
	{
		request.setAttribute("domainname", request.getContextPath());
		RAM _ram = _ramService.LoadById(ramId);
		request.setAttribute("RAM", _ram);
		request.setAttribute("TheSameTrademark", _ramService.LoadTheSameTrademark(_ram.TradeMark, _ram.Id));
		
		return "RAMDetail";
	}
	
	@RequestMapping(value = {"Admin/AdminListRAM"}, method = RequestMethod.GET)
	public String AdminListRAM(@Autowired HttpServletRequest request)
	{
		UserLogin user = (UserLogin)request.getSession().getAttribute("ADMIN_SESSION");
		if ( user != null )
		{
			ArrayList<RAM> listram = _ramService.Load();
			request.setAttribute("ListRAM", listram);
			request.setAttribute("domainname", request.getContextPath());
			return "adminram";
		}
		return "login";	
	}
	
	@RequestMapping(value = {"Admin/DeleteRAM/{ramId}"}, method = RequestMethod.GET)
	public String DeleteRAM(@Autowired HttpServletRequest request,@PathVariable("ramId") int ramId)
	{
		_ramService.DeleteRAM(ramId);
		return "redirect:/Admin/AdminListRAM";
	}
	
	@RequestMapping(value = {"Admin/RestoreRAM/{ramId}"}, method = RequestMethod.GET)
	public String RestoreRAM(@Autowired HttpServletRequest request,@PathVariable("ramId") int ramId)
	{
		_ramService.RestoreRAM(ramId);
		return "redirect:/Admin/AdminListRAM";
	}
	
	@RequestMapping(value = {"Admin/RemoveRAM/{ramId}"}, method = RequestMethod.GET)
	public String RemoveRAM(@Autowired HttpServletRequest request,@PathVariable("ramId") int ramId)
	{
		_ramService.DeleteRAMFromDeletedlist(ramId);
		return "redirect:/Admin/AdminListRAM";
	}
	@RequestMapping(value = {"Admin/AdminListRAM/UpdateRAM/{ramId}"}, method = RequestMethod.GET)
	public String UpdateCase(@Autowired HttpServletRequest request,@PathVariable("ramId") int ramId)
	{
		RAM _ram = _ramService.LoadById(ramId);
		request.setAttribute("SelectedRAM", _ram);
		return "AdminUpdateRAM";
	}
	@RequestMapping(value = {"Admin/AdminListRAM/UpdateRAM"}, method = RequestMethod.POST)
	public String UpdateCase(@Autowired HttpServletRequest request)
	{
		RAM ram = _ramService.LoadById(Integer.parseInt(request.getParameter("Id")));
		try { ram.Name = request.getParameter("Name"); } catch (Exception e) { }
        try { ram.Description = request.getParameter("Description"); } catch (Exception e) { }
        try { ram.TradeMark = request.getParameter("TradeMark"); } catch (Exception e) { }
        try { ram.Color = request.getParameter("Color"); } catch (Exception e) { }
        try { ram.RamType = request.getParameter("RamType"); } catch (Exception e) { }
        try { ram.Memory = request.getParameter("Memory"); } catch (Exception e) { }
        try { ram.BusSpeed = request.getParameter("BusSpeed"); } catch (Exception e) { }
        try { ram.Price = request.getParameter("Price"); } catch (Exception e) { }
        try { ram.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch (Exception e) { }

        String price = ram.Price.replace(".", "").replace("đ", "");


        if (_ramService.UpdateRAM(ram))
        {   
        	return "redirect:/Admin/AdminListRAM";
        }
        return "redirect:/Admin/AdminListRAM/UpdateRAM/" + ram.Id;
	}
	
	@RequestMapping(value = {"Admin/AddRAM"}, method = RequestMethod.GET)
	public String AddRAM_GET(@Autowired HttpServletRequest request)
	{
		return "AddRAM";
	}
	@RequestMapping(value = {"Admin/AddRAM"}, method = RequestMethod.POST)
	public String AddRAM_POST(@Autowired HttpServletRequest request)
	{
		RAM ram = _ramService.CreateRAM();
		 String filename = request.getParameter("Image");
		 
        try { ram.Name = request.getParameter("Name"); } catch (Exception e) { }
        try { ram.Description = request.getParameter("Description"); } catch (Exception e) { }
        try { ram.TradeMark = request.getParameter("TradeMark"); } catch (Exception e) { }
        try { ram.Color = request.getParameter("Color"); } catch (Exception e) { }
        try { ram.RamType = request.getParameter("RamType"); } catch (Exception e) { }
        try { ram.Memory = request.getParameter("Memory"); } catch (Exception e) { }
        try { ram.BusSpeed = request.getParameter("BusSpeed"); } catch (Exception e) { }
        try { ram.Price = request.getParameter("Price"); } catch (Exception e) { }
        try { ram.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
        ram.Image = filename;
        ram.IsDeleted = false;

        if (_ramService.InsertRAM(ram))
        {
            return "redirect:/Admin/AdminListRAM";
        }
		return "redirect:/Admin/AddRAM";
	}
}
