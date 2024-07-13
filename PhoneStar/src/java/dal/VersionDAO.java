package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.Version;

public class VersionDAO extends DBContext {

    //doc tat ca cac ban ghi tu PhoneDB
    public List<Version> getAll() {
        List<Version> list = new ArrayList<>();
        String sql = "select * from Version";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Version v = new Version(rs.getString("PhoneName"),
                                        rs.getString("OS"),
                                        rs.getInt("RAM"),
                                        rs.getString("Detail"),
                                        rs.getInt("Camera"),
                                        rs.getInt("Year"),
                                        rs.getString("Chip"),
                                        rs.getString("Screen"),
                                        rs.getInt("BrandID"));
                list.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Version> getNewVersion(){
        List<Version> list = new ArrayList<>();
        String sql = "select TOP 5 * from Version \n" +
                     "join Phone on Version.PhoneName=Phone.PhoneName\n" +
                     "order by Phone.Date desc";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Version v = new Version(rs.getString("PhoneName"),
                                        rs.getString("OS"),
                                        rs.getInt("RAM"),
                                        rs.getString("Detail"),
                                        rs.getInt("Camera"),
                                        rs.getInt("Year"),
                                        rs.getString("Chip"),
                                        rs.getString("Screen"),
                                        rs.getInt("BrandID"));
                list.add(v);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        
        return list;
    }
    
    public List<Version> getVersionByBID(int bid) {
        List<Version> list = new ArrayList<>();
        String sql = "select * from Version\n" +
                     "where BrandID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Version v = new Version(rs.getString("PhoneName"),
                                        rs.getString("OS"),
                                        rs.getInt("RAM"),
                                        rs.getString("Detail"),
                                        rs.getInt("Camera"),
                                        rs.getInt("Year"),
                                        rs.getString("Chip"),
                                        rs.getString("Screen"),
                                        rs.getInt("BrandID"));
                list.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public Version getVersionByPhoneName(String phoneName) {
        List<Version> list = new ArrayList<>();
        String sql = "select * from Version\n" +
                     "where PhoneName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, phoneName);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Version v = new Version(rs.getString("PhoneName"),
                                        rs.getString("OS"),
                                        rs.getInt("RAM"),
                                        rs.getString("Detail"),
                                        rs.getInt("Camera"),
                                        rs.getInt("Year"),
                                        rs.getString("Chip"),
                                        rs.getString("Screen"),
                                        rs.getInt("BrandID"));
                return v;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Integer> getRAM() {
        List<Integer> list = new ArrayList<>();
        int ram;
        boolean check=true;
        String sql = "select RAM from Version order by RAM asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ram = rs.getInt("RAM");
                check = true;
                for(int r:list){
                    if(r==ram){
                        check=false;
                        break;
                    }
                }
                if(check) list.add(ram);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    //them mot Version
    public void insert(Version v){
        String sql = "INSERT INTO Version VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1,v.getPhoneName());
            st.setString(2, v.getOs());
            st.setInt(3, v.getRam());
            st.setString(4, v.getDetail());
            st.setInt(5, v.getCamera());
            st.setInt(6, v.getYear());
            st.setString(7, v.getChip());
            st.setString(8, v.getScreen());
            st.setInt(9, v.getBrandID());
            
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(Version s) {
    String sql = "UPDATE Version SET os = ?, ram = ?, detail = ?, camera = ?, year = ?, chip = ?, screen = ?, brandID = ? where phoneName = ?";

    try {
        PreparedStatement st = connection.prepareStatement(sql);

        st.setString(1, s.getOs());
        st.setInt(2, s.getRam());
        st.setString(3, s.getDetail());
        st.setInt(4, s.getCamera());
        st.setInt(5, s.getYear());
        st.setString(6, s.getChip());
        st.setString(7, s.getScreen());
        st.setInt(8, s.getBrandID());
        st.setString(9, s.getPhoneName());
        
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }
    }

    
    public static void main(String[] args) {
        VersionDAO vd = new VersionDAO();
        Version v = new Version("Xiaomi 13T Pro 5G","Android 13",8,"Sản phẩm Xiaomi",112,2023,"MediaTek Dimensity 9200+ 5G","AMOLED 6.67\"1.5K",3);
        v=vd.getVersionByPhoneName("iPhone 15");
        v.setCamera(62);
        vd.update(v);
        v=vd.getVersionByPhoneName("iPhone 15");
        System.out.println(v);
    }
    /*
    
    //xoa mot Version
    public void delete(String rollNo){
        String sql = "delete from Version where RollNo=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, rollNo);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //cap nhat Version
    public void update(Version s){
        String sql = "update Version set Name=?,Mark=? where RollNo=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1, s.getName());
            st.setFloat(2, s.getMark());
            st.setString(3, s.getRollNo());
            
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
*/
    



}
