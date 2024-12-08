import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.DataGenerationService;
import service.HelperService;

public class Application {
    public static void main(String[] args) {
        System.out.println("Application Started");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        DataGenerationService dgs = context.getBean(DataGenerationService.class);
        dgs.createData();

        HelperService hs = context.getBean(HelperService.class);
        hs.runTasks();
    }
}
