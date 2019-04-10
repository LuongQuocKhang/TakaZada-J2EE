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
import TakaZada.Model.Computer;

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
}
