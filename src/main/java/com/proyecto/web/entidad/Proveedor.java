package com.proyecto.web.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idproveedor;

	private String nomproveedor;
	
	private String direccion;

	private String telefono;

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proveedor(int idproveedor, String nomproveedor, String direccion, String telefono) {
		super();
		this.idproveedor = idproveedor;
		this.nomproveedor = nomproveedor;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNomproveedor() {
		return nomproveedor;
	}

	public void setNomproveedor(String nomproveedor) {
		this.nomproveedor = nomproveedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [idproveedor=" + idproveedor + ", nomproveedor=" + nomproveedor + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
	
	
}
