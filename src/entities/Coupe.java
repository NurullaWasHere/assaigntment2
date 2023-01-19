package entities;

public class Coupe extends Carriage {
    private int id;
    private int capacity;
    private String type;
    private String waterAmount;
    public Coupe(){
        super();
        this.waterAmount = "0l";
    }
    public Coupe(int id){
        super(id);
        this.waterAmount = "0l";
    }
    public Coupe(int id ,int capacity){

        super(id ,capacity);
        this.waterAmount = "0l";
    }
    public Coupe(int id ,int belongsTo ,int capacity,String type, String waterAmount){
        super(id, belongsTo,capacity, type);
        this.waterAmount = waterAmount;
    }
    @Override
    public  String getInfo(){
        return "Carriage type: " + this.type + "and it's capacity: " + this.capacity + " and has " + this.waterAmount + " of water";
    }


    public String getAmountWater(){
        return this.waterAmount;
    }
    public String setWaterAmount(String amount){
        return this.waterAmount = waterAmount;
    }

}
