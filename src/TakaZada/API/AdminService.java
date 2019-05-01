package TakaZada.API;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import TakaZada.Handle.SQLServerConnUtils_JTDS;
import TakaZada.Interface.ILog;
import TakaZada.Interface.IUser;
import TakaZada.Model.UserAccount;
import TakaZada.Model.UserLogin;

public class AdminService implements IUser , ILog{

	@Override
	public boolean LogIn(HttpServletRequest request,String username, String password) {
		 if (username.length() > 0 )
         {
			 try {
					Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
					PreparedStatement statement = connection.prepareStatement("select * from [dbo].[UserAccount] where Email = ? and Password = ?");
					statement.setString(1,username);	
					statement.setString(2,password);	
					ResultSet rs = statement.executeQuery();
					boolean result = rs.next();
					
					
					request.getSession().setAttribute("USER_SESSION", GetUserByEmail(rs.getString("Email")));
					
					connection.close();
					return result;
					 
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
         }
         return false;
	}

	@Override
	public boolean AdminLogIn(String username, String password) {
		 if (username.length() > 0)
         {
             if (username.equals("admin") && password.equals("123"))
             {
                 return true;
             }
         }
         return false;
	}

	@Override
	public boolean Logout(HttpServletRequest request) {
		request.getSession().setAttribute("USER_SESSION", null);
		return true;
	}

	@Override
	public boolean register(String FirstName, String LastName, String Email, String Password, String PhoneNumber,
			String Sex, java.util.Date DateOfBirth, String Address) {
		UserAccount user = new UserAccount();
		user.FirstName = FirstName;
		user.LastName = LastName;
		user.Email = Email; 
		user.Password = Password;
		user.PhoneNumber = PhoneNumber;
		user.Sex = Sex;
		user.DateOfBirth = DateOfBirth;
		user.Address  = Address;
        String email = user.Email;
        
        try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[UserAccount] where Email = ?");
			statement.setString(1,email);	
			
			ResultSet rs = statement.executeQuery();
			if ( rs.next() ) return false;

			statement = connection.prepareStatement("insert into [dbo].[UserAccount] values( ? , ? , ? , ? , ? , ? , ? , ? )");
			statement.setString(1,user.FirstName);
			statement.setString(2,user.LastName);
			statement.setString(3,user.Email);
			statement.setString(4,user.Password);
			statement.setString(5,user.PhoneNumber);
			statement.setString(6,user.Sex);
			statement.setDate(7,(Date) user.DateOfBirth);
			statement.setString(8,user.Address);
			
			statement.executeUpdate();
			
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
	public UserLogin CreateUser(String username, int Id, String type) {
		 if ( type == "Admin")
         {
            return new UserLogin(username,Id, type);
         }
         else
         {
            return new UserLogin(username,Id, type);
         }
	}

	@Override
	public UserLogin GetCurrentUser(HttpServletRequest request) {
		 if (request.getSession().getAttribute("USER_SESSION") == null)
         {
             return null;
         }
         return (UserLogin)request.getSession().getAttribute("USER_SESSION");
	}

	@Override
	public UserLogin GetUserByEmail(String Email) {
		
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[UserAccount] where Email = ?");
			statement.setString(1,Email);	
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 UserAccount user = new UserAccount();
				 user.Id = rs.getInt("Id");
				 user.Email = rs.getString("Email");
				 user.FirstName = rs.getString("FirstName");
				 return new UserLogin(user.Email, user.Id, user.FirstName);      
		     }
			 connection.close();
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
	public UserAccount GetUserInfo(String Email) {
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			PreparedStatement statement = connection.prepareStatement("select * from [dbo].[UserAccount] where Email = ?");
			statement.setString(1,Email);	
			
			ResultSet rs = statement.executeQuery();

			 while (rs.next()) 
			 {
				 UserAccount user = new UserAccount();
				 user.Id = rs.getInt("Id");
				 user.Email = rs.getString("Email");
				 user.FirstName = rs.getString("FirstName");
				 user.LastName = rs.getString("LastName");
				 user.PhoneNumber = rs.getString("PhoneNumber");
				 user.Sex = rs.getString("Sex");
				 user.DateOfBirth = rs.getDate("DateOfBirth");
				 user.Address = rs.getString("Address");
				 
				 return user;
		     }
			 connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

}
