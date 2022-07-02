package models;

import entities.Aluno;
import entities.Curso;
import entities.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.security.spec.ECField;
import java.util.List;

public class CursoModel {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Professor professor;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            if (curso.getProfessor().getId() != null) {
                professor = entityManager.find(Professor.class, curso.getProfessor().getId());
                curso.setProfessor(professor);
            }
            entityManager.persist(curso);
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

    public Curso findById(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso cursoEncontrado = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            cursoEncontrado = entityManager.find(Curso.class, curso.getId());
            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            cursoEncontrado = null;
        }finally {
            if (entityManager != null)
                entityManager.close();
        }
        return cursoEncontrado;
    }

    public List<Curso> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Curso> cursoTodos = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            cursoTodos = entityManager.createQuery("FROM " + Curso.class.getName()).getResultList();
            entityTransaction.commit();

        }catch (Exception exception){
            exception.printStackTrace();
            cursoTodos = null;
            if (entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if (entityManager != null)
                entityManager.close();

        }
        return cursoTodos;
    }

    public void update(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(curso);
            entityTransaction.commit();
        }catch(Exception exception){
            exception.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public void delete(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso cursoDeletado;

        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            cursoDeletado = entityManager.find(Curso.class, curso.getId());
            entityManager.remove(cursoDeletado);
            entityTransaction.commit();
        }catch(Exception exception){
            exception.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }
}
