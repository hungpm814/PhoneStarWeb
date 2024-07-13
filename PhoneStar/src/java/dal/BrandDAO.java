package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Brand;


public class BrandDAO extends DBContext {

    //doc tat ca cac ban ghi tu PhoneDB
    public List<Brand> getAll() {
        List<Brand> list = new ArrayList<>();
        String sql = "select * from Brand";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand b = new Brand(rs.getInt("BrandID"),
                                   rs.getString("brandName"),
                                     rs.getString("detail"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public Brand getBrandByID(int id){
        String sql = "select * from Brand where BrandID = '" + String.valueOf(id) + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand b = new Brand(rs.getInt("BrandID"),
                                   rs.getString("BrandName"),
                                     rs.getString("Detail"));
                return b;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    
    public static void main(String[] args) {
       
        BrandDAO vd = new BrandDAO();
        
        List<Brand> li = vd.getAll();
        for(Brand v:li){
            System.out.println(v);
        }      
    }



}
