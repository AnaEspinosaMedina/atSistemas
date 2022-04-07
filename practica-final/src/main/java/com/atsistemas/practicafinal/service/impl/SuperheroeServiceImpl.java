package com.atsistemas.practicafinal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.practicafinal.model.Superheroe;
import com.atsistemas.practicafinal.repository.SuperheroeRepository;
import com.atsistemas.practicafinal.service.SuperheroeService;

@Service
public class SuperheroeServiceImpl implements SuperheroeService
{
	@Autowired
	private SuperheroeRepository superheroeRepository;

	//Método que llama a repository para mostrar una lista de todos los superhéroes.
	@Override
	public List<Superheroe> listarSuperheroes()
	{
		return superheroeRepository.findAll();
	}
	
	//Método que llama a repository para mostrar un superhéroe buscando por id.
	@Override
	public Superheroe obtenerSuperheroe(Integer id)
	{
		return superheroeRepository.findById(id).get();
	}
	
	//Método que llama a repository para mostrar un superhéroe buscando por estado
	@Override
	public List<Superheroe> buscarPorEstado(String estado)
	{
		return superheroeRepository.findByEstado(estado);
	}
	
	//Método que llama a repository para guardar un superhéroe, ya sea un registro nuevo o modificar un registro.
	@Override
	public Superheroe guardar(Superheroe superheroe)
	{
		return superheroeRepository.save(superheroe);
	}
	
	//Método que llama a repository para buscar una lista de registro por nombre donde el nombre contenga un parámetro.
	@Override
	public List<Superheroe> buscarPorNombre(String nombre)
	{
		return superheroeRepository.findByNombre(nombre);
	}
	
	//Método que llama repository para eliminar un superheroe.
	@Override
	public void eliminarSuperheroe(Superheroe superheroe)
	{
		superheroeRepository.delete(superheroe);
	}
}