package com.example.sumansinghrajput.dreamtreasure;

/**
 * Created by Suman Singh Rajput on 21-03-2018.
 */

class Model {
    private int cost;
    private String address ;
    private String capacity;
    private String id;

    public Model(){
        this.cost = -1;
        this.address = null;
        this.capacity = null;
        this.id = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public String getCapacity() {
        return capacity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
