package repositories;


import entities.Train;
import interfaces.IDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
public class TrainRepository implements ITrainRepository {
    private final IDB db;
    public TrainRepository(IDB db){
        this.db = db;
    }
    @Override
    public boolean createTrain(Train train){
        Connection con = null;
        try {
            con = this.db.getConnection();
            String sql = "INSERT INTO trains(id, capacity, type, speed, roadTime) VALUES (?, ?, ? ,? ,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, train.getId());
            st.setInt(2, train.getCapacity());
            st.setString(3, train.getType());
            st.setString(4, train.getSpeed());
            st.setString(5, train.getRoadTime());
            st.execute();
            return true;
        }
        catch (SQLException throwables){
            System.out.println("здесь 3");
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.println("There 2");
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public Train getTrain(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,capacity,type,speed,roadTime FROM trains WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Train train = new Train(rs.getInt(id), rs.getInt("capacity"), rs.getString("type"), rs.getString("speed"), rs.getString("roadTime"));
                return train;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.println("There 1");
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Train> getAllTrains(){
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "SELECT id,capacity,type,speed,roadTime FROM trains";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Train> trains = new LinkedList<Train>();
            while (rs.next()){
                Train train = new Train(rs.getInt("id"), rs.getInt("capacity"), rs.getString("type"), rs.getString("speed"), rs.getString("roadTime"));
                trains.add(train);
            }
            return  trains;

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.println("There 3");
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
