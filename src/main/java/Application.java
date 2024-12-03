import service.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Application Started");
        try (PersistenceService ps = PersistenceService.getInstance()) {
            DataGenerationService dgs = new DataGenerationService(ps);
            dgs.createData();

            HelperService hs = new HelperService(ps);
            hs.runTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
