package com.proyecto.web.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.Nullable;
import com.proyecto.web.entidad.Platos;

@Entity
@Table(name="ventas")
public class Ventas implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idventa;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	private String nomcliente;
	
	@Nullable
	private int pago;
	
	@Nullable
	private int vuelto;
	

	// NOtacion que permite definir una relacion de muchos a uno
	// Nombre del atributo que define la relacion
	@ManyToOne
	@JoinColumn(name = "idplato")
	private Platos platos;


	public int getIdventa() {
		return idventa;
	}


	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getNomcliente() {
		return nomcliente;
	}


	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}


	public Platos getPlatos() {
		return platos;
	}


	public void setPlatos(Platos platos) {
		this.platos = platos;
	}


	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public int getVuelto() {
		int vuelto=0;
		vuelto=pago-platos.getPrecio();
		return vuelto;
	}

	public void setVuelto(int vuelto) {
		this.vuelto = vuelto;
	}


	public Ventas(int idventa, Date fecha, String nomcliente, int pago, int vuelto, Platos platos) {
		super();
		this.idventa = idventa;
		this.fecha = fecha;
		this.nomcliente = nomcliente;
		this.pago = pago;
		this.vuelto = vuelto;
		this.platos = platos;
	}


	public Ventas() {
		super();
	}
	
	

}
