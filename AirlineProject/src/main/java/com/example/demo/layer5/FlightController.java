package com.example.demo.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Flight;
import com.example.demo.layer4.FlightService;

@RestController
public class FlightController {

	@Autowired
	FlightService flightServ;
	
	@GetMapping(path="/getFlight/{myFlightId}")
	@ResponseBody
	public ResponseEntity<Flight> getFlight(@PathVariable("myFlightId") int flightId){
		System.out.println("Flight Controller....Understanding client and talking to service layer...");
		Flight flightObj =null;
		
		flightObj = flightServ.findFlightService(flightId);
		
		if(flightObj==null)
		{ return ResponseEntity.notFound().build();
		
		}
		else {
			return ResponseEntity.ok(flightObj);
		} 
	}
	
	
}
