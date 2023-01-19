package entities;

public class Train {
    private int id;
    private int capacity;
    private String type;
    private String speed;
    private String roadTime;
    public Train(){
        this.id = 0;
        this.capacity = 10;
        this.type = "defaultTrain";
        this.speed = "60km/h";
        this.roadTime = "2d";
    }
    public Train(int id ){
        this.id = id;
        this.capacity = 10;
        this.type = "defaultTrain";
        this.speed = "60km/h";
        this.roadTime = "1d";
    }
    public Train( int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        this.type = "defaultTrain";
        this.speed = "60km/h";
        this.roadTime = "2d";
    }
    public Train( int id, int capacity, String type, String speed, String roadTime){
        this.id = id;
        this.capacity = capacity;
        this.type = type;
        this.speed = speed;
        this.roadTime = roadTime;
    }
    public int getId(){
        return this.id;
    }
    public String getInfo(){
        return "Train id " + this.id + " and type " + this.type;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public String getSpeed(){
        return this.speed;
    }
    public String getRoadTime(){
        return this.roadTime;
    }
    public String getType(){
        return  this.type;
    }

    public String setRoadTime(String roadTime){
        return this.roadTime = roadTime;
    }
    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", capacity ='" + capacity + '\'' +
                ", type='" + type + '\'' +
                ", speed= " + speed + '\'' +
                ", roadtime= " + roadTime +
                '}';
    }

}
