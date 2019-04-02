package TakaZada.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TakaZada.Handle.SQLServerConnUtils_JTDS;
import TakaZada.Model.RAM;

public class RAMService implements IRAMLoad, IRAMRepository {

	@Override
	public RAM CreateRAM() {
		return new RAM();
	}

	@Override
	public boolean InsertRAM(RAM RAM) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection
					.prepareStatement("insert into RAM values( ? , ? , ? , ? , ? , ? , ? , ? , ?"
							+ " , ? , ? , ? , ? )");
			statement.setInt(1, RAM.Id);
			statement.setString(2, RAM.Name);
			statement.setString(3, RAM.Image);
			statement.setString(4, RAM.Description);
			statement.setString(5, RAM.TradeMark);
			statement.setString(6, RAM.Color);
			statement.setString(7, RAM.RamType);
			statement.setString(8, RAM.Memory);
			statement.setString(9, RAM.BusSpeed);
			statement.setInt(10, RAM.WarrantyPeriod);
			statement.setBoolean(11, RAM.IsDeleted);
			statement.setString(12, RAM.Price);
			statement.setInt(13, RAM.Quantity);

			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean DeleteRAM(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update ram set IsDeleted = true where Id = ?");
			statement.setString(1, Integer.toString(Id));
			statement.executeUpdate();
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
	public boolean DeleteRAMFromDeletedlist(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("delete from ram where Id = ?");
			statement.setString(1, Integer.toString(Id));
			statement.executeUpdate();
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
	public boolean RestoreRAM(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update ram set IsDelete = false where Id = ?");
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
	public boolean UpdateRAM(RAM RAM) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection
					.prepareStatement("update RAM set Name = ? , Image = ? , Description = ? , TradeMark = ? , Color = ? ,"
							+ " RamType = ? , Memory = ? , BusSpeed = ? , WarrantyPeriod = ?"
							+ " , IsDeleted = ? , Price = ? , Quantity = ? where Id = ?");

			statement.setString(1, RAM.Name);
			statement.setString(2, RAM.Image);
			statement.setString(3, RAM.Description);
			statement.setString(4, RAM.TradeMark);
			statement.setString(5, RAM.Color);
			statement.setString(6, RAM.RamType);
			statement.setString(7, RAM.Memory);
			statement.setString(8, RAM.BusSpeed);
			statement.setInt(9, RAM.WarrantyPeriod);
			statement.setBoolean(10, RAM.IsDeleted);
			statement.setString(11, RAM.Price);
			statement.setInt(12, RAM.Quantity);
			statement.setInt(13, RAM.Id);
			
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public ArrayList<RAM> Load() {
		ArrayList<TakaZada.Model.RAM> ramlist = new ArrayList<TakaZada.Model.RAM>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			Statement statement = connection.createStatement();
		    String sql = "select * from dbo.[RAM]";
		      
			ResultSet rs = statement.executeQuery(sql);

			 while (rs.next()) 
			 {
				 TakaZada.Model.RAM _ram = new TakaZada.Model.RAM();
				 _ram.Id = rs.getInt("Id");
				 _ram.Name = rs.getString("Name");
				 _ram.Image = rs.getString("Image");
				 _ram.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _ram.TradeMark = rs.getString("TradeMark");
				 _ram.Description = rs.getString("Description");
				 _ram.Color = rs.getString("Color");
				 _ram.RamType = rs.getString("RamType");
				 _ram.Memory = rs.getString("Memory");
				 _ram.BusSpeed = rs.getString("BusSpeed");
				 _ram.IsDeleted = rs.getBoolean("IsDeleted");
				 _ram.Price = rs.getString("Price");
				 _ram.Quantity = rs.getInt("Quantity");
				 
				 ramlist.add(_ram);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ramlist;
	}

	@Override
	public ArrayList<RAM> LoadByTrademark(String Trademark) {
		ArrayList<TakaZada.Model.RAM> ramlist = new ArrayList<TakaZada.Model.RAM>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from vga where Trademark = ?");
			statement.setString(1,Trademark);	
		      
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.RAM _ram = new TakaZada.Model.RAM();
				 _ram.Id = rs.getInt("Id");
				 _ram.Name = rs.getString("Name");
				 _ram.Image = rs.getString("Image");
				 _ram.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _ram.TradeMark = rs.getString("TradeMark");
				 _ram.Description = rs.getString("Description");
				 _ram.Color = rs.getString("Color");
				 _ram.RamType = rs.getString("RamType");
				 _ram.Memory = rs.getString("Memory");
				 _ram.BusSpeed = rs.getString("BusSpeed");
				 _ram.IsDeleted = rs.getBoolean("IsDeleted");
				 _ram.Price = rs.getString("Price");
				 _ram.Quantity = rs.getInt("Quantity");
				 
				 ramlist.add(_ram);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ramlist;
	}

	@Override
	public RAM LoadById(int Id) {
		ArrayList<TakaZada.Model.RAM> ramlist = new ArrayList<TakaZada.Model.RAM>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from vga where Id = ?");
			statement.setString(1,Integer.toString(Id));	
		      
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.RAM _ram = new TakaZada.Model.RAM();
				 _ram.Id = rs.getInt("Id");
				 _ram.Name = rs.getString("Name");
				 _ram.Image = rs.getString("Image");
				 _ram.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _ram.TradeMark = rs.getString("TradeMark");
				 _ram.Description = rs.getString("Description");
				 _ram.Color = rs.getString("Color");
				 _ram.RamType = rs.getString("RamType");
				 _ram.Memory = rs.getString("Memory");
				 _ram.BusSpeed = rs.getString("BusSpeed");
				 _ram.IsDeleted = rs.getBoolean("IsDeleted");
				 _ram.Price = rs.getString("Price");
				 _ram.Quantity = rs.getInt("Quantity");
				 
				 ramlist.add(_ram);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ramlist.get(0);
	}

}
