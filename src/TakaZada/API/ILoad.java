package TakaZada.API;

import java.util.ArrayList;

public interface ILoad {
	ArrayList<TakaZada.Model.Computer> Load();
    TakaZada.Model.Computer LoadById(int Id);
    ArrayList<TakaZada.Model.Computer> LoadByTradeMark(String Trademark);
}
