package model;

/**
 *
 * @author PC
 */
public class Brand {
    int brandID;
    String brandName;
    String detail;

    public Brand() {
    }

    public Brand(int brandID, String brandName, String detail) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.detail = detail;
    }

    public int getBrandID() {
        return brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getDetail() {
        return detail;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Brand{" + "brandID=" + brandID + ", brandName=" + brandName + ", detail=" + detail + '}';
    }
    
    
}
