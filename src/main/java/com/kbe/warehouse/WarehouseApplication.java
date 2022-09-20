package com.kbe.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarehouseApplication {

	public static void main(String[] args) {

		ReadComponentCSV fans = new ReadComponentCSV();
		System.out.println(fans.getHardwareComponentsFromFile().toString());

		SpringApplication.run(WarehouseApplication.class, args);
	}

}
