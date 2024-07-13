package model;

/**
 *
 * @author PC
 */
public class Phone {
    String series;
    String phoneName;
    String color;
    String rom;
    String price;
    int quantity;
    String date;
    String image;

    public Phone() {
    }

    public Phone(String series, String phoneName, String color, String rom, String price, int quantity, String date, String image) {
        this.series = series;
        this.phoneName = phoneName;
        this.color = color;
        this.rom = rom;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.image = image;
    }

    public Phone(String price) {
        this.price = price;
    }
    

    @Override
    public String toString() {
        return "Phone{" + "series=" + series + ", phoneName=" + phoneName + ", color=" + color + ", rom=" + rom + ", price=" + price + ", quantity=" + quantity + ", date=" + date + ", image=" + image + '}';
    }
    
    public String getSeries() {
        return series;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getColor() {
        return color;
    }

    public String getRom() {
        return rom;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
