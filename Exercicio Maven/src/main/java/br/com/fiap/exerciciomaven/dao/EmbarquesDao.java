package br.com.fiap.exerciciomaven.dao;

import javax.persistence.EntityManager;

import br.com.fiap.exerciciomaven.model.Embarques;

public class EmbarquesDao {

	//construtor deve ser público, sem retorno e possui o mesmo nome da classe. 
	//construtor deve construir o objeto, inicializar a variavel com um valor padrão.
	EntityManager gerenciadorEntidades;
	public EmbarquesDao(EntityManager gerenciadorEntidades) {
		this.gerenciadorEntidades = gerenciadorEntidades;
	}

	//método cadastrar
	public void cadastrar(Embarques cadastrarEmbarques){
		gerenciadorEntidades.persist(cadastrarEmbarques);
		
	}
	
	//método para atualizar
	public void atualizar(Embarques atualizarEmbarques){
		gerenciadorEntidades.merge(atualizarEmbarques);
		
	}	
	
	//método para remover
	public void remover(Embarques removerEmbarques){
		gerenciadorEntidades.remove(removerEmbarques);
}

	public Embarques pesquisarPorId(int id){
		return gerenciadorEntidades.find(Embarques.class, id);
	}
	
}

