package work.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableFeignClients//启用feig
@EnableDiscoveryClient
@SpringBootApplication
public class MWebApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MWebApplication.class, args);
	} 

}
