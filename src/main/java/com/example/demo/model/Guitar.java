package com.example.demo.model;

public class Guitar {
    String serialNumber;
    double price;
    String builder;
    String model;
    String type;
    String backWood;
    String topWood;

    public String getSerialNumber(){ return this.serialNumber; }

    public void setSerialNumber(String s){ this.serialNumber = s; }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(float f){
        this.price = f;
    }

    public String getBuilder(){
        return this.builder;
    }

    public void setBuilder(String s){ this.builder = s; }

    public String getModel(){
        return this.model;
    }

    public void setModel(String s){ this.model = s; }

    public String getType(){
        return this.type;
    }

    public void setType(String s){ this.type = s; }

    public String getBackWood(){
        return this.backWood;
    }

    public void setBackWood(String s){ this.backWood = s; }

    public String getTopWood(){
        return this.topWood;
    }

    public void setTopWood(String s){ this.topWood = s; }
}
