package TakaZada.Controller;
import TakaZada.Handle.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home()
	{	
		try {
			Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection_SQLJDBC();
			Statement statement = connection.createStatement();
		    String sql = "Select * from Computer";
		      
			ResultSet rs = statement.executeQuery(sql);

			 while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
		          int Id = rs.getInt(1);
		          String computername = rs.getString(2);
		          String image = rs.getString("Image");
		          System.out.println("--------------------");
		          System.out.println("Id:" + Id);
		          System.out.println("EmpNo:" + computername);
		          System.out.println("image:" + image);
		      }
			 
			System.out.println(connection);
			
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Index";
	}
}
