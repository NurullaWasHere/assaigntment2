package entities;

import java.util.ArrayList;

public class Locomative extends Train {
    private String electroCapacity;
    public Locomative(){
        super();
        this.electroCapacity = "ads";
    }
    public Locomative( int id ){
        super( id);
        this.electroCapacity = "ads";
    }
    public Locomative( int id, int capacity){
        super(id, capacity);
        this.electroCapacity = "ads";
    }
    public Locomative(int id, int capacity, String electroCapacity){
        super(id, capacity);
        this.electroCapacity = electroCapacity;
    }
}
