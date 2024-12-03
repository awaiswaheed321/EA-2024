import service.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Application Started");
        try (PersistenceService ps = PersistenceService.getInstance()) {
            DataGenerationService dgs = new DataGenerationService(ps);
            dgs.createData();

            HelperService hs = new HelperService(ps);
            hs.runTasks();

            JPQLPracticeService jpqlPracticeService = new JPQLPracticeService(ps);
            jpqlPracticeService.runPracticeTasks();

            NamedQueryPracticeService namedQueryPracticeService = new NamedQueryPracticeService(ps);
            namedQueryPracticeService.runPracticeQuestions();

            CriteriaApiPracticeService criteriaApiPracticeService = new CriteriaApiPracticeService(ps);
            criteriaApiPracticeService.runCriteriaApiPractice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
