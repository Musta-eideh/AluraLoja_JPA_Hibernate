package br.com.alura.loja.testes;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class cadastroDeProduto {

    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi Readmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        // Armazenar no DB
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AluraLoja");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();

        // No caso do código acima, o objeto(Celular) é no tipo Produto, que é uma entidade
    }
}
