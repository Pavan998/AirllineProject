package com.example.demo.layer3;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Flight;


@Repository
public class FlightRepositoryImpl implements FlightRepository
{


	@PersistenceContext
	 EntityManager entityManager;
	@Transactional
	public void addFlight(Flight fRef) {


		entityManager.persist(fRef);
	}

	@Transactional
	public Flight findFlight(int flightNo) {
	
		
		System.out.println("Flights repo....NO scope of bussiness logic here...");
		/*
		 * Flights flightObj = entityManager.find(Flights.class, flightNo);
		 * System.out.println(flightObj);
		 */
		return entityManager.find(Flight.class, flightNo);
		
	}

	@Transactional
	public void modifyFlight(Flight fRef) {
		entityManager.merge(fRef);
		
		
		
	}

	@SuppressWarnings("unused")
	@Transactional
	public void removeFlight(int flightNo) {
		Flight f = entityManager.find(Flight.class,flightNo);
		entityManager.remove(flightNo);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Set<Flight> findAllFlight() {
		Set<Flight> fSet;
		Query query = entityManager.createQuery("from flights");
		fSet = new HashSet(query.getResultList());
		return fSet;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Set<Flight> findFlight(String src, String dest) {
		Set<Flight> fSet;
		Query query = entityManager.createNativeQuery("select * from flights where source =" +"'"+ src+"'"+" and destination ="+"'"+ dest +"'"+"",Flight.class);
		fSet = new HashSet(query.getResultList());
		return fSet;
	}

}
