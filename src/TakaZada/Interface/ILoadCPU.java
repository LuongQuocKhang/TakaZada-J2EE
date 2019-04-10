package TakaZada.Interface;
import java.util.ArrayList;

import TakaZada.Model.*;

public interface ILoadCPU {
	  ArrayList<CPU> Load();
      CPU LoadById(int Id);
      ArrayList<CPU> LoadByName(String name);
      ArrayList<CPU> LoadByTradeMark(String Trademark);
      ArrayList<CPU> LoadTheSameTrademark(String Trademark,int Id);
}
