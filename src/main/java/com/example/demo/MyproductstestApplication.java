package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.dao.ProductsRepository;
import com.example.demo.model.Products;




@SpringBootApplication

@EnableJpaAuditing
@EnableAutoConfiguration

public class MyproductstestApplication implements CommandLineRunner{

	@Autowired
	ProductsRepository pr;
	
	public static void main(String[] args) {
		SpringApplication.run(MyproductstestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//pr.save(new Products());
		System.out.println("done");
	}
	

}
