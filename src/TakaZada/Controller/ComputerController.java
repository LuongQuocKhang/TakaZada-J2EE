package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
