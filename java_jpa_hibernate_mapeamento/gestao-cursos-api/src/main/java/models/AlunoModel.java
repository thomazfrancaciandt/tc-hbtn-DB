package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(aluno);
            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            if (entityTransaction != null)
                entityManager.close();
        }
    }
    public Aluno findById(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunoEncontrado = null;

        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoEncontrado = entityManager.find(Aluno.class, aluno.getId());
            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            alunoEncontrado = null;
        }finally {
            if (entityManager != null)
                entityManager.close();
        }
        return alunoEncontrado;
    }

    public List<Aluno> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Aluno> alunoEncontrado = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoEncontrado = entityManager.createQuery("FROM" + Aluno.class.getName()).getResultList();
            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            alunoEncontrado = null;
            if (entityTransaction != null)
                entityManager.close();
        }
           return alunoEncontrado;

     }
    public void update(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(aluno);
            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            if (entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if (entityManager != null)
                entityManager.close();
        }

    }
    public void delete(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunoDeletado;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoDeletado = entityManager.find(Aluno.class, aluno.getId());
            entityManager.remove(alunoDeletado);
            entityTransaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            if (entityTransaction != null)
                entityTransaction.rollback();
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }
}