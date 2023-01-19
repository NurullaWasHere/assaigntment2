package repositories;


import entities.Carriage;
import entities.Train;
import interfaces.IDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarriageRepository implements  ICarriageRepository{
    private final IDB db;
    public CarriageRepository(IDB db){
        this.db = db;
    }
    @Override
    public boolean createCarriage(Carriage carriage){
        Connection con = null;
        try {
            con = this.db.getConnection();
            String sql = "INSERT INTO carriages(id, belongsTo, capacity, type) VALUES (?, ?, ? ,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, carriage.getId());
            st.setInt(2, carriage.getBelongsTo());
            st.setInt(3, carriage.getCapacity());
            st.setString(4, carriage.getType());
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
    public Carriage getCarriage(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,belongsTo,capacity,type  FROM carriages WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Carriage carriage = new Carriage(rs.getInt(id), rs.getInt("belongsTo"), rs.getInt("capacity"), rs.getString("type"));
                return carriage;
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
    public List<Carriage> getAllCarriages(){
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "SELECT id,belongsTo,capacity,type FROM carriages";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Carriage> carriages = new LinkedList<Carriage>();
            while (rs.next()){
                Carriage carriage = new Carriage(rs.getInt("id"), rs.getInt("belongsTo"), rs.getInt("capacity"), rs.getString("type"));
                carriages.add(carriage);
            }
            return  carriages;

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
