package Controllers;

import entities.Train;
import repositories.ITrainRepository;
import java.util.List;
public class TrainController {
    private final ITrainRepository repo;
    public TrainController(ITrainRepository repo){
        this.repo = repo;
    }
    public String createTrain(int id, int capacity, String type, String speed, String roadTime){
        Train train = new Train(id, capacity, type, speed, roadTime);

        boolean created = repo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }
    public String getTrain(int id){
        Train train = repo.getTrain(id);
        return (train == null ? "Train was not found!" : train.toString());
    }
    public String getAllTrains() {
        List<Train> trains = repo.getAllTrains();
        return trains.toString();
    }
}
