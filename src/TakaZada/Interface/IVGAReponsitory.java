package TakaZada.Interface;

import TakaZada.Model.VGA;

public interface IVGAReponsitory {
	VGA CreateVGA();
    boolean InsertVGA(VGA VGA);
    boolean DeleteVGA(int Id);
    boolean DeleteVGAFromDeletedlist(int Id);
    boolean RestoreVGA(int Id);
    boolean UpdateVGA(VGA VGA);
}
