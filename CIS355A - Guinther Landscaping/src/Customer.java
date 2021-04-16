
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicholasguinther
 */
public class Customer {
    // attributes
    private int customerID;
    private String name;
    private String address;
    private String yardType;
    private double length;
    private double width;
    private double totalCost;
    
    // constructors

    public Customer() {
        customerID = 0;
        name = "N/A";
        address = "N/A";
        yardType = "N/A";
        length = 0.0;
        width = 0.0;
        totalCost = 0.0;
    }

    public Customer(int customerID, String name, String address, String yardType, double length, double width, double totalCost) {
        this.customerID = customerID;
        this.setName(name);
        this.address = address;
        this.yardType = yardType;
        this.length = length;
        this.width = width;
        this.totalCost = totalCost;
    }
    
    // behaviors
    @Override
    public String toString(){
        return name;    // only show the customers name
    }
    
    public String getDetails(){
        DecimalFormat fmt = new DecimalFormat("$#,##0.00");
        String output = name + "\n";
        output += address + "\n";
        output += "Type: " + yardType + "\n";
        output += "Length: " + length + "\n";
        output += "Width: " + width + "\n";
        output += "Total Cost: " + fmt.format(totalCost) + "\n";
        
        return output;
    }
    // getters and setters

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0)
            this.name = name;
        else
            this.name = "N/A";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYardType() {
        return yardType;
    }

    public void setYardType(String yardType) {
        this.yardType = yardType;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
}
