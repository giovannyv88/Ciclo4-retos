package Reto1_ciclo4.Reto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages = {"Reto1_ciclo4.Reto1.Modelos"})
@SpringBootApplication
public class Reto1Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto1Application.class, args);
	}

}
