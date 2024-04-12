package pe.borabora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class ApiBoraBoraMovilKotlinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBoraBoraMovilKotlinApplication.class, args);
		
		//Imprimir contraseña encriptada en consola 
		//Contraseña: 1234
		//System.out.println(new BCryptPasswordEncoder().encode("12345"));
	}

}
