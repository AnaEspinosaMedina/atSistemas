package com.atsistemas.practicafinal.model;

public class Superheroe
{
	private Integer id;
	private String nombre;
	private String estado;
	

	public Superheroe()
	{
		super();
	}

	public Superheroe(Integer id, String nombre, String estado)
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getEstado()
	{
		return estado;
	}
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
}