package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.ComputerService;
import TakaZada.Model.Case;
import TakaZada.Model.Computer;
import TakaZada.Model.UserLogin;

@Controller
public class ComputerController {
	ComputerService _computerService;	
	public ComputerController()
	{
		_computerService = new ComputerService();	
	}
	@RequestMapping(value = {"/ListComputer"}, method = RequestMethod.GET)
	public String ListComputer(@Autowired HttpServletRequest request,Model model)
	{
		ArrayList<Computer> listconmupter = _computerService.Load();
		request.setAttribute("ListComputer", listconmupter);
		request.setAttribute("domainname", request.getContextPath());
		return "ListComputer";
	}
	@RequestMapping(value = {"/ListComputer/{trademark}"}, method = RequestMethod.GET)
	public String ListComputerByTrademark(@Autowired HttpServletRequest request,@PathVariable("trademark") String trademark)
	{
		ArrayList<Computer> listconmupter = _computerService.LoadByTradeMark(trademark);
		request.setAttribute("ListComputer", listconmupter);
		request.setAttribute("domainname", request.getContextPath());
		return "ListComputer";
	}
	@RequestMapping(value = "/ComputerDetail/{computerId}", method = RequestMethod.GET)
	public String ComputerDetail(@Autowired HttpServletRequest request,@PathVariable("computerId") int computerId)
	{
		request.setAttribute("domainname", request.getContextPath());
		Computer _computer = _computerService.LoadById(computerId);
		request.setAttribute("Computer", _computer);
		request.setAttribute("TheSameTrademark", _computerService.LoadTheSameTrademark(_computer.Trademark, _computer.Id));
		
		return "ComputerDetail";
	}
	@RequestMapping(value = {"Admin/AdminListComputer"}, method = RequestMethod.GET)
	public String AdminListComputer(@Autowired HttpServletRequest request)
	{
		UserLogin user = (UserLogin)request.getSession().getAttribute("ADMIN_SESSION");
		if ( user != null )
		{
			ArrayList<Computer> listcomputer = _computerService.Load();
			request.setAttribute("ListComputer", listcomputer);
			request.setAttribute("domainname", request.getContextPath());
			return "admincomputer";
		}
		return "login";	
	}
	
	@RequestMapping(value = {"Admin/DeleteComputer/{computerId}"}, method = RequestMethod.GET)
	public String DeleteComputer(@Autowired HttpServletRequest request,@PathVariable("computerId") int computerId)
	{
		_computerService.DeleteComputer(computerId);
		return "redirect:/Admin/AdminListComputer";
	}
	
	@RequestMapping(value = {"Admin/RestoreComputer/{computerId}"}, method = RequestMethod.GET)
	public String RestoreComputer(@Autowired HttpServletRequest request,@PathVariable("computerId") int computerId)
	{
		_computerService.RestoreComputer(computerId);
		return "redirect:/Admin/AdminListComputer";
	}
	
	@RequestMapping(value = {"Admin/RemoveComputer/{computerId}"}, method = RequestMethod.GET)
	public String RemoveComputer(@Autowired HttpServletRequest request,@PathVariable("computerId") int computerId)
	{
		_computerService.DeleteComputerFromDeletedlist(computerId);
		return "redirect:/Admin/AdminListComputer";
	}
	
