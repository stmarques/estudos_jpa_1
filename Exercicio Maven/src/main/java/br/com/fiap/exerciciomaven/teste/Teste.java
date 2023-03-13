package br.com.fiap.exerciciomaven.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.exerciciomaven.dao.EmbarquesDao;
import br.com.fiap.exerciciomaven.jpautil.FabricaConexoes;
import br.com.fiap.exerciciomaven.model.Embarques;

public class Teste {
	
	public static void main(String[] args) {
		
		cadastrar();
		
		buscarPorId();
		
	}
	
	private static void cadastrar() {
		Embarques embarques = new Embarques();
		embarques.setNomeDestino("Minas Gerais");
		embarques.setDataEmbarque(new GregorianCalendar(2023,Calendar.AUGUST,1));
		embarques.setDataDesembarque(new GregorianCalendar(2023,Calendar.AUGUST,6));
		
		EntityManager gerenciadorEntidades = FabricaConexoes.getEntityManager();
		EmbarquesDao embarquesdao = new EmbarquesDao(gerenciadorEntidades);
		
		try {
			gerenciadorEntidades.getTransaction().begin();
			embarquesdao.cadastrar(embarques);
		    gerenciadorEntidades.remove(embarques);
			gerenciadorEntidades.getTransaction().commit();
		}catch(Exception e) {
			if(gerenciadorEntidades.getTransaction().isActive()) {
				gerenciadorEntidades.getTransaction().rollback();
			}
		}
		
		gerenciadorEntidades.close();
	}
	
	private static void buscarPorId() {
		EntityManager gerenciadorEntidades = FabricaConexoes.getEntityManager();
		EmbarquesDao embarquesdao = new EmbarquesDao(gerenciadorEntidades);
		Embarques embarques = embarquesdao.pesquisarPorId(1);
		System.out.println(embarques);
	}
	
	private static void remover() {
		
		EntityManager gerenciadorEntidades = FabricaConexoes.getEntityManager();
		EmbarquesDao embarquesdao = new EmbarquesDao(gerenciadorEntidades);
	}
	
}

