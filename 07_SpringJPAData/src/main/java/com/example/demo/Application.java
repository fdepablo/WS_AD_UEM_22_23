package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.modelo.entidad.Persona;
import com.example.demo.modelo.persistencia.PersonaDao;

@SpringBootApplication
public class Application { 

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(Application.class, args);
		
		PersonaDao dao = context.getBean("personaDao", PersonaDao.class);
		
		Persona p = new Persona();
		p.setNombre("Asterix");
		p.setPeso(56.78);
		p.setEdad(45);
		
		dao.save(p);
		
		Persona p2 = dao.findById(1).get();
		System.out.println(p2);
	}

}
