package TakaZada.Controller;

import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.CaseService;
import TakaZada.Model.Case;
import TakaZada.Model.Computer;
import TakaZada.Model.UserLogin;

@Controller
public class CaseController {
	CaseService _caseService;
	
	public CaseController()
	{
		_caseService = new CaseService();
	}
	@RequestMapping(value = {"/ListCase"}, method = RequestMethod.GET)
	public String ListCase(@Autowired HttpServletRequest request,Model model)
	{
		ArrayList<Case> listcase = _caseService.Load();
		request.setAttribute("ListCase", listcase);
		request.setAttribute("domainname", request.getContextPath());
		return "ListCase";
	}
	
	@RequestMapping(value = {"/ListCase/{trademark}"}, method = RequestMethod.GET)
	public String ListCaseByTradeMark(@Autowired HttpServletRequest request,@PathVariable("trademark") String trademark)
	{
		ArrayList<Case> listcase = _caseService.LoadByTrademark(trademark.replace("%20", " "));
		request.setAttribute("ListCase", listcase);
		request.setAttribute("domainname", request.getContextPath());
		return "ListCase";
	}
	
	@RequestMapping(value = "/CaseDetail/{caseId}", method = RequestMethod.GET)
	public String CaseDetail(@Autowired HttpServletRequest request,@PathVariable("caseId") int caseId)
	{
		request.setAttribute("domainname", request.getContextPath());
		Case _case = _caseService.LoadById(caseId);
		request.setAttribute("Case", _case);
		request.setAttribute("TheSameTrademark", _caseService.LoadTheSameTrademark(_case.TradeMark, _case.Id));
		return "CaseDetail";
	}
	
	//	Controller for admin
	
	@RequestMapping(value = {"Admin/AdminListCase"}, method = RequestMethod.GET)
	public String AdminListCasePage(@Autowired HttpServletRequest request)
	{
		UserLogin user = (UserLogin)request.getSession().getAttribute("ADMIN_SESSION");
		if ( user != null )
		{
			ArrayList<Case> listcase = _caseService.Load();
			request.setAttribute("ListCase", listcase);
			request.setAttribute("domainname", request.getContextPath());
			return "admincase";
		}
		return "login";	
	}
	@RequestMapping(value = {"Admin/DeleteCase/{caseId}"}, method = RequestMethod.GET)
	public String DeleteCase(@Autowired HttpServletRequest request,@PathVariable("caseId") int caseId)
	{
		_caseService.DeleteCase(caseId);
		return "redirect:/Admin/AdminListCase";
	}
	
	@RequestMapping(value = {"Admin/RestoreCase/{caseId}"}, method = RequestMethod.GET)
	public String RestoreCase(@Autowired HttpServletRequest request,@PathVariable("caseId") int caseId)
	{
		_caseService.RestoreCase(caseId);
		return "redirect:/Admin/AdminListCase";
	}
	
	@RequestMapping(value = {"Admin/RemoveCase/{caseId}"}, method = RequestMethod.GET)
	public String RemoveCase(@Autowired HttpServletRequest request,@PathVariable("caseId") int caseId)
	{
		_caseService.DeleteCaseFromDeletedlist(caseId);
		return "redirect:/Admin/AdminListCase";
	}
	@RequestMapping(value = {"Admin/AdminListCase/UpdateCase/{caseId}"}, method = RequestMethod.GET)
	public String UpdateCase(@Autowired HttpServletRequest request,@PathVariable("caseId") int caseId)
	{
		Case _case = _caseService.LoadById(caseId);
		request.setAttribute("SelectedCase", _case);
		return "AdminUpdateCase";
	}
	
	@RequestMapping(value = {"Admin/AdminListCase/UpdateCase/"}, method = RequestMethod.POST)
	public String UpdateCase(@Autowired HttpServletRequest request)
	{
		 int Id = Integer.parseInt((String) request.getParameter("Id"));
         Case Case = _caseService.LoadById(Id);
         
         try { Case.Name = (String) request.getParameter("Name"); } catch (Exception e) { }
         try { Case.WarrantyPeriod = Integer.parseInt((String) request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
         try { Case.TradeMark = (String) request.getParameter("TradeMark"); } catch (Exception e) { }
         try { Case.Model = (String) request.getParameter("Model"); } catch (Exception e) { }
         try { Case.Color = (String) request.getParameter("Color"); } catch (Exception e) { }
         try { Case.Size = (String) request.getParameter("Size"); } catch (Exception e) { }
         try { Case.MainSupport = (String) request.getParameter("MainSupport"); } catch (Exception e) { }
         try { Case.USB = (String) request.getParameter("USB"); } catch (Exception e) { }
         try { Case.DriverBays = (String) request.getParameter("DriverBays"); } catch (Exception e) { }
         try { Case.Slots = (String) request.getParameter("Slots"); } catch (Exception e) { }
         try { Case.Price = (String) request.getParameter("Price"); } catch (Exception e) { }
         try { Case.Description = (String) request.getParameter("Description"); } catch (Exception e) { }
        
         if ( _caseService.UpdateCase(Case))
         {
            
        	 return "redirect:/Admin/AdminListCase";
         }
		return "redirect:/Admin/AdminListCase";
	}
	@RequestMapping(value = {"Admin/AddCase"}, method = RequestMethod.GET)
	public String AddCase_GET(@Autowired HttpServletRequest request)
	{
		return "AddCase";
	}
	
	@RequestMapping(value = {"Admin/AddCase"}, method = RequestMethod.POST)
	public String AddCase_POST(@Autowired HttpServletRequest request)
	{
		Case Case = _caseService.CreateCase();
        
        String filename = request.getParameter("Image");
        
        try { Case.Name = (String) request.getParameter("Name"); } catch (Exception e) { }
        try { Case.WarrantyPeriod = Integer.parseInt((String) request.getParameter("WarrantyPeriod")); } catch (Exception e) { }
        try { Case.TradeMark = (String) request.getParameter("TradeMark"); } catch (Exception e) { }
        try { Case.Model = (String) request.getParameter("Model"); } catch (Exception e) { }
        try { Case.Color = (String) request.getParameter("Color"); } catch (Exception e) { }
        try { Case.Size = (String) request.getParameter("Size"); } catch (Exception e) { }
        try { Case.MainSupport = (String) request.getParameter("MainSupport"); } catch (Exception e) { }
        try { Case.USB = (String) request.getParameter("USB"); } catch (Exception e) { }
        try { Case.DriverBays = (String) request.getParameter("DriverBays"); } catch (Exception e) { }
        try { Case.Slots = (String) request.getParameter("Slots"); } catch (Exception e) { }
        try { Case.Price = (String) request.getParameter("Price"); } catch (Exception e) { }
        try { Case.Description = (String) request.getParameter("Description"); } catch (Exception e) { }
        Case.IsDelete = false;
        Case.Image = filename;
        
        if (_caseService.InsertCase(Case))
        {
            return "redirect:/Admin/AdminListCase";
        }
		return "redirect:/Admin/AddCase";
	}
}
