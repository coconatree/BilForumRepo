package PojoClasses;


import APIConnection.APIConnection;
import Utility.PasswordHash;
import Utility.Utility;

public class User
{
    private String userID;

    private String username;
    private String email;
    private String passwordHashed;
    private int userLevel;

    /*************************************************************************************/

    public User()
    {

    }
    public User(String userID, String username, String email, String passwordHashed, int userLevel)
    {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.passwordHashed = passwordHashed;
        this.userLevel = userLevel;
    }

    public void incrementPoints()
    {
        this.userLevel += 1;
        this.updateTheDB();
    }

    public void decrementPoints()
    {
        this.userLevel -= 1;
        this.updateTheDB();
    }

    /*************************************************************************************/

    @Override
    public String toString()
    {
        return "User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passwordHashed='" + passwordHashed + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }

    /*************************************************************************************/

    private void updateTheDB()
    {
        try
        {
            APIConnection.updateUser(this);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void switchByKey(String KEY, String data)
    {
        if(KEY.equals("USERNAME"))
        {
            this.username = data;
            this.updateTheDB();
        }
        else if(KEY.equals("EMAIL"))
        {
            if(Utility.checkEmail(data))
            {
                this.email = data;
                this.updateTheDB();
            }
            else{ return; }
        }
        else if(KEY.equals("PASSWORD"))
        {
            this.passwordHashed = PasswordHash.hashString(data);
            this.updateTheDB();
        }
        else{ return; }
    }

    /*************************************************************************************/

    public String getUserID()
    {
        return userID;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPasswordHashed()
    {
        return passwordHashed;
    }

    public int getUserLevel()
    {
        return userLevel;
    }

    /*************************************************************************************/

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPasswordHashed(String passwordHashed)
    {
        this.passwordHashed = passwordHashed;
    }

    public void setUserLevel(int userLevel)
    {
        this.userLevel = userLevel;
    }
}
