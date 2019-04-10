package TakaZada.Model;

public class UserLogin
{
    public UserLogin() { }
    public UserLogin(String username, int id , String name)
    {
        UserName = username;
        UserId = id;
        Name = name;
    }
    public String UserName;
    public int UserId;
    public String Name;
}