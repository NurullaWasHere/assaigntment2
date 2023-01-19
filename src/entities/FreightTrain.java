package entities;

import java.util.ArrayList;

public class FreightTrain extends Train {
    private int id;
    private int capacity;
    private String type;
    public FreightTrain(){
        super();
    }
    public FreightTrain( int id ){
        super( id);
    }
    public FreightTrain(int id, int capacity){
        super(id,capacity);
    }
    public String getInfo(){
        return "Train id " + this.id + " and type " + this.type;
    }
}
