package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Orders;

public class OrdersDAO extends DBContext{
    public List<Orders> getAll() {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from Orders";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Orders b = new Orders(rs.getInt("BillID"), 
                                rs.getString("Series"), 
                                       rs.getInt("Quantity"), 
                                  rs.getString("Price"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Orders> getAllByBid(int bid) {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from Orders where BillID = " + bid;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Orders b = new Orders(rs.getInt("BillID"), 
                                rs.getString("Series"), 
                                       rs.getInt("Quantity"), 
                                  rs.getString("Price"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
     public int getSumPriceByBid(int bid) {
        String sql = "select SUM(Price) 'Price' \n" +
                        "from Orders\n" +
                        "where BillID = " + bid;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                int total = rs.getInt("Price");
                return total;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public void insert(Orders v){
        String sql = "INSERT INTO Orders VALUES (?,?,?,?)";
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setInt(1,v.getBillID());
            st.setString(2, v.getSeries());
            st.setInt(3, v.getQuantity());
            st.setString(4, v.getPrice());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(Orders v){
        String sql = "update Orders set Quantity = ?, Price = ? where BillID = ? AND Series = ?";
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setInt(1, v.getQuantity());
            st.setString(2, v.getPrice());
            st.setInt(3,v.getBillID());
            st.setString(4, v.getSeries());
            
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void delete(int billID, String series){
        String sql = "delete Orders where BillID="+billID+" AND Series='"+series+"'";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        OrdersDAO od = new OrdersDAO();
        //Orders o = new Orders(1,"ip2",2,"50000000");
        //od.update(o);
        od.delete(1, "ip2");
        List<Orders> lo = od.getAll();
        System.out.println(od.getSumPriceByBid(1));
    }
}
