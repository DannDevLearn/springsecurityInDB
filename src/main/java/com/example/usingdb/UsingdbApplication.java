package com.example.usingdb;

import com.example.usingdb.entity.RoleEntity;
import com.example.usingdb.entity.UserEntity;
import com.example.usingdb.enums.RoleEnum;
import com.example.usingdb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class UsingdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsingdbApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return  args -> {
			RoleEntity rolUser = RoleEntity.builder()
					.roleName(RoleEnum.USER)
					.build();
			RoleEntity rolAdmin = RoleEntity.builder()
					.roleName(RoleEnum.ADMIN)
					.build();
			RoleEntity rolGuest = RoleEntity.builder()
					.roleName(RoleEnum.GUEST)
					.build();
			UserEntity adminGarfield = UserEntity.builder()
					.userName("garfield")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6") //1234 solo de pruebas
					.roles(Set.of(rolAdmin))
					.build();
			UserEntity userOddie = UserEntity.builder()
					.userName("oddie")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.roles(Set.of(rolUser))
					.build();
			UserEntity guest = UserEntity.builder()
					.userName("invitado")
					.password("password")
					.roles(Set.of(rolGuest))
					.build();
			userRepository.saveAll(List.of(adminGarfield, userOddie, guest));
		};
	}

}
