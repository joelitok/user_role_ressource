package com.proplant.backend;

import java.util.stream.Stream;

import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.repository.entity.AppUser;
import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.ressource.repository.dao.RessourceRepository;
import com.proplant.backend.domaines.ressource.repository.entity.Ressource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
  
	@Autowired
	private RessourceRepository ressourceRepository;
	@Autowired
	private AccountService accountService;
	
	
		public static void main(String[] args) {
			SpringApplication.run(BackendApplication.class, args);
		}
	
		@Bean
		public BCryptPasswordEncoder getBCPE(){
			return new BCryptPasswordEncoder();
		}
	
	   @Override
	   public void run(String... args) throws Exception{
	   
	   accountService.deleteUsers();   
	   accountService.saveUser(new AppUser(null,"admin","1234",null));
	   accountService.saveUser(new AppUser(null,"user","1234",null));
	
	   accountService.deleteRoles();
	   accountService.saveRole(new AppRole(null,"ADMIN"));
	   accountService.saveRole(new AppRole(null,"USER"));
	
	   accountService.addRoleToUser("admin", "ADMIN");
	   accountService.addRoleToUser("user", "USER");
		   
		  ressourceRepository.deleteAll();
		  Stream.of("Ressource 1","Ressource 2","Ressource 3").forEach(t->{
			  ressourceRepository.save(new Ressource(null,t));
		  }); 
	
			ressourceRepository.findAll().forEach(t->{
				System.out.println(t.getName());
				
			});
		}
	
	}
	
