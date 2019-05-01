package TakaZada.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TakaZada.Model.CPU;
import TakaZada.Handle.SQLServerConnUtils_JTDS;
import TakaZada.Interface.ICPUReponsitory;
import TakaZada.Interface.ILoadCPU;

public class CPUService implements ILoadCPU, ICPUReponsitory {

	@Override
	public CPU CreateCPU() {
		return new CPU();
	}

	@Override
	public boolean InsertCPU(CPU CPU) {
		try
		{
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("insert into cpu values( ? , ? , ? , ? , ? , ? , ? , ? , ?"
					+ " , ? , ? , ? , ? , ? , ? , ? , ? )");
			statement.setString(1, CPU.Name);
			statement.setString(2, CPU.Image);
			statement.setInt(3, CPU.WarrantyPeriod);
			statement.setString(4, CPU.TradeMark);
			statement.setString(5, CPU.CPUType);
			statement.setString(6, CPU.CPULine);
			statement.setInt(7, CPU.CoreNum);
			statement.setInt(8, CPU.ThreadNum);
			statement.setString(9, CPU.CoreCPU);
			statement.setString(10, CPU.BasicPulse);
			statement.setString(11, CPU.MaxPulse);
			statement.setString(12, CPU.CacheCPU);
			statement.setString(13, CPU.Size);
			statement.setString(14, CPU.Description);	
			statement.setBoolean(15, CPU.IsDeleted);
			statement.setString(16, CPU.Price);
			statement.setInt(17, CPU.Quantity);
			
			statement.executeUpdate();
			connection.close();
			return true;
		}
		catch(Exception e) {}
		return false;
	}

