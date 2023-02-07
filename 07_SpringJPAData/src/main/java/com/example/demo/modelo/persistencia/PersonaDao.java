package com.example.demo.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Persona;

//Persona representa la entidad
//Integer representa el tipo de la clave primaria de la entidad
@Repository
public interface PersonaDao extends JpaRepository<Persona, Integer>{

}
