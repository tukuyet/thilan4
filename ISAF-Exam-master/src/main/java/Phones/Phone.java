package Phones;

public class Phone {
    public int id;
    public String phoneName;
    public String brand;
    public Double price;
    public String description;

    public Phone(int id, String phoneName, String brand, Double price, String description) {
        this.id = id;
        this.phoneName = phoneName;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public Phone(String phoneName, String brand, Double price, String description) {
        this.phoneName = phoneName;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