	@RequestMapping(value = {"Admin/AdminListComputer/UpdateComputer/{computerId}"}, method = RequestMethod.GET)
	public String UpdateComputer(@Autowired HttpServletRequest request,@PathVariable("computerId") int computerId)
	{
		Computer _computer = _computerService.LoadById(computerId);
		request.setAttribute("SelectedComputer", _computer);
		return "AdminUpdateComputer";
	}
	@RequestMapping(value = {"Admin/AdminListComputer/UpdateComputer/"}, method = RequestMethod.POST)
	public String UpdateComputer(@Autowired HttpServletRequest request)
	{
		Computer computer = _computerService.LoadById(Integer.parseInt(request.getParameter("ComputerId")));
		
        try { computer.Name = request.getParameter("Name"); } catch (Exception e) { }
        try { computer.CPU = request.getParameter("CPU"); } catch (Exception e) { }
        try { computer.RAM = request.getParameter("RAM"); } catch (Exception e) { }
        try { computer.VideoCard = request.getParameter("VideoCard"); } catch (Exception e) { }
        try { computer.Hardware = request.getParameter("Hardware"); } catch (Exception e) { }
        try { computer.SlotSupport = request.getParameter("SlotSupport"); } catch (Exception e) { }
        try { computer.Display = request.getParameter("Display"); } catch (Exception e) { }
        try { computer.OS = request.getParameter("OS"); } catch (Exception e) { }
        try { computer.Type = request.getParameter("Type"); } catch (Exception e) { }
        try { computer.Trademark = request.getParameter("Trademark"); } catch (Exception e) { }
        try { computer.Feature = request.getParameter("Feature"); } catch (Exception e) { }
        try { computer.Color = request.getParameter("Color"); } catch (Exception e) { }
        try { computer.CPUSeries = request.getParameter("CPUSeries"); } catch (Exception e) { }
        try { computer.Resolution = request.getParameter("Resolution"); } catch (Exception e) { }
        try { computer.StandardOfScreen = request.getParameter("StandardOfScreen"); } catch (Exception e) { }
        try { computer.Size = request.getParameter("Size"); } catch (Exception e) { }
        try { computer.Mass = request.getParameter("Mass"); } catch (Exception e) { }
        try { computer.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
        try { computer.Price = request.getParameter("Price"); } catch (Exception e) { }
        try { computer.Description = request.getParameter("Description"); } catch (Exception e) { }
        String price = computer.Price.replace(".", "").replace("đ", "");


        if (_computerService.UpdateComputer(computer))
        {
        	return "redirect:/Admin/AdminListComputer";
        }
		return "redirect:/Admin/AdminListComputer/UpdateComputer/" + computer.Id;
	}
	
	@RequestMapping(value = {"Admin/AddComputer"}, method = RequestMethod.GET)
	public String AddComputer_GET(@Autowired HttpServletRequest request)
	{
		return "AddComputer";
	}
	@RequestMapping(value = {"Admin/AddComputer"}, method = RequestMethod.POST)
	public String AddComputer_POST(@Autowired HttpServletRequest request)
	{
		 Computer computer = _computerService.CreateComputer();
		 
		 String filename = request.getParameter("Image");
         try { computer.Name = request.getParameter("Name"); } catch (Exception e) { }
         try { computer.CPU = request.getParameter("CPU"); } catch (Exception e) { }
         try { computer.RAM = request.getParameter("RAM"); } catch (Exception e) { }
         try { computer.VideoCard = request.getParameter("VideoCard"); } catch (Exception e) { }
         try { computer.Hardware = request.getParameter("Hardware"); } catch (Exception e) { }
         try { computer.SlotSupport = request.getParameter("SlotSupport"); } catch (Exception e) { }
         try { computer.Display = request.getParameter("Display"); } catch (Exception e) { }
         try { computer.OS = request.getParameter("OS"); } catch (Exception e) { }
         try { computer.Type = request.getParameter("Type"); } catch (Exception e) { }
         try { computer.Trademark = request.getParameter("Trademark"); } catch (Exception e) { }
         try { computer.Feature = request.getParameter("Feature"); } catch (Exception e) { }
         try { computer.Color = request.getParameter("Color"); } catch (Exception e) { }
         try { computer.CPUSeries = request.getParameter("CPUSeries"); } catch (Exception e) { }
         try { computer.Resolution = request.getParameter("Resolution"); } catch (Exception e) { }
         try { computer.StandardOfScreen = request.getParameter("StandardOfScreen"); } catch (Exception e) { }
         try { computer.Size = request.getParameter("Size"); } catch (Exception e) { }
         try { computer.Mass = request.getParameter("Mass"); } catch (Exception e) { }
         try { computer.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
         try { computer.Price = request.getParameter("Price"); } catch (Exception e) { }
         try { computer.Description = request.getParameter("Description"); } catch (Exception e) { }
         try { computer.IsDeleted = false; } catch (Exception e) { }
         computer.Image = filename;

         if (_computerService.InsertComputer(computer))
         {
        	 return "redirect:/Admin/AdminListCompiter";
         }
         return "redirect:/Admin/AddComputer";
	}
}
