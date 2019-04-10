package TakaZada.Interface;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public interface ILog
{
    boolean LogIn(HttpServletRequest request,String username, String password);
    boolean AdminLogIn(String username, String password);
    boolean Logout(HttpServletRequest request);
    boolean register(String FirstName, String LastName,String Email, String Password, String PhoneNumber, String Sex, java.util.Date DateOfBirth,String Address);
}