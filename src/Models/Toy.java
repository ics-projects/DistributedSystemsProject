package Models;

import java.io.Serializable;

public class Toy implements Serializable {
    private String Code;
    private String Name;
    private String Description;
    private int Price;
    private String Dom;
    private String BatchNumber;
    private String customMessage;
    private ToyManufacturer toyManufacturer;

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDom() {
        return Dom;
    }

    public void setDom(String dom) {
        Dom = dom;
    }

    public String getBatchNumber() {
        return BatchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        BatchNumber = batchNumber;
    }

    public ToyManufacturer getToyManufacturer() {
        return toyManufacturer;
    }

    public void setToyManufacturer(ToyManufacturer toyManufacturer) {
        this.toyManufacturer = toyManufacturer;
    }
}
