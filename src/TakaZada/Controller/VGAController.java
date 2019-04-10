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
import TakaZada.API.VGAService;
import TakaZada.Model.Computer;
import TakaZada.Model.RAM;
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
}
