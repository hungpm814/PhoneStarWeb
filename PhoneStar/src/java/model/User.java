package model;

/**
 *
 * @author PC
 */
public class User {
    String userName;
    String pass;
    int role;
    String name;
    String phoneNumber;
    String email;
    String address;

    public User() {
    }

    public User(String userName, String pass, int role, String name, String phoneNumber, String email, String address) {
        this.userName = userName;
        this.pass = pass;
        this.role = role;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", pass=" + pass + ", role=" + role + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + '}';
    }

    
    
    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public int getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
