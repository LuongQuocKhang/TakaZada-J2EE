package TakaZada.API;

import java.util.ArrayList;
import TakaZada.Model.VGA;

public interface IVGALoad {
	 ArrayList<VGA> Load();
	 ArrayList<VGA> LoadByTrademark(String Trademark);
     VGA LoadById(int Id);
}
