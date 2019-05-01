package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.CPUService;
import TakaZada.Model.CPU;
import TakaZada.Model.Case;
import TakaZada.Model.UserLogin;

@Controller
public class CPUController {
	CPUService _cpuService;
	public CPUController()
	{
		_cpuService = new CPUService();
	}
	@RequestMapping(value = {"/ListCPU"}, method = RequestMethod.GET)
	public String ListCPU(@Autowired HttpServletRequest request)
	{
		ArrayList<CPU> listcpu = _cpuService.Load();
		request.setAttribute("ListCPU", listcpu);
		request.setAttribute("domainname", request.getContextPath());
		return "ListCPU";
	}
	@RequestMapping(value = {"/ListCPU/{Name}"}, method = RequestMethod.GET)
	public String ListCPUByName(@Autowired HttpServletRequest request,@PathVariable("Name") String Name)
	{
		ArrayList<CPU> listcpu = _cpuService.LoadByName(Name);
		request.setAttribute("ListCPU", listcpu);
		request.setAttribute("domainname", request.getContextPath());
		return "ListCPU";
	}
	@RequestMapping(value = {"/ListCPUByTradeMark/{trademark}"}, method = RequestMethod.GET)
	public String ListCPUByTradeMark(@Autowired HttpServletRequest request,@PathVariable("trademark") String trademark)
	{
		ArrayList<CPU> listcpu;
		if ( trademark.length() > 0 )
		{
			 listcpu = _cpuService.LoadByTradeMark(trademark);
		}
		else
		{
			listcpu = _cpuService.Load();
		}
		request.setAttribute("ListCPU", listcpu);
		request.setAttribute("domainname", request.getContextPath());
		return "ListCPU";
	}
	
	@RequestMapping(value = "/CPUDetail/{cpuId}", method = RequestMethod.GET)
	public String CPUDetail(@Autowired HttpServletRequest request,@PathVariable("cpuId") int cpuId)
	{

		request.setAttribute("domainname", request.getContextPath());
		CPU _cpu = _cpuService.LoadById(cpuId);
		request.setAttribute("CPU", _cpu);
		request.setAttribute("TheSameTrademark", _cpuService.LoadTheSameTrademark(_cpu.TradeMark, _cpu.Id));
		return "CPUDetail";
	}
	@RequestMapping(value = {"Admin/AdminListCPU"}, method = RequestMethod.GET)
	public String AdminListCPU(@Autowired HttpServletRequest request)
	{
		UserLogin user = (UserLogin)request.getSession().getAttribute("ADMIN_SESSION");
		if ( user != null )
		{
			ArrayList<CPU> listcpu = _cpuService.Load();
			request.setAttribute("ListCPU", listcpu);
			request.setAttribute("domainname", request.getContextPath());
			return "admincpu";
		}
		return "login";	
	}
	
	@RequestMapping(value = {"Admin/DeleteCPU/{cpuId}"}, method = RequestMethod.GET)
	public String DeleteCPU(@Autowired HttpServletRequest request,@PathVariable("cpuId") int cpuId)
	{
		_cpuService.DeleteCPU(cpuId);
		return "redirect:/Admin/AdminListCPU";
	}
	
	@RequestMapping(value = {"Admin/RestoreCPU/{cpuId}"}, method = RequestMethod.GET)
	public String RestoreCPU(@Autowired HttpServletRequest request,@PathVariable("cpuId") int cpuId)
	{
		_cpuService.RestoreCPU(cpuId);
		return "redirect:/Admin/AdminListCPU";
	}
	
	@RequestMapping(value = {"Admin/RemoveCPU/{cpuId}"}, method = RequestMethod.GET)
	public String RemoveCPU(@Autowired HttpServletRequest request,@PathVariable("cpuId") int cpuId)
	{
		_cpuService.DeleteCPUFromDeletedlist(cpuId);
		return "redirect:/Admin/AdminListCPU";
	}
	
