package com.example.sumansinghrajput.dreamtreasure;

/**
 * Created by Suman Singh Rajput on 23-03-2018.
 */

public class AddModel {

    private String propertyType ;
    private String capacity ;
    private String apartmentType ;
    private String address ;
    private String cost;
    private String description ;
    private String landmark;






    public AddModel(){

        this.propertyType = null;
        this.capacity = null;
        this.apartmentType = null;
        this.address = null;
        this.cost = null;
        this.description = null;
        this.landmark = null;



    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
