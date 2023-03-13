package br.com.fiap.exerciciomaven.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaConexoes {

// constante publica que não pode estanciada (static) e não recebe herança (final).	
	public static final EntityManagerFactory FABRICA = Persistence.createEntityManagerFactory("exercicio_maven");
	
	public static EntityManager getEntityManager() {
	
		return FABRICA.createEntityManager();
		
		
	}

}
