package TakaZada.Interface;
import TakaZada.Model.*;
public interface ICPUReponsitory {
	  CPU CreateCPU();
      boolean InsertCPU(CPU CPU);
      boolean DeleteCPU(int Id);
      boolean DeleteCPUFromDeletedlist(int Id);
      boolean RestoreCPU(int Id);
      boolean UpdateCPU(CPU CPU);
}
