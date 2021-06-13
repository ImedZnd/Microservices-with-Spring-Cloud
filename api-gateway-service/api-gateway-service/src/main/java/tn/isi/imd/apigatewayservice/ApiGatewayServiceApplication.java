package tn.isi.imd.apigatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ApiGatewayServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiGatewayServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

	@GetMapping("/")
	public Mono<String> home(WebSession webSession) {
		return Mono.just(webSession.getId());
	}

}
