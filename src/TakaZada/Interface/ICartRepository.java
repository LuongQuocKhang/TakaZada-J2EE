package TakaZada.Interface;

import TakaZada.Model.CartDetails;

public interface ICartRepository {
	  boolean AddToCart(CartDetails details);
	  boolean RemoveCartDetail(int detailsId);
      CartDetails CreateCartDetails(String type , int CartId , String ItemId , int Quantity , String price,String Name , String Image);
      boolean DecreaseQuantity(int detailsiD);
      boolean IncreaseQuantity(int detailsiD);
}
