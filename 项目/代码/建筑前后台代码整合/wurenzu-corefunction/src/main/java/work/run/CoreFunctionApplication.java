package work.run;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import work.run.util.DomainFilter;


@SpringBootApplication
@ServletComponentScan(basePackageClasses= {DomainFilter.class})  //处理跨域请求
@MapperScan(basePackages="work.run.dao")
public class CoreFunctionApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CoreFunctionApplication.class, args);
	}

}
