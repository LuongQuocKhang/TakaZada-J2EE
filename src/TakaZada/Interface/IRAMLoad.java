package TakaZada.Interface;
import java.util.ArrayList;

import TakaZada.Model.RAM;

public interface IRAMLoad {
	 ArrayList<RAM> Load();
	 ArrayList<RAM> LoadByTrademark(String Trademark);
	 ArrayList<RAM> LoadTheSameTrademark(String Trademark,int Id);
     RAM LoadById(int Id);
}
