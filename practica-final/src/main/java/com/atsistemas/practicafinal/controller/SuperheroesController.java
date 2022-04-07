package com.atsistemas.practicafinal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.atsistemas.practicafinal.dto.SuperheroeDTO;
import com.atsistemas.practicafinal.model.Superheroe;
import com.atsistemas.practicafinal.service.SuperheroeService;

public class SuperheroesController
{
	@Autowired
	private SuperheroeService superheroeService;
	
	//Método GET para mostrar una lista de todos los superhéroes.
	@GetMapping(value = "superheroes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Superheroe> listarSuperheroes()
	{
		return superheroeService.listarSuperheroes();
	}
	
	//Método GET que devuelve un superhéroe buscando por id.
	@GetMapping(value = "superheroes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Superheroe listarSuperheroe(@PathVariable Integer id)
	{
		return superheroeService.obtenerSuperheroe(id);
	}
	
	//MEtodo GET que devuelve una lista de superhéroes buscando por estado.
	@GetMapping(value = "superheroes/estado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Superheroe> buscarPorEstado(@PathVariable(name = "id") String idEstado)
	{
		return superheroeService.buscarPorEstado(idEstado);
	}
	
	//Método POST para crear un superhéroe.
	@PostMapping(value = "superheroes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Superheroe crearSuperheroe(@RequestBody Superheroe superheroeEntity) throws Exception
	{
		try
		{
			SuperheroeDTO superheroe = new SuperheroeDTO(superheroeEntity);
			return superheroeService.guardar(superheroeEntity);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			throw new Exception("Error en la creación de un superheroe", e.getCause());
		}
	}

	//Método PUT para modificar un superhéroe.
	@PutMapping(value = "superheroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Superheroe actualizarSuperheroe(@PathVariable Integer id, @RequestBody Superheroe superheroe) throws Exception
	{
		try
		{
			List<Superheroe> lista = new ArrayList<Superheroe>();
			lista.add(superheroe);
			SuperheroeDTO heroe = new SuperheroeDTO();
			lista.stream().forEach(h -> {
				heroe.setId(h.getId());
				heroe.setNombre(h.getNombre());
				heroe.setEstado(h.getEstado());
			});
			return superheroeService.guardar(superheroe);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			throw new Exception("Error en la actualizacion de un superheroe", e.getCause());
		}
	}
	
	//MEtodo GET que devuelve una lista de superhéroes buscando por nombre que contenga un parámetro.
	@GetMapping(value = "superheroes/nombre/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Superheroe> buscarPorNombre(@PathVariable(name = "id") String idNombre)
	{
		return superheroeService.buscarPorNombre(idNombre);
	}
	
	//Método PUT para modificar el estado de un superhéroe a "muerto".
	@PutMapping(value = "superheroes/estado/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Superheroe modificarSuperheroe(@PathVariable(name = "id") Integer idEstado, @RequestBody Superheroe superheroe)
	{
		superheroe.setEstado("muerto");
		return superheroeService.guardar(superheroe);
	}
	
	//Método DELETE para eliminar un registro.
	@DeleteMapping(value = "superheroes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarSuperheroe(@PathVariable(value = "id") Integer id)
	{
		Superheroe heroe = superheroeService.obtenerSuperheroe(id);
		superheroeService.eliminarSuperheroe(heroe);
	}
	
	//Gestión de errores.
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView pantallaError(HttpServletRequest request, RuntimeException ex)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}
}