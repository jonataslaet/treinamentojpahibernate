package br.com.alura.treinamentojpahibernate.dao;

import javax.persistence.EntityManager;

import br.com.alura.treinamentojpahibernate.modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}
