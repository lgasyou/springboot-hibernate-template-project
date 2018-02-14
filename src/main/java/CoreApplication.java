import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xenon.central")
public class CoreApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CoreApplication.class, args);
    }

}
