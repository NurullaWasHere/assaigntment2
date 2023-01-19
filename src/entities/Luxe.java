package entities;

import entities.Coupe;

public class Luxe extends Coupe {
    private int id;
    private int capacity;
    private  int belongsTo;
    private String type;
    private String waterAmount;
    private String foods;
    Luxe(){
        super();
        this.foods = "No food";
    }
    Luxe(int id){
        super(id);
        this.foods = "No food";
    }
    Luxe(int id ,int capacity){
        super(id ,capacity);
        this.foods = "No food";
    }
    Luxe(int id ,int belongsTo,int capacity , String type, String waterAmount, String foods){
        super(id,belongsTo ,capacity, type, waterAmount);
        this.foods = foods;
    }
    @Override
    public  String getInfo(){
        return "Carriage type: " + this.type + "and it's capacity: " + this.capacity  + " and has " + this.waterAmount + " of water";
    }
    public String getFoods(){
        return this.foods;
    }
    public String setFoods(String foods){
        return this.foods = foods;
    }
}
