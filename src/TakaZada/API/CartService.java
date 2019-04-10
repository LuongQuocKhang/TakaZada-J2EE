package TakaZada.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import TakaZada.Handle.SQLServerConnUtils_JTDS;
import TakaZada.Interface.ICartRepository;
import TakaZada.Interface.ILoadCart;
import TakaZada.Model.Cart;
import TakaZada.Model.CartDetails;

public class CartService implements ICartRepository, ILoadCart {

	@Override
	public Cart LoadCartByEmail(String Email) {
		Cart cart = new Cart();
		try
		{
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[Cart] where Email = ?");
			statement.setString(1,Email);	
			
			ResultSet rs = statement.executeQuery();		
			if ( rs.next() == false)
			{
				cart.Email = Email;
				cart.TotalPrice = 0;
				statement = connection.prepareStatement("insert into [dbo].[Cart] values( ? , ? )");
				statement.setString(1,Email);	
				statement.setDouble(2, 0);
				
				statement.executeUpdate();
			}
			else
			{
				cart.CartId = rs.getInt("CartId");
				cart.Email = rs.getString("Email");
				cart.TotalPrice = rs.getDouble("TotalPrice");
			}
		}
		catch(Exception e) {}
		return cart;
	}

	@Override
	public ArrayList<CartDetails> LoadCartDetails(int Id) {
		Connection connection;
		ArrayList<CartDetails> CartDetails = new ArrayList<CartDetails>();
		try {
			connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[CartDetails] where CartId = ?");
			statement.setInt(1,Id);	
			
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				CartDetails detail = new CartDetails();
				detail.ID = rs.getInt("ID");
				detail.CartId = rs.getInt("CartId");
				detail.Quantity = rs.getInt("Quantity");
				detail.type = rs.getString("type");
				detail.ItemId = rs.getString("ItemId");
				detail.price = rs.getString("price");
				detail.Name = rs.getString("Name");
				detail.Image = rs.getString("Image");
				
				CartDetails.add(detail);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return CartDetails;
	}

	@Override
	public CartDetails LoadCartDetailById(int DetailId) {
		Connection connection;
		try {
			connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[CartDetails] where ID = ?");
			statement.setInt(1,DetailId);	
			
			ResultSet rs = statement.executeQuery();
			if ( rs.next() )
			{
				CartDetails detail = new CartDetails();
				detail.ID = rs.getInt("ID");
				detail.CartId = rs.getInt("CartId");
				detail.Quantity = rs.getInt("Quantity");
				detail.type = rs.getString("type");
				detail.ItemId = rs.getString("ItemId");
				detail.price = rs.getString("price");
				detail.Name = rs.getString("Name");
				detail.Image = rs.getString("Image");
				
				return detail;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean AddToCart(CartDetails details) {
		Connection connection;
		try {
			connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[CartDetails] where ItemId = ? and type = ? and cartId = ?");
			statement.setInt(1,Integer.parseInt(details.ItemId));	
			statement.setString(2, details.type);
			statement.setInt(3, details.CartId);
			
			ResultSet rs = statement.executeQuery();
			
			int detailId = 0;
			boolean flag = false;
			
			if ( rs.next() == true )
			{
				flag = true;
				detailId = rs.getInt("ID");
			}
					
			int ItemId = Integer.parseInt(details.ItemId);
			switch(details.type)
			{
				case "Case" :
					statement = connection.prepareStatement("select * from [dbo].[Case] where ID = ?");
					statement.setString(1, details.ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Case] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - details.Quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "Computer" :
					statement = connection.prepareStatement("select * from [dbo].[Computer] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Computer] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - details.Quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "CPU" :
					statement = connection.prepareStatement("select * from [dbo].[CPU] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[CPU] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - details.Quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "RAM" :
					statement = connection.prepareStatement("select * from [dbo].[RAM] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[RAM] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - details.Quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "VGA" :
					statement = connection.prepareStatement("select * from [dbo].[VGA] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[VGA] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - details.Quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
			}
			
			if ( flag == false)
			{
				statement = connection.prepareStatement("insert into [dbo].[CartDetails] values( ? , ? , ? , ? , ? , ? , ? )");
				statement.setString(1,details.type);	
				statement.setInt(2,details.CartId);	
				statement.setString(3,details.ItemId);	
				statement.setInt(4,details.Quantity);	
				statement.setString(5,details.price);	
				statement.setString(6,details.Name);	
				statement.setString(7,details.Image);	
				
				statement.executeUpdate();
			}
			else
			{
				statement = connection.prepareStatement("select * from [dbo].[CartDetails] where ItemId = ? and type = ? and cartId = ?");
				statement.setInt(1,Integer.parseInt(details.ItemId));	
				statement.setString(2, details.type);
				statement.setInt(3, details.CartId);
				
				rs = statement.executeQuery();
				if ( rs.next())
				{
					int quantiy = rs.getInt("Quantity") + details.Quantity;
					
					statement = connection.prepareStatement("update [dbo].[CartDetails] set Quantity = ? where ID = ?");
					statement.setInt(2, detailId);
					
					statement.setInt(1, quantiy);
					statement.executeUpdate();
				}
			}
			
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean RemoveCartDetail(int detailsId) {
		Connection connection;
		try {
			connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[CartDetails] where ID = ?");
			statement.setInt(1,detailsId);	
			ResultSet rs = statement.executeQuery();
			int quantity = 0, ItemId = 0;
			String type = "" ;
			if ( rs.next())
			{
				quantity = rs.getInt("Quantity");
				type = rs.getString("type");
				ItemId = Integer.parseInt( rs.getString("itemId"));
			}
			
			statement = connection.prepareStatement("delete from [dbo].[CartDetails] where ID = ?");
			statement.executeUpdate();

			switch(type)
			{
				case "Case" :
					statement = connection.prepareStatement("select * from [dbo].[Case] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Case] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "Computer" :
					statement = connection.prepareStatement("select * from [dbo].[Computer] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Computer] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "CPU" :
					statement = connection.prepareStatement("select * from [dbo].[CPU] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[CPU] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "RAM" :
					statement = connection.prepareStatement("select * from [dbo].[RAM] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[RAM] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "VGA" :
					statement = connection.prepareStatement("select * from [dbo].[VGA] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[VGA] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + quantity);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
			}
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public CartDetails CreateCartDetails(String type, int CartId, String ItemId, int Quantity, String price,
			String Name, String Image) {
		CartDetails cartdetail = new CartDetails();
		cartdetail.type = type;
		cartdetail.CartId = CartId;
		cartdetail.ItemId = ItemId;
		cartdetail.Quantity = Quantity;
		cartdetail.price = price;
		cartdetail.Name  = Name;
		cartdetail.Image = Image;
		return cartdetail;
	}

	@Override
	public boolean DecreaseQuantity(int detailsiD) {
		Connection connection;
		try {
			connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[CartDetails] where ID = ?");
			statement.setInt(1,detailsiD);	
			
			ResultSet rs = statement.executeQuery();
			
			String type = "";
			int ItemId = 0;
			if ( rs.next() == false)
			{
				return false;
			}
			else
			{
				type = rs.getString("type");
				ItemId = Integer.parseInt(rs.getString("ItemId"));
				statement = connection.prepareStatement("update [dbo].[CartDetails] set Quantity = ?");
				int quantiy = rs.getInt("Quantity") - 1;
				statement.setInt(1, quantiy);
			}
			
			switch(type)
			{
				case "Case" :
					statement = connection.prepareStatement("select * from [dbo].[Case] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Case] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "Computer" :
					statement = connection.prepareStatement("select * from [dbo].[Computer] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Computer] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "CPU" :
					statement = connection.prepareStatement("select * from [dbo].[CPU] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[CPU] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "RAM" :
					statement = connection.prepareStatement("select * from [dbo].[RAM] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[RAM] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "VGA" :
					statement = connection.prepareStatement("select * from [dbo].[VGA] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[VGA] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity + 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
			}
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean IncreaseQuantity(int detailsiD) {
		Connection connection;
		try {
			connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[CartDetails] where ID = ?");
			statement.setInt(1,detailsiD);	
			
			ResultSet rs = statement.executeQuery();
			
			String type = "";
			int ItemId = 0;
			if ( rs.next() == false)
			{
				return false;
			}
			else
			{
				type = rs.getString("type");
				ItemId = Integer.parseInt(rs.getString("ItemId"));
				statement = connection.prepareStatement("update [dbo].[CartDetails] set Quantity = ?");
				int quantiy = rs.getInt("Quantity") + 1;
				statement.setInt(1, quantiy);
			}
			
			switch(type)
			{
				case "Case" :
					statement = connection.prepareStatement("select * from [dbo].[Case] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Case] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "Computer" :
					statement = connection.prepareStatement("select * from [dbo].[Computer] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[Computer] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "CPU" :
					statement = connection.prepareStatement("select * from [dbo].[CPU] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[CPU] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "RAM" :
					statement = connection.prepareStatement("select * from [dbo].[RAM] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[RAM] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
				case "VGA" :
					statement = connection.prepareStatement("select * from [dbo].[VGA] where ID = ?");
					statement.setInt(1, ItemId);
					rs = statement.executeQuery();
					
					if (rs.next())
					{
						int Quantity = rs.getInt("Quantity");
						if ( Quantity <= 0 ) return false;
						int Id = rs.getInt("Id");
						
						statement = connection.prepareStatement("update [dbo].[VGA] set Quantity = ? where Id = ?");
						statement.setInt(1, Quantity - 1);
						statement.setInt(2, Id);
						statement.executeUpdate();
					}		
					break;
			}
			
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
