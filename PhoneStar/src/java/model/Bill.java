
package model;

public class Bill {
    int billID;
    String userName;
    String date;
    String total;

    public Bill() {
    }

    public Bill(int billID, String userName, String date, String total) {
        this.billID = billID;
        this.userName = userName;
        this.date = date;
        this.total = total;
    }

    public Bill(int billID) {
        this.billID = billID;
    }

    public int getBillID() {
        return billID;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public String getTotal() {
        return total;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" + "billID=" + billID + ", userName=" + userName + ", date=" + date + ", total=" + total + '}';
    }
    
    
}
