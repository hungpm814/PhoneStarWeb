package model;

public class Orders {
    int billID;
    String series;
    int quantity;
    String price;

    public Orders() {
    }

    public Orders(int billID, String series, int quantity, String price) {
        this.billID = billID;
        this.series = series;
        this.quantity = quantity;
        this.price = price;
    }

    public int getBillID() {
        return billID;
    }

    public String getSeries() {
        return series;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders{" + "billID=" + billID + ", series=" + series + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
    
}
