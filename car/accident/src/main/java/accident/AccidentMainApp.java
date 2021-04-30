package accident;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("entity")
@ComponentScan(basePackages = { "controller","service","dto","mapper"})
public class AccidentMainApp {
    public static void main(String[] args) {
        SpringApplication.run(AccidentMainApp.class, args);
    }
}
