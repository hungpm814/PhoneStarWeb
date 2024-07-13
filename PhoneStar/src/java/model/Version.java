package model;

/**
 *
 * @author PC
 */
public class Version {
    String phoneName,os;
    int ram;
    String detail;
    int camera,year;
    String chip,screen;
    int brandID;

    public Version() {
    }

    public Version(String phoneName, String os, int ram, String detail, int camera, int year, String chip, String screen, int brandID) {
        this.phoneName = phoneName;
        this.os = os;
        this.ram = ram;
        this.detail = detail;
        this.camera = camera;
        this.year = year;
        this.chip = chip;
        this.screen = screen;
        this.brandID = brandID;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public String getDetail() {
        return detail;
    }

    public int getCamera() {
        return camera;
    }

    public int getYear() {
        return year;
    }

    public String getChip() {
        return chip;
    }

    public String getScreen() {
        return screen;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    @Override
    public String toString() {
        return "Version{" + "phoneName=" + phoneName + ", os=" + os + ", ram=" + ram + ", detail=" + detail + ", camera=" + camera + ", year=" + year + ", chip=" + chip + ", screen=" + screen + ", brandID=" + brandID + '}';
    }
    
    
}
