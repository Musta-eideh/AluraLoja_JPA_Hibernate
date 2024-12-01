package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class cadastroDeProduto {

    public static void main(String[] args) {
        Produto celular = new Produto("Xiaomi Readmi","Muito legal", new BigDecimal("800"), Categoria.CELULARES);

        // Armazenar no DB
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AluraLoja");
//        EntityManager em = factory.createEntityManager();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO dao = new ProdutoDAO(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();

        // No caso do código acima, o objeto(Celular) é no tipo Produto, que é uma entidade
    }
}
