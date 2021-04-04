package br.com.alura.treinamentojpahibernate.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.treinamentojpahibernate.dao.CategoriaDAO;
import br.com.alura.treinamentojpahibernate.dao.ProdutoDAO;
import br.com.alura.treinamentojpahibernate.modelo.Categoria;
import br.com.alura.treinamentojpahibernate.modelo.Produto;
import br.com.alura.treinamentojpahibernate.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastrarProdutoECategoria();
	}
	
	private static void cadastrarProdutoECategoria() {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}
