import service.PersistenceService;
import service.Task1Service;
import service.Task2Service;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application Stated");
        runTasks();
    }

    public static void runTasks() {
        try (PersistenceService ps = PersistenceService.getInstance()) {
            Task1Service task1Service = new Task1Service(ps);
            task1Service.runTask1();

            Task2Service task2Service = new Task2Service(ps);
            task2Service.runTask2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
