package com.example.demo.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Reservation;
import com.example.demo.layer3.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository resRepo;
	
	@Override
	public void addReservationService(Reservation rRef) {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		resRepo.addReservation(rRef);
		System.out.println("Reservation added successfully");
	}

	@Override
	public Reservation findReservationService(int tno) {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		return resRepo.findReservation(tno);
	}

	@Override
	public Set<Reservation> findAllReservationService() {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		return resRepo.findAllReservation();
	}

	@Override
	public void modifyReservationService(Reservation rRef) {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
			resRepo.modifyReservation(rRef);
	}

	@Override
	public void removeReservationService(int tno) {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
			resRepo.removeReservation(tno);
	}

	@Override
	public Set<Reservation> findTicketDetailService(int tno) {
		System.out.println("Reservation Service....Some scope of bussiness logic here...");
		return resRepo.findTicketDetails(tno);
	}

}
