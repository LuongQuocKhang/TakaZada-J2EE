package TakaZada.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TakaZada.Handle.SQLServerConnUtils_JTDS;
import TakaZada.Interface.ICaseReponsitory;
import TakaZada.Interface.ILoadCase;
import TakaZada.Model.Case;

public class CaseService implements ILoadCase, ICaseReponsitory {

	@Override
	public Case CreateCase() {
		// TODO Auto-generated method stub
		return new Case();
	}

	@Override
	public boolean InsertCase(Case Case) {
		try
		{
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("insert into [dbo].[Case] values( ? , ? , ? , ? , ? , ? , ? , ? , ?"
					+ " , ? , ? , ? , ? , ? , ? )");
			statement.setString(1, Case.Name);
			statement.setString(2, Case.Image);
			statement.setString(3, Case.Description);
			statement.setInt(4, Case.WarrantyPeriod);
			statement.setString(5, Case.TradeMark);
			statement.setString(6, Case.Model);
			statement.setString(7, Case.Color);
			statement.setString(8, Case.Size);
			statement.setString(9, Case.MainSupport);
			statement.setString(10, Case.USB);
			statement.setString(11, Case.DriverBays);
			statement.setString(12, Case.Slots);
			statement.setBoolean(13, Case.IsDelete);
			statement.setString(14, Case.Price);
			statement.setInt(15, Case.Quantity);
			
			statement.executeUpdate();
			connection.close();
			return true;
		}
		catch(Exception e) {}
		return false;
	}

