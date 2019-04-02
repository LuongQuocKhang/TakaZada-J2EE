package TakaZada.API;

import java.util.ArrayList;

public interface ILoadCase {
	ArrayList<TakaZada.Model.Case> Load();
	ArrayList<TakaZada.Model.Case> LoadByTrademark(String Trademark);
	TakaZada.Model.Case LoadById(int Id);
}
