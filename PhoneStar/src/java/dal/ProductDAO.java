package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Version;
import model.Product;

public class ProductDAO extends DBContext {
    
    public Product getProductByPhoneName(String phoneName){
        List<Product> list = new ArrayList<>();
        String sql = "select * from Version \n" +
                    "join Phone on Version.PhoneName=Phone.PhoneName\n" +
                    "where Version.PhoneName = '" + phoneName + "'\n" +
                    "order by ROM asc,Color asc";
        String image = null;
        String screen = null;
        String chip = null;
        List<String> color = new ArrayList<>();
        List<String> rom = new ArrayList<>();
        String price = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                image = rs.getString("Image");
                screen = rs.getString("Screen");
                chip = rs.getString("Chip");
                price = String.valueOf(rs.getInt("Price"));
                color.add(rs.getString("Color"));
                rom.add(rs.getString("ROM"));
            }
            while (rs.next()) {
                String colorTemp = rs.getString("Color");
                String romTemp = rs.getString("ROM");
                boolean check=true;
                for(String c:color){
                    if(c.compareTo(colorTemp)==0) {
                        check=false;
                        break;
                    }
                }
                if(check) color.add(colorTemp);
                
                check=true;
                for(String r:rom){
                    if(r.compareTo(romTemp)==0) {
                        check=false;
                        break;
                    }
                }
                if(check) rom.add(romTemp);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        Product p = new Product(phoneName, image, screen, chip, color, rom, price);
        if(image==null) return null; else return p;
    }
    
    public List<Product> getProductsByFilter(String pbegin, String pend, String ram, String romm, String brand){
        List<Product> li = new ArrayList<>();
        String sql = "select * from Version \n" +
                    "join Phone on Version.PhoneName=Phone.PhoneName\n" +
                    "where (Price>? AND Price<?)";
        int count=3;
        if(ram.compareTo("0")!=0){
                sql = sql+" AND\n" + "RAM = ?";       
                count++;
            }
        if(romm.compareTo("0")!=0){
                sql = sql+" AND\n" + "ROM = ?";
                count++;
            }
        if(brand.compareTo("0")!=0){
                sql = sql+" AND\n" + "BrandID = ?";
                count++;
            }
        sql = sql + "\norder by Version.PhoneName asc, ROM asc, Color asc";
        String image = null;
        String screen = null;
        String chip = null;
        List<String> color = new ArrayList<>();
        List<String> rom = new ArrayList<>();
        String price = null;
        Product p = new Product();
        try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1, pbegin);
            st.setString(2, pend);
            count = 3;
            if(ram.compareTo("0")!=0){       
                st.setString(count, ram);
                count++;
            }
            if(romm.compareTo("0")!=0){
                st.setString(count, romm);
                count++;
            }
            if(brand.compareTo("0")!=0){
                st.setString(count, brand);
                count++;
            }
 
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                String name = rs.getString("PhoneName");
                
                image = rs.getString("Image");
                screen = rs.getString("Screen");
                chip = rs.getString("Chip");
                price = String.valueOf(rs.getInt("Price"));
                color.add(rs.getString("Color"));
                rom.add(rs.getString("ROM"));
                
                p = new Product(name, image, screen, chip, color, rom, price);
                li.add(p);
            } else {
                return li;
            }
            while (rs.next()) {
                String name = rs.getString("PhoneName");
                
                boolean check=true;
                for(Product pr:li){
                    if(pr.getPhoneName().compareTo(name)==0){
                        check=false;
                        break;
                    }
                }
                
                if(check){
                    image = rs.getString("Image");
                    screen = rs.getString("Screen");
                    chip = rs.getString("Chip");
                    price = String.valueOf(rs.getInt("Price"));
                    color = new ArrayList<>();
                    rom = new ArrayList<>();
                
                    p = new Product(name, image, screen, chip, color, rom, price);
                    li.add(p);
                }
                
                String colorTemp = rs.getString("Color");
                String romTemp = rs.getString("ROM");
                check=true;
                for(String c:color){
                    if(c.compareTo(colorTemp)==0) {
                        check=false;
                        break;
                    }
                }
                if(check) color.add(colorTemp);
                
                check=true;
                for(String r:rom){
                    if(r.compareTo(romTemp)==0) {
                        check=false;
                        break;
                    }
                }
                if(check) rom.add(romTemp);
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return li;
    }
    
    public List<Product> searchProductByText(String text){
        List<Product> li = new ArrayList<>();
        String sql = "select * from Version \n" +
                    "join Phone on Version.PhoneName=Phone.PhoneName\n" +
                    "where Version.PhoneName like ?\n" +
                    "order by Version.PhoneName asc, ROM asc, Color asc";
        String image = null;
        String screen = null;
        String chip = null;
        List<String> color = new ArrayList<>();
        List<String> rom = new ArrayList<>();
        String price = null;
        Product p = new Product();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,"%"+text+"%");
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                String name = rs.getString("PhoneName");
                image = rs.getString("Image");
                screen = rs.getString("Screen");
                chip = rs.getString("Chip");
                price = String.valueOf(rs.getInt("Price"));
                color.add(rs.getString("Color"));
                rom.add(rs.getString("ROM"));
                
                p = new Product(name, image, screen, chip, color, rom, price);
                li.add(p);
            } else {
                return li;
            }
            while (rs.next()) {
                String name = rs.getString("PhoneName");
                
                boolean check=true;
                for(Product pr:li){
                    if(pr.getPhoneName().compareTo(name)==0){
                        check=false;
                        break;
                    }
                }
                
                if(check){
                    image = rs.getString("Image");
                    screen = rs.getString("Screen");
                    chip = rs.getString("Chip");
                    price = String.valueOf(rs.getInt("Price"));
                    color = new ArrayList<>();
                    rom = new ArrayList<>();
                
                    p = new Product(name, image, screen, chip, color, rom, price);
                    li.add(p);
                }
                
                String colorTemp = rs.getString("Color");
                String romTemp = rs.getString("ROM");
                check=true;
                for(String c:color){
                    if(c.compareTo(colorTemp)==0) {
                        check=false;
                        break;
                    }
                }
                if(check) color.add(colorTemp);
                
                check=true;
                for(String r:rom){
                    if(r.compareTo(romTemp)==0) {
                        check=false;
                        break;
                    }
                }
                if(check) rom.add(romTemp);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return li;
    }
    
 
    
    
    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        Product p = pd.getProductByPhoneName("iPhone 15");
        List<Product> li = pd.searchProductByText("Iphone");
        for(Product pr:li){
            System.out.println(pr);
        }
    }



}
