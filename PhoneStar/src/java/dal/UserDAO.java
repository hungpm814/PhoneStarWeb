package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO extends DBContext{
    
    String userName;
    String pass;
    int role;
    String name;
    String phoneNumber;
    String email;
    String address;
    
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "select * from Users";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User b = new User(rs.getString("UserName"),
                                    rs.getString("Password"),
                                    rs.getInt("Role"),
                                    rs.getString("Name"),
                                    rs.getString("PhoneNumber"),
                                    rs.getString("Email"),
                                    rs.getString("Address"));
                                     
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int getSum(){
        String sql = "select COUNT(UserName) 'SUM' from Users";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                int sum = rs.getInt("SUM");
                return sum;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public User getUserByUsername(String username) {
        String sql = "select * from Users\n" +
                     "where UserName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                User u = new User(rs.getString("UserName"), 
                                  rs.getString("Password"),
                                  rs.getInt("Role"),
                                  rs.getString("Name"),
                                  rs.getString("PhoneNumber"),
                                  rs.getString("Email"),
                                  rs.getString("Address"));
                
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    
    public void insert(User u){
        String sql = "INSERT INTO Users (Username,Password,Role) VALUES (?,?,?)";
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1,u.getUserName());
            st.setString(2, u.getPass());
            st.setInt(3, u.getRole());
            
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    
    public void update(User p) {
    String sql = "UPDATE Users SET Name = ?, PhoneNumber = ?, Email = ?, Address = ?, Password = ? WHERE UserName = ?";

    try {
        PreparedStatement st = connection.prepareStatement(sql);

        st.setString(1, p.getName());
        st.setString(2, p.getPhoneNumber());
        st.setString(3, p.getEmail());
        st.setString(4, p.getAddress());
        st.setString(5, p.getPass());
        st.setString(6, p.getUserName());
        
        
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }
    }
    
    public void delete(String username){
        String sql = "delete Users where UserName = '"+username+"'";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        User u;
        ud.delete("user5");
        List<User> lu = ud.getAll();
        System.out.println(ud.getSum());
        
    }
}
