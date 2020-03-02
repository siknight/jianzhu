package work.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@EnableEurekaServer
@SpringBootApplication

public class EurekaBootApplication {
	 public static void main(String[] args) {
	        SpringApplication.run(EurekaBootApplication.class, args);
	    }
	 
	 
		


}
