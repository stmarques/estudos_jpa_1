package br.com.fiap.exerciciomaven.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_embarques")
public class Embarques {

	@Id
	@SequenceGenerator(name = "embarques",sequenceName = "sq_tb_embarques",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "embarques")
	@Column(name="cd_embarque")
	private int cdEmbarques;
	
	@Column(name = "nm_destino")
	private String nomeDestino;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_embarque")
	private Calendar dataEmbarque;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_desembarque")
	private Calendar dataDesembarque;
	
	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public Calendar getDataEmbarque() {
		return dataEmbarque;
	}

	public void setDataEmbarque(Calendar dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public Calendar getDataDesembarque() {
		return dataDesembarque;
	}

	public void setDataDesembarque(Calendar dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}

	public int getCdEmbarques() {
		return cdEmbarques;
	}
	
	@Override
	public String toString() {
		return "O EMBARQUE PARA  " +this.nomeDestino+ " ESTÁ PREVISTO PARA " +this.getDataEmbarque().MONTH+ " ATÉ " +this.getDataDesembarque().DATE;
	}
	
	
	
}
