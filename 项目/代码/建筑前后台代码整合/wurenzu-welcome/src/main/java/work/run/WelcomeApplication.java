package work.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients//启用feig
@EnableDiscoveryClient
@SpringBootApplication
public class WelcomeApplication {
	public static void main(String[] args) {
		SpringApplication.run(WelcomeApplication.class, args);
	}

}
