
package Entity;


public class Users {
    
    private int userId;
    private String userName;
    private String userFamily;
    private String userEmail;
    private String userPassword;
    private String userPhone;
    private String userType;

    public Users() {
    }

    public Users(int userId, String userName, String userFamily, String userEmail, String userPassword, String userPhone, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userFamily = userFamily;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userType = userType;
    }

    public String getUserFamily() {
        return userFamily;
    }

    public void setUserFamily(String userFamily) {
        this.userFamily = userFamily;
    }

   

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

  

   

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }
 

    public String getUserType() {
        return userType;
    }
    
    
}
