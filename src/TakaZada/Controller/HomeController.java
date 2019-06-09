package TakaZada.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.AdminService;
import TakaZada.API.CPUService;
import TakaZada.API.CaseService;
import TakaZada.API.ComputerService;
import TakaZada.API.RAMService;
import TakaZada.API.SearchService;
import TakaZada.API.VGAService;
import TakaZada.Interface.ISearchQuerry;
import TakaZada.Model.CPU;
import TakaZada.Model.Case;
import TakaZada.Model.Computer;
import TakaZada.Model.RAM;
import TakaZada.Model.SearchItem;
import TakaZada.Model.VGA;

@Controller
public class HomeController {
	RAMService _ramService;
	VGAService _vgaService;
	CPUService _cpuService;
	CaseService _caseService;
	ComputerService _computerService;	
	AdminService _adminService;
	ISearchQuerry _SearchService;
	
	public HomeController()
	{
		_ramService = new RAMService();
		_vgaService = new VGAService();
		_cpuService = new CPUService();
		_caseService = new CaseService();
		_computerService = new ComputerService();	
		_adminService = new AdminService();
		_SearchService = new SearchService();
	}
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String home(@Autowired HttpServletRequest request)
	{			
		ArrayList<RAM> listram = _ramService.Load();
		ArrayList<VGA> listvga = _vgaService.Load();
		ArrayList<CPU> listcpu = _cpuService.Load();
		ArrayList<Case> listcase = _caseService.Load();
		ArrayList<Computer> listconmupter = _computerService.Load();
		
		request.setAttribute("ListRAM", listram);
		request.setAttribute("ListVGA", listvga);
		request.setAttribute("ListCPU", listcpu);
		request.setAttribute("ListCase", listcase);
		request.setAttribute("ListComputer", listconmupter);
		
		request.setAttribute("domainname", request.getContextPath());
		return "homePage";
	}
	@RequestMapping(value = {"/Login"}, method = RequestMethod.POST)
	public String Login(HttpServletRequest request)
	{	
		String email = (String) request.getParameter("Email");
		String password = (String) request.getParameter("Password");
		
		if ( _adminService.LogIn(request,email, password))
		{
			request.getSession().setAttribute("USER_SESSION", _adminService.GetUserByEmail(email));
		}
		return "redirect:/";
	}
	@RequestMapping(value = {"/Search"}, method = RequestMethod.POST)
	public String Search(HttpServletRequest request)
	{	
		String type = (String) request.getParameter("SearchCondition");
		String Name = (String) request.getParameter("SearchResult");
		
		ArrayList<SearchItem> listsearchitem = _SearchService.Search(type,Name);
		request.setAttribute("ListSearchItem", listsearchitem);
		request.setAttribute("domainname", request.getContextPath());
		return "Search";
	}
	@RequestMapping(value = {"/Register"}, method = RequestMethod.POST)
	public String Register(HttpServletRequest request)
	{	
		String Email = (String) request.getParameter("EmailRes"),FirstName = (String) request.getParameter("FirstName"),LastName = (String) request.getParameter("LastName");
		String Password = (String) request.getParameter("PasswordPes"),ComfirmPas = (String) request.getParameter("ComfirmPassword");
		String Phonenumber = (String) request.getParameter("Phonenumber"), Sex = (String) request.getParameter("Sex"), Address = (String) request.getParameter("Address");
		String DateOfBirth = (String)request.getParameter("DateOfBirth");
		java.util.Date time = new Date();
		if ( Password.equals(ComfirmPas) == false)
			return "redirect:/";
		try {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			 time = format1.parse(DateOfBirth + " 00:00:00");
		}
		catch(Exception e) {}
		java.sql.Date sqlStartDate = new java.sql.Date(time.getTime());  
		 if ( _adminService.register(FirstName, LastName,Email, Password, Phonenumber,Sex,sqlStartDate, Address))
         {
			 return "redirect:/";
         }
		return "redirect:/";
	}
}