	@RequestMapping(value = {"Admin/AdminListCPU/UpdateCPU/{cpuId}"}, method = RequestMethod.GET)
	public String UpdateCPU(@Autowired HttpServletRequest request,@PathVariable("cpuId") int cpuId)
	{
		CPU _cpu = _cpuService.LoadById(cpuId);
		request.setAttribute("SelectedCPU", _cpu);
		return "AdminUpdateCPU";
	}
	@RequestMapping(value = {"Admin/AdminListCPU/UpdateCPU/"}, method = RequestMethod.POST)
	public String UpdateCPU(@Autowired HttpServletRequest request)
	{
		 CPU cpu = _cpuService.LoadById(Integer.parseInt(request.getParameter("Id")));

         try { cpu.Name = request.getParameter("Name"); } catch (Exception e) { }
         try { cpu.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
         try { cpu.TradeMark = request.getParameter("TradeMark"); } catch (Exception e) { }
         try { cpu.CPUType = request.getParameter("CPUType"); } catch (Exception e) { }
         try { cpu.CPULine = request.getParameter("CPULine"); } catch (Exception e) { }
         try { cpu.CoreNum = Integer.parseInt( request.getParameter("CoreNum")); } catch (Exception e) { }
         try { cpu.ThreadNum = Integer.parseInt( request.getParameter("ThreadNum")); } catch (Exception e) { }
         try { cpu.CoreCPU = request.getParameter("CoreCPU"); } catch (Exception e) { }
         try { cpu.BasicPulse = request.getParameter("BasicPulse"); } catch (Exception e) { }
         try { cpu.MaxPulse = request.getParameter("MaxPulse"); } catch (Exception e) { }
         try { cpu.CacheCPU = request.getParameter("CacheCPU"); } catch (Exception e) { }
         try { cpu.Size = request.getParameter("Size"); } catch (Exception e) { }
         try { cpu.Description = request.getParameter("Description"); } catch (Exception e) { }
         try { cpu.Price = request.getParameter("Price"); } catch (Exception e) { }

         String price = cpu.Price.replace(".", "").replace("đ", "");
       
         if ( _cpuService.UpdateCPU(cpu))
         {
            return "redirect:/Admin/AdminListCPU";
         }
		return "redirect:/Admin/AdminListCPU/UpdateCPU/" + cpu.Id;
	}
	
	@RequestMapping(value = {"Admin/AddCPU"}, method = RequestMethod.GET)
	public String AddCPU_GET(@Autowired HttpServletRequest request)
	{
		return "AddCPU";
	}
	@RequestMapping(value = {"Admin/AddCPU"}, method = RequestMethod.POST)
	public String AddCPU_POST(@Autowired HttpServletRequest request)
	{
		CPU cpu = _cpuService.CreateCPU();

		String filename = request.getParameter("Image");
        try { cpu.Name = request.getParameter("Name"); } catch (Exception e) { }
        try { cpu.WarrantyPeriod = Integer.parseInt(request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
        try { cpu.TradeMark = request.getParameter("TradeMark"); } catch (Exception e) { }
        try { cpu.CPUType = request.getParameter("CPUType"); } catch (Exception e) { }
        try { cpu.CPULine = request.getParameter("CPULine"); } catch (Exception e) { }
        try { cpu.CoreNum = Integer.parseInt(request.getParameter("CoreNum")); } catch (Exception e) { }
        try { cpu.ThreadNum = Integer.parseInt(request.getParameter("ThreadNum")); } catch (Exception e) { }
        try { cpu.CoreCPU = request.getParameter("CoreCPU"); } catch (Exception e) { }
        try { cpu.BasicPulse = request.getParameter("BasicPulse"); } catch (Exception e) { }
        try { cpu.MaxPulse = request.getParameter("MaxPulse"); } catch (Exception e) { }
        try { cpu.CacheCPU = request.getParameter("CacheCPU"); } catch (Exception e) { }
        try { cpu.Size = request.getParameter("Size"); } catch (Exception e) { }
        try { cpu.Description = request.getParameter("Description"); } catch (Exception e) { }
        try { cpu.Price = request.getParameter("Price"); } catch (Exception e) { }
        try { cpu.IsDeleted = false; } catch (Exception e) { }
        cpu.Image = filename;
        if (_cpuService.InsertCPU(cpu))
        {
            return "redirect:/Admin/AdminListCPU";
        }
		return "redirect:/Admin/AdminListCPU";
	}
}