	@Override
	public boolean DeleteCPU(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update cpu set IsDeleted = ? where Id = ?");
			statement.setBoolean(1,true);		
			statement.setString(2,Integer.toString(Id));		      
			statement.executeUpdate ();
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean DeleteCPUFromDeletedlist(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("delete from cpu where Id = ?");
			statement.setString(1,Integer.toString(Id));	      
			statement.executeUpdate ();
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean RestoreCPU(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update cpu set IsDeleted = ? where Id = ?");
			statement.setBoolean(1,false);		
			statement.setString(2,Integer.toString(Id));		      
			statement.executeUpdate ();
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean UpdateCPU(CPU CPU) {
		try
		{
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update cpu set Name = ? , Image = ? , WarrantyPeriod = ? , TradeMark = ? , CPUType = ? , "
					+ "CPULine = ? , CoreNum = ? , ThreadNum = ? , CoreCPU = ?"
					+ " , BasicPulse = ? , MaxPulse = ? , CacheCPU = ? , Size = ? , "
					+ " Description = ? , IsDeleted = ? , Price = ? , Quantity = ? where Id = ?");

			statement.setString(1, CPU.Name);
			statement.setString(2, CPU.Image);
			statement.setInt(3, CPU.WarrantyPeriod);
			statement.setString(4, CPU.TradeMark);
			statement.setString(5, CPU.CPUType);
			statement.setString(6, CPU.CPULine);
			statement.setInt(7, CPU.CoreNum);
			statement.setInt(8, CPU.ThreadNum);
			statement.setString(9, CPU.CoreCPU);
			statement.setString(10, CPU.BasicPulse);
			statement.setString(11, CPU.MaxPulse);
			statement.setString(12, CPU.CacheCPU);
			statement.setString(13, CPU.Size);
			statement.setString(14, CPU.Description);	
			statement.setBoolean(15, CPU.IsDeleted);
			statement.setString(16, CPU.Price);
			statement.setInt(17, CPU.Quantity);
			statement.setInt(18, CPU.Id);
			statement.executeUpdate();
			connection.close();
		}
		catch(Exception e) {}
		return false;
	}

	@Override
	public ArrayList<CPU> Load() {
		ArrayList<TakaZada.Model.CPU> cpulist = new ArrayList<TakaZada.Model.CPU>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			Statement statement = connection.createStatement();
		    String sql = "select * from dbo.[CPU]";
		      
			ResultSet rs = statement.executeQuery(sql);

			 while (rs.next()) 
			 {
				 TakaZada.Model.CPU _cpu = new TakaZada.Model.CPU();
				 _cpu.Id = rs.getInt("Id");
				 _cpu.Name = rs.getString("Name");
				 _cpu.Image = rs.getString("Image");
				 _cpu.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _cpu.TradeMark = rs.getString("TradeMark");
				 _cpu.CPUType = rs.getString("CPUType");
				 _cpu.CPULine = rs.getString("CPULine");
				 _cpu.CoreNum = rs.getInt("CoreNum");
				 _cpu.ThreadNum = rs.getInt("ThreadNum");
				 _cpu.CoreCPU = rs.getString("CoreCPU");
				 _cpu.BasicPulse = rs.getString("BasicPulse");
				 _cpu.MaxPulse = rs.getString("MaxPulse");
				 _cpu.CacheCPU = rs.getString("CacheCPU");
				 _cpu.Size = rs.getString("Size");
				 _cpu.Description = rs.getString("Description");
				 _cpu.IsDeleted = rs.getBoolean("IsDeleted");
				 _cpu.Price = rs.getString("Price");
				 _cpu.Quantity = rs.getInt("Quantity");
				 
				 cpulist.add(_cpu);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpulist;
	}

	@Override
	public CPU LoadById(int Id) {
		ArrayList<TakaZada.Model.CPU> cpulist = new ArrayList<TakaZada.Model.CPU>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from cpu where Id = ?");
			statement.setString(1,Integer.toString(Id));	
		    
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.CPU _cpu = new TakaZada.Model.CPU();
				 _cpu.Id = rs.getInt("Id");
				 _cpu.Name = rs.getString("Name");
				 _cpu.Image = rs.getString("Image");
				 _cpu.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _cpu.TradeMark = rs.getString("TradeMark");
				 _cpu.CPUType = rs.getString("CPUType");
				 _cpu.CPULine = rs.getString("CPULine");
				 _cpu.CoreNum = rs.getInt("CoreNum");
				 _cpu.ThreadNum = rs.getInt("ThreadNum");
				 _cpu.CoreCPU = rs.getString("CoreCPU");
				 _cpu.BasicPulse = rs.getString("BasicPulse");
				 _cpu.MaxPulse = rs.getString("MaxPulse");
				 _cpu.CacheCPU = rs.getString("CacheCPU");
				 _cpu.Size = rs.getString("Size");
				 _cpu.Description = rs.getString("Description");
				 _cpu.IsDeleted = rs.getBoolean("IsDeleted");
				 _cpu.Price = rs.getString("Price");
				 _cpu.Quantity = rs.getInt("Quantity");
				 
				 cpulist.add(_cpu);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpulist.get(0);
	}

	@Override
	public ArrayList<CPU> LoadByName(String name) {
		ArrayList<TakaZada.Model.CPU> cpulist = new ArrayList<TakaZada.Model.CPU>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from cpu where Name like ?");
			statement.setString(1, "%" + name + "%");	
		      
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.CPU _cpu = new TakaZada.Model.CPU();
				 _cpu.Id = rs.getInt("Id");
				 _cpu.Name = rs.getString("Name");
				 _cpu.Image = rs.getString("Image");
				 _cpu.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _cpu.TradeMark = rs.getString("TradeMark");
				 _cpu.CPUType = rs.getString("CPUType");
				 _cpu.CPULine = rs.getString("CPULine");
				 _cpu.CoreNum = rs.getInt("CoreNum");
				 _cpu.ThreadNum = rs.getInt("ThreadNum");
				 _cpu.CoreCPU = rs.getString("CoreCPU");
				 _cpu.BasicPulse = rs.getString("BasicPulse");
				 _cpu.MaxPulse = rs.getString("MaxPulse");
				 _cpu.CacheCPU = rs.getString("CacheCPU");
				 _cpu.Size = rs.getString("Size");
				 _cpu.Description = rs.getString("Description");
				 _cpu.IsDeleted = rs.getBoolean("IsDeleted");
				 _cpu.Price = rs.getString("Price");
				 _cpu.Quantity = rs.getInt("Quantity");
				 
				 cpulist.add(_cpu);
				 
				 cpulist.add(_cpu);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpulist;
	}

	@Override
	public ArrayList<CPU> LoadByTradeMark(String Trademark) {
		ArrayList<TakaZada.Model.CPU> cpulist = new ArrayList<TakaZada.Model.CPU>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from cpu where TradeMark = ?");
			statement.setString(1,Trademark);	
		      
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.CPU _cpu = new TakaZada.Model.CPU();
				 _cpu.Id = rs.getInt("Id");
				 _cpu.Name = rs.getString("Name");
				 _cpu.Image = rs.getString("Image");
				 _cpu.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _cpu.TradeMark = rs.getString("TradeMark");
				 _cpu.CPUType = rs.getString("CPUType");
				 _cpu.CPULine = rs.getString("CPULine");
				 _cpu.CoreNum = rs.getInt("CoreNum");
				 _cpu.ThreadNum = rs.getInt("ThreadNum");
				 _cpu.CoreCPU = rs.getString("CoreCPU");
				 _cpu.BasicPulse = rs.getString("BasicPulse");
				 _cpu.MaxPulse = rs.getString("MaxPulse");
				 _cpu.CacheCPU = rs.getString("CacheCPU");
				 _cpu.Size = rs.getString("Size");
				 _cpu.Description = rs.getString("Description");
				 _cpu.IsDeleted = rs.getBoolean("IsDeleted");
				 _cpu.Price = rs.getString("Price");
				 _cpu.Quantity = rs.getInt("Quantity");
				 
				 cpulist.add(_cpu);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpulist;
	}
	@Override
	public ArrayList<CPU> LoadTheSameTrademark(String Trademark,int Id) {
		ArrayList<TakaZada.Model.CPU> cpulist = new ArrayList<TakaZada.Model.CPU>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from cpu where Trademark = ? and Id != ?");
			statement.setString(1,Trademark);	
			statement.setInt(2,Id);
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.CPU _cpu = new TakaZada.Model.CPU();
				 _cpu.Id = rs.getInt("Id");
				 _cpu.Name = rs.getString("Name");
				 _cpu.Image = rs.getString("Image");
				 _cpu.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _cpu.TradeMark = rs.getString("TradeMark");
				 _cpu.CPUType = rs.getString("CPUType");
				 _cpu.CPULine = rs.getString("CPULine");
				 _cpu.CoreNum = rs.getInt("CoreNum");
				 _cpu.ThreadNum = rs.getInt("ThreadNum");
				 _cpu.CoreCPU = rs.getString("CoreCPU");
				 _cpu.BasicPulse = rs.getString("BasicPulse");
				 _cpu.MaxPulse = rs.getString("MaxPulse");
				 _cpu.CacheCPU = rs.getString("CacheCPU");
				 _cpu.Size = rs.getString("Size");
				 _cpu.Description = rs.getString("Description");
				 _cpu.IsDeleted = rs.getBoolean("IsDeleted");
				 _cpu.Price = rs.getString("Price");
				 _cpu.Quantity = rs.getInt("Quantity");
				 
				 cpulist.add(_cpu);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpulist;
	}
}
