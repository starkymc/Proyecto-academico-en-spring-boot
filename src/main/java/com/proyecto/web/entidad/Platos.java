package com.proyecto.web.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

@Entity
@Table(name="platos")
public class Platos implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idplato;
	@Nullable
	private String nomplato;
	
	@Nullable
	private int precio;
	
	private String imagen;
	
	
	
	
	

	public int getIdplato() {
		return idplato;
	}

	public void setIdplato(int idplato) {
		this.idplato = idplato;
	}

	public String getNomplato() {
		return nomplato;
	}

	public void setNomplato(String nomplato) {
		this.nomplato = nomplato;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Platos(int idplato, String nomplato, int precio,String imagen) {
		super();
		this.idplato = idplato;
		this.nomplato = nomplato;
		this.precio = precio;
		
		this.imagen = imagen;
	}


	public Platos() {
		super();
	}

	
	
	
	
	
	

	

}
