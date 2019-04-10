package TakaZada.Interface;

import javax.servlet.http.HttpServletRequest;

import TakaZada.Model.UserAccount;
import TakaZada.Model.UserLogin;

public interface IUser
{
    UserLogin CreateUser(String username , int Id , String type);
    UserLogin GetCurrentUser(HttpServletRequest request);
    UserLogin GetUserByEmail(String Email);
    UserAccount GetUserInfo(String Email);
}