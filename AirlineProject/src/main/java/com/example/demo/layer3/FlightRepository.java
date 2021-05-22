package com.example.demo.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Flight;



@Repository
public interface FlightRepository {
	
	void addFlight(Flight fRef);   //C - add/create
	Flight findFlight(int flightNo);     //R - find/reading
	Set<Flight> findAllFlight();     //R - find all/reading all
	void modifyFlight(Flight fRef); //U - modify/update
	void removeFlight(int flightNo); //D - remove/delete
	
	Set<Flight> findFlight(String src,String dest);
	
	/*
	 * List<Department5> findSqlDepartments(); List<Department5>
	 * findJpqlDepartments(); List<Department5> findJpql2Departments();
	 */
	
	
	 

}
