package com.example.demo.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Reservation;
import com.example.demo.layer4.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	ReservationService reservServe;
	
	@GetMapping(path="/getReservation/{myTicketNo}")
	@ResponseBody
	public ResponseEntity<Reservation> getFlight(@PathVariable("myTicketNo") int ticketNo){
		System.out.println("Reservation Controller....Understanding client and talking to service layer...");
		Reservation reservationObj=null;
		
		reservationObj = reservServe.findReservationService(ticketNo);
		
		if(reservationObj==null)
		{ return ResponseEntity.notFound().build();
		
		}
		else {
			return ResponseEntity.ok(reservationObj);
		} 
	}
	
	
	
}
