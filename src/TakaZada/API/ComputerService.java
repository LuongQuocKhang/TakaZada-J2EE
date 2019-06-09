package TakaZada.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TakaZada.Handle.SQLServerConnUtils_JTDS;
import TakaZada.Interface.IComputerReponsitory;
import TakaZada.Interface.ILoad;

public class ComputerService implements IComputerReponsitory , ILoad{

	@Override
	public ArrayList<TakaZada.Model.Computer> Load() {
		ArrayList<TakaZada.Model.Computer> computerlist = new ArrayList<TakaZada.Model.Computer>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			Statement statement = connection.createStatement();
		    String sql = "select * from dbo.[Computer]";
		      
			ResultSet rs = statement.executeQuery(sql);

			 while (rs.next()) 
			 {
				 TakaZada.Model.Computer _computer = new TakaZada.Model.Computer();
				 _computer.Id = rs.getInt("Id");
				 _computer.Name = rs.getString("Name");
				 _computer.Image = rs.getString("Image");
				 _computer.CPU = rs.getString("CPU");
				 _computer.RAM = rs.getString("RAM");
				 _computer.VideoCard = rs.getString("VideoCard");
				 _computer.Hardware = rs.getString("Hardware");
				 _computer.SlotSupport = rs.getString("SlotSupport");
				 _computer.Display = rs.getString("Display");
				 _computer.Port = rs.getString("Port");
				 _computer.Extra = rs.getString("Extra");
				 _computer.OS = rs.getString("OS");
				 _computer.Type = rs.getString("Type");
				 _computer.Trademark = rs.getString("Trademark");
				 _computer.Feature = rs.getString("Feature");
				 _computer.Color = rs.getString("Color");
				 _computer.CPUSeries = rs.getString("CPUSeries");
				 _computer.ScreenSize = rs.getString("ScreenSize");
				 _computer.Resolution = rs.getString("Resolution");
				 _computer.StandardOfScreen = rs.getString("StandardOfScreen");
				 _computer.Size = rs.getString("Size");
				 _computer.Mass = rs.getString("Mass");
				 _computer.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _computer.IsDeleted = rs.getBoolean("IsDeleted");
				 _computer.Price = rs.getString("Price");
				 _computer.Description = rs.getString("Description");
				 _computer.Quantity = rs.getInt("Quantity");
				 
				 computerlist.add(_computer);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computerlist;
	}

	@Override
	public TakaZada.Model.Computer LoadById(int Id) {
		ArrayList<TakaZada.Model.Computer> computerlist = new ArrayList<TakaZada.Model.Computer>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from computer where Id = ?");
			statement.setString(1,Integer.toString(Id));	
		      
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Computer _computer = new TakaZada.Model.Computer();
				 _computer.Id = rs.getInt("Id");
				 _computer.Name = rs.getString("Name");
				 _computer.Image = rs.getString("Image");
				 _computer.CPU = rs.getString("CPU");
				 _computer.RAM = rs.getString("RAM");
				 _computer.VideoCard = rs.getString("VideoCard");
				 _computer.Hardware = rs.getString("Hardware");
				 _computer.SlotSupport = rs.getString("SlotSupport");
				 _computer.Display = rs.getString("Display");
				 _computer.Port = rs.getString("Port");
				 _computer.Extra = rs.getString("Extra");
				 _computer.OS = rs.getString("OS");
				 _computer.Type = rs.getString("Type");
				 _computer.Trademark = rs.getString("Trademark");
				 _computer.Feature = rs.getString("Feature");
				 _computer.Color = rs.getString("Color");
				 _computer.CPUSeries = rs.getString("CPUSeries");
				 _computer.ScreenSize = rs.getString("ScreenSize");
				 _computer.Resolution = rs.getString("Resolution");
				 _computer.StandardOfScreen = rs.getString("StandardOfScreen");
				 _computer.Size = rs.getString("Size");
				 _computer.Mass = rs.getString("Mass");
				 _computer.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _computer.IsDeleted = rs.getBoolean("IsDeleted");
				 _computer.Price = rs.getString("Price");
				 _computer.Description = rs.getString("Description");
				 _computer.Quantity = rs.getInt("Quantity");
				 
				 computerlist.add(_computer);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computerlist.get(0);
	}

	@Override
	public ArrayList<TakaZada.Model.Computer> LoadTheSameTrademark(String Trademark,int Id) {
		ArrayList<TakaZada.Model.Computer> computerlist = new ArrayList<TakaZada.Model.Computer>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from computer where Trademark = ? and Id != ?");
			statement.setString(1,Trademark);	
			statement.setInt(2,Id);
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Computer _computer = new TakaZada.Model.Computer();
				 _computer.Id = rs.getInt("Id");
				 _computer.Name = rs.getString("Name");
				 _computer.Image = rs.getString("Image");
				 _computer.CPU = rs.getString("CPU");
				 _computer.RAM = rs.getString("RAM");
				 _computer.VideoCard = rs.getString("VideoCard");
				 _computer.Hardware = rs.getString("Hardware");
				 _computer.SlotSupport = rs.getString("SlotSupport");
				 _computer.Display = rs.getString("Display");
				 _computer.Port = rs.getString("Port");
				 _computer.Extra = rs.getString("Extra");
				 _computer.OS = rs.getString("OS");
				 _computer.Type = rs.getString("Type");
				 _computer.Trademark = rs.getString("Trademark");
				 _computer.Feature = rs.getString("Feature");
				 _computer.Color = rs.getString("Color");
				 _computer.CPUSeries = rs.getString("CPUSeries");
				 _computer.ScreenSize = rs.getString("ScreenSize");
				 _computer.Resolution = rs.getString("Resolution");
				 _computer.StandardOfScreen = rs.getString("StandardOfScreen");
				 _computer.Size = rs.getString("Size");
				 _computer.Mass = rs.getString("Mass");
				 _computer.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _computer.IsDeleted = rs.getBoolean("IsDeleted");
				 _computer.Price = rs.getString("Price");
				 _computer.Description = rs.getString("Description");
				 _computer.Quantity = rs.getInt("Quantity");
				 
				 computerlist.add(_computer);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computerlist;
	}
	@Override
	public ArrayList<TakaZada.Model.Computer> LoadByTradeMark(String Trademark) {
		ArrayList<TakaZada.Model.Computer> computerlist = new ArrayList<TakaZada.Model.Computer>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from computer where Trademark = ?");
			statement.setString(1,Trademark);
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Computer _computer = new TakaZada.Model.Computer();
				 _computer.Id = rs.getInt("Id");
				 _computer.Name = rs.getString("Name");
				 _computer.Image = rs.getString("Image");
				 _computer.CPU = rs.getString("CPU");
				 _computer.RAM = rs.getString("RAM");
				 _computer.VideoCard = rs.getString("VideoCard");
				 _computer.Hardware = rs.getString("Hardware");
				 _computer.SlotSupport = rs.getString("SlotSupport");
				 _computer.Display = rs.getString("Display");
				 _computer.Port = rs.getString("Port");
				 _computer.Extra = rs.getString("Extra");
				 _computer.OS = rs.getString("OS");
				 _computer.Type = rs.getString("Type");
				 _computer.Trademark = rs.getString("Trademark");
				 _computer.Feature = rs.getString("Feature");
				 _computer.Color = rs.getString("Color");
				 _computer.CPUSeries = rs.getString("CPUSeries");
				 _computer.ScreenSize = rs.getString("ScreenSize");
				 _computer.Resolution = rs.getString("Resolution");
				 _computer.StandardOfScreen = rs.getString("StandardOfScreen");
				 _computer.Size = rs.getString("Size");
				 _computer.Mass = rs.getString("Mass");
				 _computer.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _computer.IsDeleted = rs.getBoolean("IsDeleted");
				 _computer.Price = rs.getString("Price");
				 _computer.Description = rs.getString("Description");
				 _computer.Quantity = rs.getInt("Quantity");
				 
				 computerlist.add(_computer);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computerlist;
	}
	@Override
	public TakaZada.Model.Computer CreateComputer() {
		return new TakaZada.Model.Computer();
	}

	@Override
	public boolean InsertComputer(TakaZada.Model.Computer computer) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("insert into computer values( ? , ? , ? , ? , ? , ? , ? , ? , ?"
					+ " , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?"
					+ " , ? , ? , ?)");	  
			statement.setString(1,computer.Name);
			statement.setString(2,computer.Image);
			statement.setString(3,computer.CPU);
			statement.setString(4,computer.RAM);
			statement.setString(5,computer.VideoCard);
			statement.setString(6,computer.Hardware);
			statement.setString(7,computer.SlotSupport);
			statement.setString(8,computer.Display);
			statement.setString(9,computer.Port);
			statement.setString(10,computer.Extra);
			statement.setString(11,computer.OS);
			statement.setString(12,computer.Type);
			statement.setString(13,computer.Trademark);
			statement.setString(14,computer.Feature);
			statement.setString(15,computer.Color);
			statement.setString(16,computer.CPUSeries);
			statement.setString(17,computer.ScreenSize);
			statement.setString(18,computer.Resolution);
			statement.setString(19,computer.StandardOfScreen);
			statement.setString(20,computer.Size);
			statement.setString(21,computer.Mass);
			statement.setInt(22,computer.WarrantyPeriod);
			statement.setBoolean(23,computer.IsDeleted);
			statement.setString(24,computer.Price);
			statement.setString(25,computer.Description);
			statement.setInt(26,computer.Quantity);
			
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
	public boolean DeleteComputer(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update computer set IsDeleted = ? where Id = ?");
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
	public boolean DeleteComputerFromDeletedlist(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("delete from computer where Id = ?");
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
	public boolean RestoreComputer(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update computer set IsDeleted = ? where Id = ?");
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
	public boolean UpdateComputer(TakaZada.Model.Computer computer) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update computer set "
					+ "Name = ?" + " ,Image = ?" + " ,CPU = ?" + " ,RAM = ?" + " ,VideoCard = ?" + " ,Hardware = ?" + " ,SlotSupport = ?" + " ,Display = ?" + " ,Port = ?"
					+ " ,Extra = ?" + " ,OS = ?" + " ,Type = ?" + " ,Trademark = ?" + " ,Feature = ?" + " ,Color = ?" + " ,CPUSeries = ?" + " ,ScreenSize = ?" + " ,Resolution = ?"
					+ " ,StandardOfScreen = ?" + " ,Size = ?" + " ,Mass = ?" + " ,WarrantyPeriod = ?" + " ,IsDeleted = ? " + " ,Price = ?" + " ,Description = ?" + " ,Quantity = ?"
					+ " where Id = ?");
			statement.setString(1,computer.Name);
			statement.setString(2,computer.Image);
			statement.setString(3,computer.CPU);
			statement.setString(4,computer.RAM);
			statement.setString(5,computer.VideoCard);
			statement.setString(6,computer.Hardware);
			statement.setString(7,computer.SlotSupport);
			statement.setString(8,computer.Display);
			statement.setString(9,computer.Port);
			statement.setString(10,computer.Extra);
			statement.setString(11,computer.OS);
			statement.setString(12,computer.Type);
			statement.setString(13,computer.Trademark);
			statement.setString(14,computer.Feature);
			statement.setString(15,computer.Color);
			statement.setString(16,computer.CPUSeries);
			statement.setString(17,computer.ScreenSize);
			statement.setString(18,computer.Resolution);
			statement.setString(19,computer.StandardOfScreen);
			statement.setString(20,computer.Size);
			statement.setString(21,computer.Mass);
			statement.setInt(22,computer.WarrantyPeriod);
			statement.setBoolean(23,computer.IsDeleted);
			statement.setString(24,computer.Price);
			statement.setString(25,computer.Description);
			statement.setInt(26,computer.Quantity);
			
			statement.setInt(27,computer.Id);		      
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
	public ArrayList<TakaZada.Model.Computer> LoadByName(String Name) {
		ArrayList<TakaZada.Model.Computer> computerlist = new ArrayList<TakaZada.Model.Computer>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from computer where CHARINDEX( ? , Name) > 0");
			statement.setString(1,Name);
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Computer _computer = new TakaZada.Model.Computer();
				 _computer.Id = rs.getInt("Id");
				 _computer.Name = rs.getString("Name");
				 _computer.Image = rs.getString("Image");
				 _computer.CPU = rs.getString("CPU");
				 _computer.RAM = rs.getString("RAM");
				 _computer.VideoCard = rs.getString("VideoCard");
				 _computer.Hardware = rs.getString("Hardware");
				 _computer.SlotSupport = rs.getString("SlotSupport");
				 _computer.Display = rs.getString("Display");
				 _computer.Port = rs.getString("Port");
				 _computer.Extra = rs.getString("Extra");
				 _computer.OS = rs.getString("OS");
				 _computer.Type = rs.getString("Type");
				 _computer.Trademark = rs.getString("Trademark");
				 _computer.Feature = rs.getString("Feature");
				 _computer.Color = rs.getString("Color");
				 _computer.CPUSeries = rs.getString("CPUSeries");
				 _computer.ScreenSize = rs.getString("ScreenSize");
				 _computer.Resolution = rs.getString("Resolution");
				 _computer.StandardOfScreen = rs.getString("StandardOfScreen");
				 _computer.Size = rs.getString("Size");
				 _computer.Mass = rs.getString("Mass");
				 _computer.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _computer.IsDeleted = rs.getBoolean("IsDeleted");
				 _computer.Price = rs.getString("Price");
				 _computer.Description = rs.getString("Description");
				 _computer.Quantity = rs.getInt("Quantity");
				 
				 computerlist.add(_computer);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computerlist;
	}
}
