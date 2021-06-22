package de.julia.kitabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.julia.kitabase.model.Child;
import de.julia.kitabase.repository.ChildRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(final ChildRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Child("Heinrich", "Fritz")));
		      log.info("Preloading " + repository.save(new Child("Müller", "Max")));
		      log.info("Preloading " + repository.save(new Child("Millie", "Huebsch")));
		};
	}
	
}
