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
import TakaZada.Model.Computer;

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
}
