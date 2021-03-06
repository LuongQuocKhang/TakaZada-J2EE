package TakaZada.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import TakaZada.API.AdminService;
import TakaZada.API.CartService;
import TakaZada.API.ReceiptService;
import TakaZada.Interface.ICartRepository;
import TakaZada.Interface.IUser;
import TakaZada.Model.Cart;
import TakaZada.Model.CartDetails;
import TakaZada.Model.Receipt;
import TakaZada.Model.UserAccount;
import TakaZada.Model.UserLogin;

@Controller
public class CartController {
	 private AdminService _UserService;
     private CartService _CartService;
     private ReceiptService _ReceiptService;
     public CartController()
     {
    	 _UserService = new AdminService();
         _CartService = new CartService();
         _ReceiptService = new ReceiptService();
     }
    @RequestMapping(value = {"/ShoppingCart"}, method = RequestMethod.GET)
 	public String CartPage(@Autowired HttpServletRequest request)
 	{			
    	UserLogin User = (UserLogin)_UserService.GetCurrentUser(request);
        if (User != null)
        {
            Cart cart = _CartService.LoadCartByEmail(User.UserName);
            request.setAttribute("domainname", request.getContextPath());
            request.setAttribute("Cart", cart);
            request.setAttribute("CartDetails", _CartService.LoadCartDetails(cart.CartId));
            return "ShoppingCart";
        }
        return "redirect:/";
 	}
    @RequestMapping(value = {"/AddToCart/{type}/{ItemId}/{Quantity}/{price}/{Id}/{Name}/{Image}"}, method = RequestMethod.GET)
    public String AddToCart(@Autowired HttpServletRequest request ,@PathVariable("type") String type, @PathVariable("ItemId") String ItemId, @PathVariable("Quantity") int Quantity,@PathVariable("price") String price, @PathVariable("Id") int Id, @PathVariable("Name") String Name, @PathVariable("Image") String Image)
    {
    	UserLogin user = (UserLogin)request.getSession().getAttribute("USER_SESSION");
        if (user != null)
        {
            int CartId = _CartService.LoadCartByEmail(user.UserName).CartId;
            CartDetails cartdetail = _CartService.CreateCartDetails(type, CartId, ItemId, Quantity, price, Name.replace("%20", " "), Image.replace("%20", " "));
            if (_CartService.AddToCart(cartdetail))
            {
                return "redirect:/" + type + "Detail/" + Id;
            }
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = {"/AddToCart/"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String AddtoCart(@Autowired HttpServletRequest request)
    {
    	UserLogin user = (UserLogin)request.getSession().getAttribute("USER_SESSION");
    	if ( user != null)
    	{
    		String type = request.getParameter("type"), ItemId = request.getParameter("ItemId"), price = request.getParameter("price");
    		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
    		String Name = request.getParameter("Name"), Image = request.getParameter("Image");

            int Id = Integer.parseInt(request.getParameter("Id"));
            
            int cartId = _CartService.LoadCartByEmail(user.UserName).CartId;
            CartDetails cartdetail = _CartService.CreateCartDetails(type, cartId, ItemId, Quantity, price, Name, Image);
            if (_CartService.AddToCart(cartdetail))
    		{
            	return "true";
    		}
    	}
    	return "false";
    }
    @RequestMapping(value = {"/RemoveCartDetails/"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String RemoveCartDetails(@Autowired HttpServletRequest request)
    {
    	int CartDetailId = Integer.parseInt(request.getParameter("CartDetailId"));
        try
        {
            if ( _CartService.RemoveCartDetail(CartDetailId) == true )
            {
            	return "true";
            }
            
        }
        catch (Exception e) { }
        return "false";
    }
    @RequestMapping(value = {"/DescreaseQuantity/"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String DescreaseQuantity(@Autowired HttpServletRequest request)
    {
    	int CartDetailId = Integer.parseInt(request.getParameter("CartDetailId"));
        if ( _CartService.DecreaseQuantity(CartDetailId))
        {
            return "true";
        }
        return "false";
    }
    @RequestMapping(value = {"/IncreaseQuantity/"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String IncreaseQuantity(@Autowired HttpServletRequest request)
    {
    	int CartDetailId = Integer.parseInt(request.getParameter("CartDetailId"));
        if (_CartService.IncreaseQuantity(CartDetailId))
        {
            return "true";
        }
        return "false";
    }
    @RequestMapping(value = {"/Purchase/"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String Purchase(@Autowired HttpServletRequest request)
    {
        try
        {
        	UserAccount UserInfo = _UserService.GetUserInfo((((UserLogin)request.getSession().getAttribute("USER_SESSION")).UserName));
            String Total = request.getParameter("Total");
            Receipt receipt = _ReceiptService.CreateReceipt(UserInfo.Email, UserInfo.FirstName + UserInfo.LastName, UserInfo.PhoneNumber, 15000, Double.parseDouble(Total));
            _ReceiptService.AddReceipt(receipt);

            ArrayList<CartDetails> cartdetail = _CartService.LoadCartDetails(_CartService.LoadCartByEmail(UserInfo.Email).CartId);
            for (int i = 0; i < cartdetail.size() ; i++) {
            	_ReceiptService.AddDetail(cartdetail.get(i), UserInfo);
			}
            return "true";
        }
        catch (Exception e) { }
        return "false";
    }
    
}
