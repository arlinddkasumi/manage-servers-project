package com.manageserversproject.server;

import com.manageserversproject.server.enumeration.Status;
import com.manageserversproject.server.model.Server;
import com.manageserversproject.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.manageserversproject.server.enumeration.Status.SERVER_DOWN;
import static com.manageserversproject.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.161", "Linux", "32 GB", "Personal PC", "http://localhost:8080/server/image/server1.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.80", "Windows", "16 GB", "Web Server", "http://localhost:8080/server/image/server2.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.15", "Ubuntu", "64 GB", "Web Server", "http://localhost:8080/server/image/server3.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.27", "Windows", "16 GB", "Personal PC", "http://localhost:8080/server/image/server4.png", SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.0.1", "Linux", "32 GB", "Personal PC", "http://localhost:8080/server/image/server1.png", SERVER_UP));
		};
	}

}
