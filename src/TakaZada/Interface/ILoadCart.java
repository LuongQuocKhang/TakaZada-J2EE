package TakaZada.Interface;

import java.util.ArrayList;

import TakaZada.Model.Cart;
import TakaZada.Model.CartDetails;

public interface ILoadCart {
	Cart LoadCartByEmail(String Email);
    ArrayList<CartDetails> LoadCartDetails(int Id);
    CartDetails LoadCartDetailById(int DetailId);
}
