package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Phone;

/**
 *
 * @author PC
 */
public class PhoneDAO extends DBContext{
    
    public List<String> getROM() {
        List<String> list = new ArrayList<>();
        String rom;
        boolean check=true;
        String sql = "select ROM from Phone order by ROM asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                rom = rs.getString("ROM");
                check = true;
                for(String r:list){
                    if(r.compareTo(rom)==0){
                        check=false;
                        break;
                    }
                }
                if(check) list.add(rom);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int getSum(){
        String sql = "select SUM(Quantity) 'SUM' from Phone";
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
    
    public Phone getPhoneByColorAndROMAndName(String color, String rom, String name) {
        List<String> list = new ArrayList<>();
        String sql = "select * from Phone where Color = N'" + color +"' AND ROM = '" + rom +"' AND PhoneName = '" + name +"'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Phone p = new Phone(rs.getString("Series"),
                                    rs.getString("PhoneName"),
                                    rs.getString("Color"),
                                    rs.getString("ROM"),
                                    rs.getString("Price"),
                                    rs.getInt("Quantity"),
                                    rs.getString("Date"),
                                    rs.getString("Image"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Phone getPhoneBySeries(String series){
        Phone p = new Phone();
        String sql = "select * from Phone where Series = '" + series + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                p = new Phone(rs.getString("Series"),
                                    rs.getString("PhoneName"),
                                    rs.getString("Color"),
                                    rs.getString("ROM"),
                                    rs.getString("Price"),
                                    rs.getInt("Quantity"),
                                    rs.getString("Date"),
                                    rs.getString("Image"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    //doc tat ca cac ban ghi tu PhoneDB
    public List<Phone> getAll() {
        List<Phone> list = new ArrayList<>();
        String sql = "select * from Phone";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Phone v = new Phone(rs.getString("Series"), 
                                  rs.getString("PhoneName"), 
                                    rs.getString("Color"), 
                                    rs.getString("ROM"),
                                      rs.getString("Price"), 
                                         rs.getInt("Quantity"), 
                                        rs.getString("Date"), 
                                         rs.getString("Image"));
                list.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public void insert(Phone v){
        String sql = "INSERT INTO Phone VALUES (?,?,?,?,?,?,getdate(),?)";
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1,v.getSeries());
            st.setString(2, v.getPhoneName());
            st.setString(3, v.getColor());
            st.setString(4, v.getRom());
            st.setString(5, v.getPrice());
            st.setInt(6, v.getQuantity());
            st.setString(7, v.getImage());
            
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(Phone p) {
    String sql = "UPDATE Phone SET phoneName = ?, color = ?, rom = ?, price = ?, quantity = ?, date = ?, image = ? WHERE series = ?";

    try {
        PreparedStatement st = connection.prepareStatement(sql);

        st.setString(1, p.getPhoneName());
        st.setString(2, p.getColor());
        st.setString(3, p.getRom());
        st.setString(4, p.getPrice());
        st.setInt(5, p.getQuantity());
        st.setString(6, p.getDate());
        st.setString(7, p.getImage());
        st.setString(8, p.getSeries());
        
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }
    }
    
    public void delete(String series) {
    String sql = "DELETE FROM Phone WHERE series = ?";

    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, series);
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }
    }


    public static void main(String[] args) {
        PhoneDAO pd = new PhoneDAO();
        List<Phone> li = pd.getAll();
        
        System.out.println(pd.getSum());
    }
}
