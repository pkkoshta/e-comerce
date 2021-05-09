package com;

import com.controller.FlipKartController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;

@SpringBootApplication
@EnableJpaRepositories
//@ComponentScan({"com.controller"})
public class DemoApplication {

	public static void main(String[] args) {
		new File(FlipKartController.FileDir).mkdir();
		SpringApplication.run(DemoApplication.class, args);

	}

}
