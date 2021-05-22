package com.example.demo.layer3;

import java.util.Set;
import org.springframework.stereotype.Repository;
import com.example.demo.layer2.Seat;

@Repository
public interface SeatsRepository {
	
	void addSeat(Seat sRef);   //C - add/create
	Seat findSeat(String SeatNo);     //R - find/reading
	Set<Seat> findSeat();     //R - find all/reading all
	void modifySeat(Seat sRef); //U - modify/update
	void removeSeat(int slightNo); //D - remove/delete
	
	Set<Seat> findSeatByUserid(int uid);
	Set<Seat> findSeatByTicketno(int tno);
}
