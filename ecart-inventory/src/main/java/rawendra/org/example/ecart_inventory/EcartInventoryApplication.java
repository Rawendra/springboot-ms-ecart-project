package rawendra.org.example.ecart_inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class EcartInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcartInventoryApplication.class, args);
	}

}
