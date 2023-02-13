package com.example.demo.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Persona;

//Persona representa la entidad
//Integer representa el tipo de la clave primaria de la entidad
@Repository
public interface PersonaDao extends JpaRepository<Persona, Integer>{
	
	public List<Persona> findByNombre(String nombre);
	
	//JpaData proporciona una convencion para la creacion metodos que hagan
		//peticiones a la bbdd. Si seguimos la convencion que nos marca JpaData
		//podemos hacer queries a bbdd de manera muy sencilla	
		
	/*
		// Si el metodo empieza por "findBy" y luego pondemos el atributo que queramos
		//,hacemos busquedas por ese atributo. Al devolver una lista nos devolvera
		//todas las coincidencias exactas, si pusieramos una unica Pelicula, nos
		//devolveria la primera coincidencia
		public List<Pelicula> findByDirector(String director);
		
		//Adminte operadores logicos "And" y "Or" entre atributos
		public List<Pelicula> findByDirectorAndGenero(String director, String genero);
		public List<Pelicula> findByDirectorOrGenero(String director, String genero);
		
		//Si poneis "findAll" os devolvera todas las peliculas
		//Poniendo "By" podemos poner otras condiciones
		//"OrderBy" ordena por un atributo
		//Tambien podemos poner "Asc" o "Desc" al final para ordenar en orden
		//ascendente o descendente
		public List<Pelicula> findAllByOrderByTituloAsc();
		public List<Pelicula> findAllByOrderByTituloDesc();
		
		//Si queremos que busque por cadenas que contengan el titulo podemos
		//usar la palabra "Containing"
		public List<Pelicula> findByTituloContaining(String titulo);
		public List<Pelicula> findByTituloAndGeneroContaining(String titulo, String genero);
		
		//Si queremos que busquedas por cadenas ignorando mayusculas y minusculas
		//podemos usar la palabra "IgnoreCase"
		public List<Pelicula> findByTituloIgnoreCase(String titulo);
		public List<Pelicula> findByTituloAndGeneroIgnoreCase(String titulo, String genero);
		
		//Si queremos que busque por cadenas que contanga el titulo o el genero
		//y que no importa que sean mayusculas y minusculas
		public List<Pelicula> findByTituloIgnoreCaseContaining(String titulo);
		public List<Pelicula> findByTituloAndGeneroIgnoreCaseContaining(String titulo, String genero);
			
		//JPQL
		@Query("select p from Pelicula p where p.genero=?1")
		public List<Pelicula> findByMovidaDeLaMuerte(String genero);
		*/

}
