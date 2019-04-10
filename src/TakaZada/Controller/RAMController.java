package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TakaZada.API.RAMService;
import TakaZada.Model.Computer;
import TakaZada.Model.RAM;

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
}
