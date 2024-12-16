import services.CriteriaQueryService;
import services.DataGenerationService;
import services.PersistenceService;
import services.QueriesService;

public class Application {
    public static void main(String[] args) {
        System.out.println("Application started");

        try(PersistenceService ps = PersistenceService.getInstance()) {
//            DataGenerationService dgs = new DataGenerationService(ps);
//            dgs.generateData();

//            QueriesService queriesService = new QueriesService(ps);
//            queriesService.run();

            CriteriaQueryService cqs = new CriteriaQueryService(ps);
            cqs.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
