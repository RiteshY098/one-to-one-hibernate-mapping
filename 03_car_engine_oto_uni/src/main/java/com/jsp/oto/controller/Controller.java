package com.jsp.oto.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.oto.model.Car;
import com.jsp.oto.model.Engine;

public class Controller {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgsql");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();


	public boolean addDetail(Car car, Engine engine) {
		// TODO Auto-generated method stub
		if (car != null && engine != null) {
			entityTransaction.begin();
			entityManager.persist(car);
			entityManager.persist(engine);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}
	
	public Car findCar(int car_id) {
		return entityManager.find(Car.class, car_id);
	}
	
	public boolean updateCar(int car_id, double updated_cost) {
		Car car = findCar(car_id);
		if (car != null) {
			car.setCost(updated_cost);
			entityTransaction.begin();
			entityManager.merge(car);
			entityTransaction.commit();
			return true;
		} 
		return false;
	}
	public boolean removeCar(int car_id) {
		Car car = findCar(car_id);
		if (car != null) {
			entityTransaction.begin();
			entityManager.remove(car);
			entityManager.remove(car.getEngine());
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
