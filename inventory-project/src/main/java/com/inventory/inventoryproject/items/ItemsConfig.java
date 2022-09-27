package com.inventory.inventoryproject.items;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemsConfig {

	@Bean
	CommandLineRunner commandLineRunner(ItemsRepository repository) {
		return args -> {
			Items pizza = new Items(
					"Pizza",
					"Italian",
					1
			);

			Items hamburger = new Items(
					"Hamburger",
					"US Kitchen",
					0
			);

			Items burrito = new Items(
					"Burrito",
					"Mexican",
					1
			);

			repository.saveAll(List.of(pizza, hamburger, burrito));
		};
	}

}
