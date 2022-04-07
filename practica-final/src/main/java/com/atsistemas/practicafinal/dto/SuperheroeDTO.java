package com.atsistemas.practicafinal.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.atsistemas.practicafinal.model.Superheroe;

@Entity
@Table(name = "superheroes")
public class SuperheroeDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "superheroe", unique = true)
	private String nombre;
	@Column(name = "estado")
	private String estado;
	

	public SuperheroeDTO()
	{
		super();
	}
	
	public SuperheroeDTO(Superheroe heroeEntity)
	{
		super();
		this.id = heroeEntity.getId();
		this.nombre = heroeEntity.getNombre();
		this.estado = heroeEntity.getEstado();
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