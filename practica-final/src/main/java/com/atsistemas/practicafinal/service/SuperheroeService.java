package com.atsistemas.practicafinal.service;

import java.util.List;

import com.atsistemas.practicafinal.model.Superheroe;

public interface SuperheroeService
{
	//Lista para mostrar todos los superhéroes.
	List<Superheroe> listarSuperheroes();
	
	//Obtiene un superhéroe por id.
	Superheroe obtenerSuperheroe(Integer id);
	
	//Lista de superhéroes buscado por estado.
	List<Superheroe> buscarPorEstado(String estado);
	
	//Guardar un superhéroe.
	Superheroe guardar(Superheroe superheroe);
	
	//Lista de superhéroes buscado por nombre que contenga un parámetro.
	List<Superheroe> buscarPorNombre(String nombre);
	
	//Eliminar un registro.
	void eliminarSuperheroe(Superheroe superheroe);
}