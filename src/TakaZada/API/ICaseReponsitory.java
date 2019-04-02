package TakaZada.API;

public interface ICaseReponsitory {
	TakaZada.Model.Case CreateCase();
     boolean InsertCase(TakaZada.Model.Case Case);
     boolean DeleteCase(int Id);
     boolean DeleteCaseFromDeletedlist(int Id);
     boolean RestoreCase(int Id);
     boolean UpdateCase(TakaZada.Model.Case Case);
}
