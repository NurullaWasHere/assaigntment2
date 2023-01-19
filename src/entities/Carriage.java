package entities;

import java.util.ArrayList;

public class Carriage {
    private int id;
    private int belongsTo;
    private int capacity;
    private String type;
    public Carriage(){
        this.id = 0;
        this.belongsTo = 0;
        this.capacity = 40;
        this.type = "defaultCarriage";
    }
    public Carriage(int id){
        this.id = id;
    }
    public Carriage(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }
    public Carriage(int id,int belongsTo ,int capacity, String type){
        this.id = id;
        this.belongsTo = belongsTo;
        this.capacity = capacity;
        this.type = type;
    }
    public String getInfo(){
        return "Carriage type: " + this.type + "and it's capacity: " + this.capacity;
    }
    public int getId(){
        return this.id;
    }
    public int getBelongsTo(){
        return this.belongsTo;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String toString() {
        return "Carriage{" +
                "id=" + id +
                ", capacity ='" + belongsTo + '\'' +
                ", type='" + capacity + '\'' +
                ", speed= " + type + '\'' +
                '}';
    }
    public String getType(){
        return this.type;
    }

}
