import Controllers.CarriageController;
import Controllers.TrainController;
import interfaces.IDB;
import interfaces.PostgresDB;
import repositories.CarriageRepository;
import repositories.ICarriageRepository;
import repositories.ITrainRepository;
import repositories.TrainRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        ITrainRepository repo = new TrainRepository(db);
        ICarriageRepository repo1 = new CarriageRepository(db);
        TrainController controller = new TrainController(repo);
        CarriageController carController = new CarriageController(repo1);
        MyApplication app = new MyApplication(controller, carController);
        app.start();
    }
}