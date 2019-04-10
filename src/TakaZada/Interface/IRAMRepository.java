package TakaZada.Interface;
import TakaZada.Model.RAM;

public interface IRAMRepository {
	  RAM CreateRAM();
      boolean InsertRAM(RAM RAM);
      boolean DeleteRAM(int Id);
      boolean DeleteRAMFromDeletedlist(int Id);
      boolean RestoreRAM(int Id);
      boolean UpdateRAM(RAM RAM);
}
