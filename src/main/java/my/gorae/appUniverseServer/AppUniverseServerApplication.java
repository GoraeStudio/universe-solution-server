package my.gorae.appUniverseServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppUniverseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppUniverseServerApplication.class, args);
	}

}
