package ADS.NovoZap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NovoZapApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovoZapApplication.class, args);
	}

}