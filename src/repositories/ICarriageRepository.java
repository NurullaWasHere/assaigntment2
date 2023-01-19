package repositories;

import entities.Carriage;

import java.util.List;
public interface ICarriageRepository {
    boolean createCarriage(Carriage carriage);
    Carriage getCarriage(int id);
    List<Carriage> getAllCarriages();
}
