package com.atsistemas.practicafinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atsistemas.practicafinal.model.Superheroe;

public interface SuperheroeRepository extends JpaRepository<Superheroe, Integer>
{
	//Consulta que devuelve un registro de superhéroes con un estado en concreto.
	public List<Superheroe> findByEstado(@Param(value = "estado") String estado);
	
	//Consulta que devuelve un refistro de superhéroes donde los nombre contengan un parámetro.
	@Query(value = "SELECT p FROM Superheroe p WHERE p.nombre LIKE :nombre")
	public List<Superheroe> findByNombre(@Param(value = "nombre") String nombre);
}