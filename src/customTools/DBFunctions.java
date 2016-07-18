package customTools;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.*;

public class DBFunctions {
	public static void insert(Greview review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(review);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static void insert(Grestaurant restaurant) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(restaurant);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static void insert(Guser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static void update(Greview review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(review);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static void update(Guser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static Guser getUserByEmail(String email){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Guser u where u.email = :email";
		TypedQuery<Guser> q = em.createQuery(qString, Guser.class);
		q.setParameter("email",email);
		Guser user = null;
		try{
			user = q.getSingleResult();
		}catch(NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return user;
	}
	
	public static List<Grestaurant> getRestaurants(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select r from Grestaurant r";
		TypedQuery<Grestaurant> q = em.createQuery(qString, Grestaurant.class);
		List<Grestaurant> r = null;
		try{
			r = q.getResultList();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
		}
		return r;
	}
	
	public static Grestaurant getRestaurantByID(String id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select r from Grestaurant r where r.grestaurantid=:rid";
		TypedQuery<Grestaurant> q = em.createQuery(qString, Grestaurant.class);
		q.setParameter("rid", new BigDecimal(id));
		Grestaurant r = null;
		try{
			r = q.getSingleResult();
		}catch(NoResultException e){
			System.out.println(e);
			em.close();
		}
		return r;
	}
}
