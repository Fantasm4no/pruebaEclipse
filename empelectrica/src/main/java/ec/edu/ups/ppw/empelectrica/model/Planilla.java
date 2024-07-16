package ec.edu.ups.ppw.empelectrica.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_Planilla")
public class Planilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pla_id")
	private int planillaId;
	
	@Column(name="pla_fechaInicio")
	private Date fechaInicio;
	
	@Column(name="pla_fechaFin")
	private Date fechaFin;
	
	@Column(name="pla_consumo")
	private double consumo;

	public int getPlanillaId() {
		return planillaId;
	}

	public void setPlanillaId(int planillaId) {
		this.planillaId = planillaId;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	@ManyToOne
	@JoinColumn(name="cli_id")
	private Cliente clientes;

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}
}
