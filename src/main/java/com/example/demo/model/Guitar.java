package com.example.demo.model;



public class Guitar {

    public enum Builder {
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;
        public String toString() {
            switch (this) {
                case FENDER: return "Fender";
                case MARTIN: return "Martin";
                case GIBSON: return "Gibson";
                case COLLINGS: return "Collings";
                case OLSON: return "Olsen";
                case RYAN: return "Ryan";
                case PRS: return "PRS";
                default: return "Unspecified";
            }
        }
    }

    public enum Type {
        ELECTRIC, ACOUSTIC;
        public String toString() {
            switch (this) {
                case ACOUSTIC: return "Acoustic";
                case ELECTRIC: return "Electric";
                default: return "Unspecified";
            }
        }
    }

    public enum Wood {
        INDIAN_ROSEWOOD, BRAZILLIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;
        public String toString() {
            switch (this) {
                case INDIAN_ROSEWOOD: return "Indian Rosewood";
                case BRAZILLIAN_ROSEWOOD: return "Brazillian Rosewood";
                case MAHOGANY: return "Mahogany";
                case MAPLE: return "Maple";
                case COCOBOLO: return "Cocobolo";
                case CEDAR: return "Cedar";
                case ADIRONDACK: return "Adirondack";
                case ALDER: return "Alder";
                case SITKA: return "Sitka";
                default: return "Unspecified";
            }
        }
    }
    String serialNumber;
    double price;
    Builder builder;
    String model;
    Type type;
    Wood backWood;
    Wood topWood;

    public String getSerialNumber(){ return this.serialNumber; }

    public void setSerialNumber(String s){ this.serialNumber = s; }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(float f){
        this.price = f;
    }

    public String getBuilder(){
        return builder.toString();
    }

    public void setBuilder(String s){ this.builder = Builder.valueOf(s); }

    public String getModel(){
        return this.model;
    }

    public void setModel(String s){ this.model = s; }

    public String getType(){
        return type.toString();
    }

    public void setType(String s){ this.type = Type.valueOf(s); }

    public String getBackWood(){
        return backWood.toString();
    }

    public void setBackWood(String s){ this.backWood = Wood.valueOf(s); }

    public String getTopWood(){
        return topWood.toString();
    }

    public void setTopWood(String s){ this.topWood = Wood.valueOf(s); }
}
