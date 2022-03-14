package liga.medical.device.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Service application.
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan("liga.medical.device")
public class DeviceServiceApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(liga.medical.device.core.DeviceServiceApplication.class, args);
    }
}
