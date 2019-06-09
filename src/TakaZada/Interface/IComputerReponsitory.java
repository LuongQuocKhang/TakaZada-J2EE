package TakaZada.Interface;
import java.util.ArrayList;

import TakaZada.Model.Computer;

public interface IComputerReponsitory {

    Computer CreateComputer();
    boolean InsertComputer(Computer computer);
    boolean DeleteComputer(int Id);
    boolean DeleteComputerFromDeletedlist(int Id);
    boolean RestoreComputer(int Id);
    boolean UpdateComputer(Computer computer);
	ArrayList<Computer> LoadByName(String Name);
}
