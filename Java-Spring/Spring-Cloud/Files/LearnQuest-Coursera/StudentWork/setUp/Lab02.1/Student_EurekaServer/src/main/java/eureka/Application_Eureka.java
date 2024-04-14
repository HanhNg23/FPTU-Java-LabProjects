package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
 
@SpringBootApplication
//a signal to spring boot use the spring cloud starter eureka server dependency that can launch a Eureka Service on the default port http://localhost:8761/eureka/
@EnableEurekaServer 
public class Application_Eureka {

    public static void main(String[] args) {
    	SpringApplication.run(Application_Eureka.class, args);
    }

}