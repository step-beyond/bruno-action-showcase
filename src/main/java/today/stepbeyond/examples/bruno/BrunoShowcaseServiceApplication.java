package today.stepbeyond.examples.bruno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BrunoShowcaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrunoShowcaseServiceApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}

}
