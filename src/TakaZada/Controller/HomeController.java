package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.CPUService;
import TakaZada.API.CaseService;
import TakaZada.API.ComputerService;
import TakaZada.API.RAMService;
import TakaZada.API.VGAService;
import TakaZada.Model.CPU;
import TakaZada.Model.Case;
import TakaZada.Model.Computer;
import TakaZada.Model.RAM;
import TakaZada.Model.VGA;

@Controller
public class HomeController {
	RAMService _ramService;
	VGAService _vgaService;
	CPUService _cpuService;
	CaseService _caseService;
	ComputerService _computerService;	
	
	public HomeController()
	{
		_ramService = new RAMService();
		_vgaService = new VGAService();
		_cpuService = new CPUService();
		_caseService = new CaseService();
		_computerService = new ComputerService();	
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
	@RequestMapping(value = {"/Login"}, method = RequestMethod.GET)
	public String Login(@Autowired HttpServletRequest request)
	{	
		return "Login";
	}
}
