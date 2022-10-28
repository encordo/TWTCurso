package com.curso.mercado.persistencia;

import java.util.List;

import javax.persistence.*;

import com.curso.mercado.entidades.Producto;

public class ProductoJPADAO implements GenericDAO<Producto> {
	
	//private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
	private static EntityManagerFactory factory;
	
	static {
		System.out.println("....... CREAR FACTORIA DE EM");
		factory = Persistence.createEntityManagerFactory("OracleHRPU");
	}
	
	
	public ProductoJPADAO() {
		
	}

	@Override
	public void add(Producto entidad) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entidad);
			em.getTransaction().commit();
		} catch (Exception e) {
			//e.printStackTrace();
			em.getTransaction().rollback();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
	}

	@Override
	public List<Producto> getAll() {
		List<Producto> lProductos = null;
		EntityManager em = factory.createEntityManager();
		try {
			Query consulta = em.createQuery("SELECT p FROM Producto p");
			lProductos = consulta.getResultList();
			
		} catch (Exception e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		return lProductos;
	}

	@Override
	public Producto getByID(int id) {
		Producto prod = null;
		EntityManager em = factory.createEntityManager();
		try {
			
			prod = em.find(Producto.class, id);
			
		} catch (Exception e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		return prod;
	}

	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		try {
			
			em.getTransaction().begin();
			em.remove(em.find(Producto.class, id));
			em.getTransaction().commit();
			
		} catch (Exception e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			em.getTransaction().rollback();
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		
	}
	

	@Override
	public void update(Producto entidad) {
		EntityManager em = factory.createEntityManager();
		try {
			
			em.getTransaction().begin();
			em.merge(entidad);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			em.getTransaction().rollback();
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
	}

}