	@Override
	public boolean DeleteCase(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update [dbo].[Case] set IsDelete = ? where Id = ?");
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
	public boolean DeleteCaseFromDeletedlist(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("delete from [dbo].[Case] where Id = ?");
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
	public boolean RestoreCase(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update [dbo].[Case] set IsDelete = ? where Id = ?");
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
	public boolean UpdateCase(Case Case) {
		try
		{
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update [dbo].[Case] set Name = ? , Image = ? , Description = ? , WarrantyPeriod = ? , TradeMark = ? "
					+ ", Model = ? , Color = ? , Size = ? , MainSupport = ?"
					+ " , USB = ? , DriverBays = ? , Slots = ? , IsDelete = ? , Price = ? , Quantity = ? where Id = ? ");
			
			statement.setString(1, Case.Name);
			statement.setString(2, Case.Image);
			statement.setString(3, Case.Description);
			statement.setInt(4, Case.WarrantyPeriod);
			statement.setString(5, Case.TradeMark);
			statement.setString(6, Case.Model);
			statement.setString(7, Case.Color);
			statement.setString(8, Case.Size);
			statement.setString(9, Case.MainSupport);
			statement.setString(10, Case.USB);
			statement.setString(11, Case.DriverBays);
			statement.setString(12, Case.Slots);
			statement.setBoolean(13, Case.IsDelete);
			statement.setString(14, Case.Price);
			statement.setInt(15, Case.Quantity);
			
			statement.setInt(16, Case.Id);
			
			statement.executeUpdate();
			connection.close();
		}
		catch(Exception e) {}
		return false;
	}

	@Override
	public ArrayList<Case> Load() {
		ArrayList<TakaZada.Model.Case> caselist = new ArrayList<TakaZada.Model.Case>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			Statement statement = connection.createStatement();
		    String sql = "select * from dbo.[Case]";
		      
			ResultSet rs = statement.executeQuery(sql);

			 while (rs.next()) 
			 {
				 TakaZada.Model.Case _case = new TakaZada.Model.Case();
				 _case.Id = rs.getInt("Id");
				 _case.Name = rs.getString("Name");
				 _case.Image = rs.getString("Image");
				 _case.Description = rs.getString("Description");
				 _case.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _case.TradeMark = rs.getString("TradeMark");
				 _case.Model = rs.getString("Model");
				 _case.Color = rs.getString("Color");
				 _case.Size = rs.getString("Size");
				 _case.MainSupport = rs.getString("MainSupport");
				 _case.USB = rs.getString("USB");
				 _case.DriverBays = rs.getString("DriverBays");
				 _case.Slots = rs.getString("Slots");
				 _case.IsDelete = rs.getBoolean("IsDelete");
				 _case.Price = rs.getString("Price");
				 _case.Quantity = rs.getInt("Quantity");
				 
				 caselist.add(_case);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caselist;
	}

	@Override
	public ArrayList<Case> LoadByTrademark(String Trademark) {
		ArrayList<TakaZada.Model.Case> caselist = new ArrayList<TakaZada.Model.Case>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[Case] where Trademark = ?");
			statement.setString(1,Trademark);	
		    
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Case _case = new TakaZada.Model.Case();
				 _case.Id = rs.getInt("Id");
				 _case.Name = rs.getString("Name");
				 _case.Image = rs.getString("Image");
				 _case.Description = rs.getString("Description");
				 _case.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _case.TradeMark = rs.getString("TradeMark");
				 _case.Model = rs.getString("Model");
				 _case.Color = rs.getString("Color");
				 _case.Size = rs.getString("Size");
				 _case.MainSupport = rs.getString("MainSupport");
				 _case.USB = rs.getString("USB");
				 _case.DriverBays = rs.getString("DriverBays");
				 _case.Slots = rs.getString("Slots");
				 _case.IsDelete = rs.getBoolean("IsDelete");
				 _case.Price = rs.getString("Price");
				 _case.Quantity = rs.getInt("Quantity");
				 
				 caselist.add(_case);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caselist;
	}
	@Override
	public ArrayList<Case> LoadByName(String Name) {
		ArrayList<TakaZada.Model.Case> caselist = new ArrayList<TakaZada.Model.Case>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[Case] where CHARINDEX( ? , Name) > 0");
			statement.setString(1,Name);	
		    
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Case _case = new TakaZada.Model.Case();
				 _case.Id = rs.getInt("Id");
				 _case.Name = rs.getString("Name");
				 _case.Image = rs.getString("Image");
				 _case.Description = rs.getString("Description");
				 _case.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _case.TradeMark = rs.getString("TradeMark");
				 _case.Model = rs.getString("Model");
				 _case.Color = rs.getString("Color");
				 _case.Size = rs.getString("Size");
				 _case.MainSupport = rs.getString("MainSupport");
				 _case.USB = rs.getString("USB");
				 _case.DriverBays = rs.getString("DriverBays");
				 _case.Slots = rs.getString("Slots");
				 _case.IsDelete = rs.getBoolean("IsDelete");
				 _case.Price = rs.getString("Price");
				 _case.Quantity = rs.getInt("Quantity");
				 
				 caselist.add(_case);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caselist;
	}
	@Override
	public ArrayList<Case> LoadTheSameTrademark(String Trademark,int Id) {
		ArrayList<TakaZada.Model.Case> caselist = new ArrayList<TakaZada.Model.Case>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[Case] where Trademark = ? and Id != ?");
			statement.setString(1,Trademark);	
			statement.setInt(2,Id);	
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Case _case = new TakaZada.Model.Case();
				 _case.Id = rs.getInt("Id");
				 _case.Name = rs.getString("Name");
				 _case.Image = rs.getString("Image");
				 _case.Description = rs.getString("Description");
				 _case.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _case.TradeMark = rs.getString("TradeMark");
				 _case.Model = rs.getString("Model");
				 _case.Color = rs.getString("Color");
				 _case.Size = rs.getString("Size");
				 _case.MainSupport = rs.getString("MainSupport");
				 _case.USB = rs.getString("USB");
				 _case.DriverBays = rs.getString("DriverBays");
				 _case.Slots = rs.getString("Slots");
				 _case.IsDelete = rs.getBoolean("IsDelete");
				 _case.Price = rs.getString("Price");
				 _case.Quantity = rs.getInt("Quantity");
				 
				 caselist.add(_case);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caselist;
	}
	@Override
	public Case LoadById(int Id) {
		ArrayList<TakaZada.Model.Case> caselist = new ArrayList<TakaZada.Model.Case>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[Case] where Id = ?");
			statement.setString(1,Integer.toString(Id));	
		    
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.Case _case = new TakaZada.Model.Case();
				 _case.Id = rs.getInt("Id");
				 _case.Name = rs.getString("Name");
				 _case.Image = rs.getString("Image");
				 _case.Description = rs.getString("Description");
				 _case.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _case.TradeMark = rs.getString("TradeMark");
				 _case.Model = rs.getString("Model");
				 _case.Color = rs.getString("Color");
				 _case.Size = rs.getString("Size");
				 _case.MainSupport = rs.getString("MainSupport");
				 _case.USB = rs.getString("USB");
				 _case.DriverBays = rs.getString("DriverBays");
				 _case.Slots = rs.getString("Slots");
				 _case.IsDelete = rs.getBoolean("IsDelete");
				 _case.Price = rs.getString("Price");
				 _case.Quantity = rs.getInt("Quantity");
				 
				 caselist.add(_case);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caselist.get(0);
	}

}
