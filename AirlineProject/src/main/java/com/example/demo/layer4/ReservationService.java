package com.example.demo.layer4;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.Reservation;

@Service
public interface ReservationService {
	void addReservationService(Reservation rRef);   //C - add/create
	Reservation findReservationService(int tno);     //R - find/reading
	Set<Reservation> findAllReservationService();     //R - find all/reading all
	void modifyReservationService(Reservation rRef); //U - modify/update
	void removeReservationService(int tno);
	Set<Reservation> findTicketDetailService(int tno); 
}
