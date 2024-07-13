package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Bill;

public class BillDAO extends DBContext {

    public List<Bill> getAll() {
        List<Bill> list = new ArrayList<>();
        String sql = "select * from Bill";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Bill b = new Bill(rs.getInt("BillID"), 
                                rs.getString("UserName"), 
                                       rs.getString("Date"), 
                                  rs.getString("Total"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int getSum(){
        String sql = "select COUNT(BillID) 'SUM' from Bill";
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
    
    public int getTotal() {
        String sql = "select SUM(Total) 'Total' from Bill";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                int total = rs.getInt("Total");
                return total;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public int getTotalToday() {
        String sql = "select SUM(Total) 'TotalDay' from Bill\n" +
                        "where DAY(Date) = DAY(getdate())";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                int total = rs.getInt("TotalDay");
                return total;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public String getAvg() {
        String sql = "select AVG(Total) 'AVG' from Bill";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                String x = rs.getString("AVG");
                for(int i=0;i<x.length();i++)
                    if(x.charAt(i)=='.'){
                        x=x.substring(0,i);
                    }
                
                return x;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "0";
    }
    
    public List<Bill> getByUsername(String username) {
        List<Bill> list = new ArrayList<>();
        String sql = "select * from Bill where UserName = '"+username+"'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Bill b = new Bill(rs.getInt("BillID"), 
                                rs.getString("UserName"), 
                                       rs.getString("Date"), 
                                  rs.getString("Total"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Bill getByBid(int billID) {
        String sql = "select * from Bill where BillID = "+billID;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Bill b = new Bill(rs.getInt("BillID"), 
                                rs.getString("UserName"), 
                                       rs.getString("Date"), 
                                  rs.getString("Total"));
                return b;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public int getBillID() {
        String sql = "select TOP 1 BillID from Bill\n" +
                     "order by BillID desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("BillID");
                return id;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public void insert(Bill v){
        String sql = "INSERT INTO Bill VALUES (?,?,?,?)";
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setInt(1,v.getBillID());
            st.setString(2, v.getUserName());
            st.setString(3, v.getDate());
            st.setString(4, v.getTotal());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void delete(int billID){
        String sql = "delete Bill where BillID="+billID;
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(Bill v){
        String sql = "update Bill set UserName = ?, Total = ?, Date = getdate() where BillID = ?";
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1, v.getUserName());
            st.setString(2, v.getTotal());
            st.setInt(3,v.getBillID());
            
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        BillDAO bd = new BillDAO();
        Bill b = new Bill(1);
        List<Bill> lb = bd.getByUsername("user3");
        
        System.out.println(bd.getAvg());
    }
    
}
