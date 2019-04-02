package TakaZada.API;
import java.util.ArrayList;

import TakaZada.Model.RAM;

public interface IRAMLoad {
	 ArrayList<RAM> Load();
	 ArrayList<RAM> LoadByTrademark(String Trademark);
     RAM LoadById(int Id);
}
