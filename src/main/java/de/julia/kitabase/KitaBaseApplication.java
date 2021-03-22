package de.julia.kitabase;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

//@EnableAutoConfiguration
//@ComponentScan({"de.julia.kitabase"})
//@EntityScan(basePackages = "de.julia.kitabase")
//@EnableJpaRepositories(basePackages = "de.julia.kitabase")
@Configuration
@EnableJpaRepositories(basePackages="de.julia.kitabase")
@SpringBootApplication
public class KitaBaseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KitaBaseApplication.class, args);
	}

}


