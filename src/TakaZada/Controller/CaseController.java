package TakaZada.Controller;

import java.util.ArrayList;

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
}
