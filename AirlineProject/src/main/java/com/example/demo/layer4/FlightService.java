package com.example.demo.layer4;

import java.util.Set;

import com.example.demo.layer2.Flight;

public interface FlightService {
	void addFlightService(Flight fRef);   //C - add/create
	Flight findFlightService(int flightNo);     //R - find/reading
	Set<Flight> findAllFlightService();     //R - find all/reading all
	void modifyFlightService(Flight fRef); //U - modify/update
	void removeFlightService(int flightNo); //D - remove/delete
	
	Set<Flight> findAllFlightService(String src,String dest);
}
