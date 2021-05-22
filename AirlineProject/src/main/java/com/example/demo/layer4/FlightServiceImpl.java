package com.example.demo.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Flight;
import com.example.demo.layer3.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Override
	public void addFlightService(Flight fRef) {
		System.out.println("Flight Service....Some scope of bussiness logic here...");
		flightRepo.addFlight(fRef);
	}

	@Override
	public Flight findFlightService(int flightNo) {
		System.out.println("Flight Service....Some scope of bussiness logic here...");

		return flightRepo.findFlight(flightNo);
	}

	@Override
	public Set<Flight> findAllFlightService() {
		System.out.println("Flight Service....Some scope of bussiness logic here...");
		
		return flightRepo.findAllFlight();
	}

	@Override
	public void modifyFlightService(Flight fRef) {
		System.out.println("Flight Service....Some scope of bussiness logic here...");
		flightRepo.modifyFlight(fRef);

	}

	@Override
	public void removeFlightService(int flightNo) {
		System.out.println("Flight Service....Some scope of bussiness logic here...");
		flightRepo.removeFlight(flightNo);
	}

	@Override
	public Set<Flight> findAllFlightService(String src, String dest) {
		System.out.println("Flight Service....Some scope of bussiness logic here...");
		
		return flightRepo.findFlight(src, dest);
	}

}
