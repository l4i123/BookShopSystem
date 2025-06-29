package Model;
public class User{
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;

    public User( String userName, String password, String email, String phoneNumber, String address) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }  

    public String getPhoneNumber() {
        return phoneNumber;
    }  

    public String getAddress() {
        return address;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}