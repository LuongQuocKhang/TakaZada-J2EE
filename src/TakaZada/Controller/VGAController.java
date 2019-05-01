package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.VGAService;
import TakaZada.Model.Case;
import TakaZada.Model.UserLogin;
import TakaZada.Model.VGA;

@Controller
public class VGAController {
	VGAService _vgaService;
	public VGAController() {
		_vgaService = new VGAService();
	}
	@RequestMapping(value = {"/ListVGA"}, method = RequestMethod.GET)
	public String ListVGA(@Autowired HttpServletRequest request,Model model)
	{
		ArrayList<VGA> listvga = _vgaService.Load();
		request.setAttribute("ListVGA", listvga);
		request.setAttribute("domainname", request.getContextPath());
		return "ListVGA";
	}
	
	@RequestMapping(value = {"/ListVGA/{trademark}"}, method = RequestMethod.GET)
	public String ListVGAByTradeMark(@Autowired HttpServletRequest request,@PathVariable("trademark") String trademark)
	{
		ArrayList<VGA> listvga = _vgaService.LoadByTrademark(trademark);
		request.setAttribute("ListVGA", listvga);
		request.setAttribute("domainname", request.getContextPath());
		return "ListVGA";
	}
	
	@RequestMapping(value = "/VGADetail/{vgaId}", method = RequestMethod.GET)
	public String VGADetail(@Autowired HttpServletRequest request,@PathVariable("vgaId") int vgaId)
	{
		request.setAttribute("domainname", request.getContextPath());
		VGA _vga = _vgaService.LoadById(vgaId);
		request.setAttribute("VGA", _vga);
		request.setAttribute("TheSameTrademark", _vgaService.LoadTheSameTrademark(_vga.TradeMark, _vga.Id));
		
		return "VGADetail";
	}
	
	@RequestMapping(value = {"Admin/AdminListVGA"}, method = RequestMethod.GET)
	public String AdminListVGA(@Autowired HttpServletRequest request)
	{
		UserLogin user = (UserLogin)request.getSession().getAttribute("ADMIN_SESSION");
		if ( user != null )
		{
			ArrayList<VGA> listvga = _vgaService.Load();
			request.setAttribute("ListVGA", listvga);
			request.setAttribute("domainname", request.getContextPath());
			return "adminvga";
		}
		return "login";	
	}
	
	@RequestMapping(value = {"Admin/DeleteVGA/{vgaId}"}, method = RequestMethod.GET)
	public String DeleteVGA(@Autowired HttpServletRequest request,@PathVariable("vgaId") int vgaId)
	{
		_vgaService.DeleteVGA(vgaId);
		return "redirect:/Admin/AdminListVGA";
	}
	
	@RequestMapping(value = {"Admin/RestoreVGA/{vgaId}"}, method = RequestMethod.GET)
	public String RestoreVGA(@Autowired HttpServletRequest request,@PathVariable("vgaId") int vgaId)
	{
		_vgaService.RestoreVGA(vgaId);
		return "redirect:/Admin/AdminListVGA";
	}
	
	@RequestMapping(value = {"Admin/RemoveVGA/{vgaId}"}, method = RequestMethod.GET)
	public String RemoveVGA(@Autowired HttpServletRequest request,@PathVariable("vgaId") int vgaId)
	{
		_vgaService.DeleteVGAFromDeletedlist(vgaId);
		return "redirect:/Admin/AdminListVGA";
	}
	
	@RequestMapping(value = {"Admin/AdminListVGA/UpdateVGA/{vgaId}"}, method = RequestMethod.GET)
	public String UpdateCase(@Autowired HttpServletRequest request,@PathVariable("vgaId") int vgaId)
	{
		VGA _vga = _vgaService.LoadById(vgaId);
		request.setAttribute("SelectedVGA", _vga);
		return "AdminUpdateVGA";
	}
	
	@RequestMapping(value = {"Admin/AdminListVGA/UpdateVGA/"}, method = RequestMethod.POST)
	public String UpdateCase(@Autowired HttpServletRequest request)
	{
		 VGA vga = _vgaService.LoadById(Integer.parseInt(request.getParameter("Id")));

         try { vga.Name = request.getParameter("name"); } catch(Exception e){ }
         try { vga.TradeMark = request.getParameter("TradeMark"); } catch(Exception e){ }
         try { vga.Label = request.getParameter("Label"); } catch(Exception e){ }
         try { vga.ChipsetManufacturer = request.getParameter("ChipsetManufacturer"); } catch(Exception e){ }
         try { vga.Model = request.getParameter("Model"); } catch(Exception e){ }
         try { vga.VGA1 = request.getParameter("VGA"); } catch(Exception e){ }
         try { vga.BoostClock = request.getParameter("BoostClock"); } catch(Exception e){ }
         try { vga.VGAMemory = request.getParameter("VGAMemory"); } catch(Exception e){ }
         try { vga.RamType = request.getParameter("RamType"); } catch(Exception e){ }
         try { vga.MaxResolution = request.getParameter("MaxResolution"); } catch(Exception e){ }
         try { vga.Directx = request.getParameter("Directx"); } catch(Exception e){ }
         try { vga.Size = request.getParameter("Size"); } catch(Exception e){ }
         try { vga.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch(Exception e){ }
         try { vga.Description = request.getParameter("Description"); } catch(Exception e){ }

         String price = vga.Price.replace(".", "").replace("đ", "");
         
         if ( _vgaService.UpdateVGA(vga))
         {
            return "redirect:/Admin/AdminListVGA";
         }
         return "redirect:/Admin/AdminListVGA/UpdateVGA/" + vga.Id;
	}
	
	@RequestMapping(value = {"Admin/AddVGA"}, method = RequestMethod.GET)
	public String AddVGA_GET(@Autowired HttpServletRequest request)
	{
		return "AddVGA";
	}
	@RequestMapping(value = {"Admin/AddVGA"}, method = RequestMethod.POST)
	public String AddVGA_POST(@Autowired HttpServletRequest request)
	{
		VGA vga = _vgaService.CreateVGA();
		
		String filename = request.getParameter("Image");
		
        try { vga.Name = request.getParameter("name"); } catch (Exception e) { }
        try { vga.TradeMark = request.getParameter("TradeMark"); } catch (Exception e) { }
        try { vga.Label = request.getParameter("Label"); } catch (Exception e) { }
        try { vga.ChipsetManufacturer = request.getParameter("ChipsetManufacturer"); } catch (Exception e) { }
        try { vga.Model = request.getParameter("Model"); } catch (Exception e) { }
        try { vga.VGA1 = request.getParameter("VGA"); } catch (Exception e) { }
        try { vga.BoostClock = request.getParameter("BoostClock"); } catch (Exception e) { }
        try { vga.VGAMemory = request.getParameter("VGAMemory"); } catch (Exception e) { }
        try { vga.RamType = request.getParameter("RamType"); } catch (Exception e) { }
        try { vga.MaxResolution = request.getParameter("MaxResolution"); } catch (Exception e) { }
        try { vga.Directx = request.getParameter("Directx"); } catch (Exception e) { }
        try { vga.Size = request.getParameter("Size"); } catch (Exception e) { }
        try { vga.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
        try { vga.Description = request.getParameter("Description"); } catch (Exception e) { }
        vga.Image = filename;
        vga.IsDeleted = false;

        if (_vgaService.InsertVGA(vga))
        {
        	return "redirect:/Admin/AdminListVGA";
        }
		return "redirect:/Admin/AddVGA";
	}
}
