package model;

import java.util.List;

public class Product {
    String phoneName;
    String image;
    String screen;
    String chip;
    List<String> color;
    List<String> rom;
    String price;

    public Product() {
    }

    public Product(String phoneName, String image, String screen, String chip, List<String> color, List<String> rom, String price) {
        this.phoneName = phoneName;
        this.image = image;
        this.screen = screen;
        this.chip = chip;
        this.color = color;
        this.rom = rom;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "phoneName=" + phoneName + ", image=" + image + ", screen=" + screen + ", chip=" + chip + ", color=" + color + ", rom=" + rom + ", price=" + price + '}';
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getImage() {
        return image;
    }

    public String getScreen() {
        return screen;
    }

    public String getChip() {
        return chip;
    }

    public List<String> getRom() {
        return rom;
    }

    public String getPrice() {
        return price;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public void setRom(List<String> rom) {
        this.rom = rom;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
}
