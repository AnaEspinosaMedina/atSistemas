package com.example.practicafinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.atsistemas.practicafinal.model.Superheroe;
import com.atsistemas.practicafinal.service.impl.SuperheroeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PracticaFinalApplicationTest
{
	@InjectMocks
	SuperheroeServiceImpl service;
	
	//listarSuperheroes
	@Test()
	@DisplayName("Test para obtener una lista de superheroes")
	void listarSuperheroes()
	{	
		//Llamada a método a testear
		List<Superheroe> superheroeActual = service.listarSuperheroes();
		
		//Comprobaciones del resultado esperado
		assertNotNull(superheroeActual);
		assertTrue(superheroeActual.size() > 0);
	}
	
	//obtenerSuperheroe
	@Test
	@DisplayName("Test para buscar una superheroe")
	void test_obtenerSuperheroe()
	{	
		//Llamada a método a testear
		Integer superheroeIdParam = 1;
		Superheroe superheroeActual = service.obtenerSuperheroe(superheroeIdParam);
		
		//Comprobaciones del resultado esperado
		assertNotNull(superheroeActual);
		assertEquals(superheroeIdParam, superheroeActual.getId());
	}
	
	//buscarPorEstado
	@Test
	@DisplayName("Test para buscar un superheroe por estado")
	void test_buscarSuperheroePorEstado()
	{
		//Definición de variables de entrada
		String estado = "vivo";
		
		//Llamada a método a testear
		List<Superheroe> superheroeActual = service.buscarPorEstado(estado);
					
		//Comprobaciones del resultado esperado
		assertNotNull(superheroeActual);
		assertTrue(superheroeActual.size() > 0);
		assertEquals(estado, superheroeActual.get(0).getEstado());
	}
	
	//guardar
	@Test
	@DisplayName("Test para guardar un superheroe")
	void test_guardarSuperheroeId()
	{
		//Definición de variables de entrada
		Superheroe superheroeParam = new Superheroe(1, "Viuda Negra", "Muerto");
		
		//Llamada a método a testear
		Superheroe idActual = service.guardar(superheroeParam);
		
		//Comprobaciones del resultado esperado
		assertNotNull(idActual);
	}
	
	//buscarPorNombre
	@Test()
	@DisplayName("Test para buscar un superheror que contenga un parametro en nombre.")
	void test_buscarPorNombre()
	{
		//Definición de variables de entrada
		String nombre = "man";
		
		//Llamada a método a testear
		List<Superheroe> superheroeActual = service.buscarPorNombre(nombre);
		
		//Comprobaciones del resultado esperado
		assertNotNull(superheroeActual);
		assertTrue(superheroeActual.size() > 0);
		assertEquals(nombre, superheroeActual.get(0).getNombre());
	}
}