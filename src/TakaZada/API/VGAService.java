package TakaZada.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TakaZada.Handle.SQLServerConnUtils_JTDS;
import TakaZada.Interface.IVGALoad;
import TakaZada.Interface.IVGAReponsitory;
import TakaZada.Model.VGA;

public class VGAService implements IVGALoad, IVGAReponsitory {

	@Override
	public VGA CreateVGA() {
		return new VGA();
	}

	@Override
	public boolean InsertVGA(VGA VGA) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection
					.prepareStatement("insert into [dbo].[VGA] values( ? , ? , ? , ? , ? , ? , ? , ? , ?"
							+ " , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			statement.setInt(1, VGA.Id);
			statement.setString(2, VGA.Name);
			statement.setString(3, VGA.Image);
			statement.setString(4, VGA.TradeMark);
			statement.setString(5, VGA.Label);
			statement.setString(6, VGA.ChipsetManufacturer);
			statement.setString(7, VGA.Model);
			statement.setString(8, VGA.VGA1);
			statement.setString(9, VGA.BoostClock);
			statement.setString(10, VGA.VGAMemory);
			statement.setString(11, VGA.RamType);
			statement.setString(12, VGA.MaxResolution);
			statement.setString(13, VGA.Directx);
			statement.setString(14, VGA.Size);
			statement.setInt(15, VGA.WarrantyPeriod);
			statement.setBoolean(16, VGA.IsDeleted);
			statement.setString(17, VGA.Price);
			statement.setString(18, VGA.Description);
			statement.setInt(19, VGA.Quantity);

			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean DeleteVGA(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update [dbo].[VGA] set IsDeleted = true where Id = ?");
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
	public boolean DeleteVGAFromDeletedlist(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("delete from [dbo].[VGA] where Id = ?");
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
	public boolean RestoreVGA(int Id) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("update [dbo].[VGA] set IsDelete = false where Id = ?");
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
	public boolean UpdateVGA(VGA VGA) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection
					.prepareStatement("update [dbo].[VGA] set ? , ? , ? , ? , ? , ? , ? , ? , ?"
							+ " , ? , ? , ? , ? , ? , ? , ? , ? where Id = ?");		
			statement.setString(1, VGA.Name);
			statement.setString(2, VGA.Image);
			statement.setString(3, VGA.TradeMark);
			statement.setString(4, VGA.Label);
			statement.setString(5, VGA.ChipsetManufacturer);
			statement.setString(6, VGA.Model);
			statement.setString(7, VGA.VGA1);
			statement.setString(8, VGA.BoostClock);
			statement.setString(9, VGA.VGAMemory);
			statement.setString(10, VGA.RamType);
			statement.setString(11, VGA.MaxResolution);
			statement.setString(12, VGA.Directx);
			statement.setString(13, VGA.Size);
			statement.setInt(14, VGA.WarrantyPeriod);
			statement.setBoolean(15, VGA.IsDeleted);
			statement.setString(16, VGA.Price);
			statement.setString(17, VGA.Description);
			statement.setInt(18, VGA.Quantity);
			statement.setInt(19, VGA.Id);
			
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public ArrayList<VGA> Load() {
		ArrayList<TakaZada.Model.VGA> vgalist = new ArrayList<TakaZada.Model.VGA>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			Statement statement = connection.createStatement();
		    String sql = "select * from dbo.[VGA]";
		      
			ResultSet rs = statement.executeQuery(sql);

			 while (rs.next()) 
			 {
				 TakaZada.Model.VGA _vga = new TakaZada.Model.VGA();
				 _vga.Id = rs.getInt("Id");
				 _vga.Name = rs.getString("Name");
				 _vga.Image = rs.getString("Image");
				 _vga.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _vga.TradeMark = rs.getString("TradeMark");
				 _vga.Label = rs.getString("Label");
				 _vga.ChipsetManufacturer = rs.getString("ChipsetManufacturer");
				 _vga.Model = rs.getString("Model");
				 _vga.VGA1 = rs.getString("VGA");
				 _vga.BoostClock = rs.getString("BoostClock");
				 _vga.VGAMemory = rs.getString("VGAMemory");
				 _vga.RamType = rs.getString("RamType");
				 _vga.MaxResolution = rs.getString("MaxResolution");
				 _vga.Directx = rs.getString("Directx");
				 _vga.Size = rs.getString("Size");
				 _vga.Description = rs.getString("Description");
				 _vga.IsDeleted = rs.getBoolean("IsDeleted");
				 _vga.Price = rs.getString("Price");
				 _vga.Quantity = rs.getInt("Quantity");
				 
				 vgalist.add(_vga);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vgalist;
	}

	@Override
	public ArrayList<VGA> LoadByTrademark(String Trademark) {
		ArrayList<TakaZada.Model.VGA> vgalist = new ArrayList<TakaZada.Model.VGA>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[VGA] where Trademark = ?");
			statement.setString(1,Trademark);		
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.VGA _vga = new TakaZada.Model.VGA();
				 _vga.Id = rs.getInt("Id");
				 _vga.Name = rs.getString("Name");
				 _vga.Image = rs.getString("Image");
				 _vga.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _vga.TradeMark = rs.getString("TradeMark");
				 _vga.Label = rs.getString("Label");
				 _vga.ChipsetManufacturer = rs.getString("ChipsetManufacturer");
				 _vga.Model = rs.getString("Model");
				 _vga.VGA1 = rs.getString("VGA");
				 _vga.BoostClock = rs.getString("BoostClock");
				 _vga.VGAMemory = rs.getString("VGAMemory");
				 _vga.RamType = rs.getString("RamType");
				 _vga.MaxResolution = rs.getString("MaxResolution");
				 _vga.Directx = rs.getString("Directx");
				 _vga.Size = rs.getString("Size");
				 _vga.Description = rs.getString("Description");
				 _vga.IsDeleted = rs.getBoolean("IsDeleted");
				 _vga.Price = rs.getString("Price");
				 _vga.Quantity = rs.getInt("Quantity");
				 
				 vgalist.add(_vga);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vgalist;
	}
	@Override
	public ArrayList<VGA> LoadTheSameTrademark(String Trademark, int Id) {
		ArrayList<TakaZada.Model.VGA> vgalist = new ArrayList<TakaZada.Model.VGA>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[VGA] where Trademark = ? and Id != ?");
			statement.setString(1,Trademark);	
			statement.setInt(2,Id);
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.VGA _vga = new TakaZada.Model.VGA();
				 _vga.Id = rs.getInt("Id");
				 _vga.Name = rs.getString("Name");
				 _vga.Image = rs.getString("Image");
				 _vga.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _vga.TradeMark = rs.getString("TradeMark");
				 _vga.Label = rs.getString("Label");
				 _vga.ChipsetManufacturer = rs.getString("ChipsetManufacturer");
				 _vga.Model = rs.getString("Model");
				 _vga.VGA1 = rs.getString("VGA");
				 _vga.BoostClock = rs.getString("BoostClock");
				 _vga.VGAMemory = rs.getString("VGAMemory");
				 _vga.RamType = rs.getString("RamType");
				 _vga.MaxResolution = rs.getString("MaxResolution");
				 _vga.Directx = rs.getString("Directx");
				 _vga.Size = rs.getString("Size");
				 _vga.Description = rs.getString("Description");
				 _vga.IsDeleted = rs.getBoolean("IsDeleted");
				 _vga.Price = rs.getString("Price");
				 _vga.Quantity = rs.getInt("Quantity");
				 
				 vgalist.add(_vga);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vgalist;
	}
	@Override
	public VGA LoadById(int Id) {
		ArrayList<TakaZada.Model.VGA> vgalist = new ArrayList<TakaZada.Model.VGA>();
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[VGA] where Id = ?");
			statement.setString(1,Integer.toString(Id));	
		    
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 TakaZada.Model.VGA _vga = new TakaZada.Model.VGA();
				 _vga.Id = rs.getInt("Id");
				 _vga.Name = rs.getString("Name");
				 _vga.Image = rs.getString("Image");
				 _vga.WarrantyPeriod = rs.getInt("WarrantyPeriod");
				 _vga.TradeMark = rs.getString("TradeMark");
				 _vga.Label = rs.getString("Label");
				 _vga.ChipsetManufacturer = rs.getString("ChipsetManufacturer");
				 _vga.Model = rs.getString("Model");
				 _vga.VGA1 = rs.getString("VGA");
				 _vga.BoostClock = rs.getString("BoostClock");
				 _vga.VGAMemory = rs.getString("VGAMemory");
				 _vga.RamType = rs.getString("RamType");
				 _vga.MaxResolution = rs.getString("MaxResolution");
				 _vga.Directx = rs.getString("Directx");
				 _vga.Size = rs.getString("Size");
				 _vga.Description = rs.getString("Description");
				 _vga.IsDeleted = rs.getBoolean("IsDeleted");
				 _vga.Price = rs.getString("Price");
				 _vga.Quantity = rs.getInt("Quantity");
				 
				 vgalist.add(_vga);
		     }
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vgalist.get(0);
	}

}
