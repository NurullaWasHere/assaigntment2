import Controllers.CarriageController;
import Controllers.TrainController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final TrainController controller;
    private final CarriageController carController;
    private final Scanner scanner;
    public MyApplication(TrainController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
        carController = null;
    }
    public MyApplication(TrainController controller, CarriageController carController) {
        this.controller = controller;
        this.carController = carController;
        scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all trains");
            System.out.println("2. Get train by id");
            System.out.println("3. Create train");
            System.out.println("4. Get all carriages");
            System.out.println("5. Get carriage by id");
            System.out.println("6. Create carriage");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTrainsMenu();
                } else if (option == 2) {
                    getTrainByIdMenu();
                } else if (option == 3) {
                    createTrainMenu();
                } else if (option == 4) {
                    getAllCarriagesMenu();
                } else if (option == 5) {
                    getCarriageByIdMenu();
                } else if (option == 6) {
                    createCarriageMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }
    public void getAllTrainsMenu() {
        String response = controller.getAllTrains();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getTrain(id);
        System.out.println(response);
    }

    public void createTrainMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter capacity");
        int capacity = scanner.nextInt();
        System.out.println("Please enter type");
        String type = scanner.next();
        System.out.println("Please enter speed");
        String speed = scanner.next();
        System.out.println("Please enter roadTime");
        String roadTime = scanner.next();
        String response = controller.createTrain(id, capacity, type,speed,roadTime);
        System.out.println(response);
    }


    public void getAllCarriagesMenu() {
        String response = carController.getAllCarriages();
        System.out.println(response);
    }

    public void getCarriageByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = carController.getCarriage(id);
        System.out.println(response);
    }

    public void createCarriageMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter train id which this carriage belong");
        int belongsTo = scanner.nextInt();
        System.out.println("Please enter capacity");
        int capacity = scanner.nextInt();
        System.out.println("Please enter type");
        String type = scanner.next();
        String response = carController.createCarriage(id, belongsTo,capacity,type);
        System.out.println(response);
    }
}
