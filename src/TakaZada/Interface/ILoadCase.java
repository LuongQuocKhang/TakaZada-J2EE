package TakaZada.Interface;

import java.util.ArrayList;

public interface ILoadCase {
	ArrayList<TakaZada.Model.Case> Load();
	ArrayList<TakaZada.Model.Case> LoadByTrademark(String Trademark);

    ArrayList<TakaZada.Model.Case> LoadTheSameTrademark(String Trademark,int Id);
	TakaZada.Model.Case LoadById(int Id);
}
