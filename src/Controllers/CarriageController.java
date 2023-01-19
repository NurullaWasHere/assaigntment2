package Controllers;

import entities.Carriage;
import entities.Train;
import repositories.ICarriageRepository;
import repositories.ITrainRepository;

import java.util.List;

public class CarriageController {
    private final ICarriageRepository repo1;
    public CarriageController(ICarriageRepository repo1){
        this.repo1 = repo1;
    }
    public String createCarriage(int id, int belongsTo, int capacity, String type){
        Carriage carriage = new Carriage(id,belongsTo, capacity, type);

        boolean created = repo1.createCarriage(carriage);

        return (created ? "Carriage was created!" : "Carriage creation was failed!");
    }
    public String getCarriage(int id){
        Carriage carriage = repo1.getCarriage(id);
        return (carriage == null ? "Carriage was not found!" : carriage.toString());
    }
    public String getAllCarriages() {
        List<Carriage> carriages = repo1.getAllCarriages();
        return carriages.toString();
    }
}
