package com.istv.application.repository;

import com.istv.application.model.Reservation;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("reservationRepository")
@Primary
public interface ReservationRepository {
    public void putReservation(Reservation reservation);
    public Reservation getReservation(String orderId);
    public void acceptReservation(Reservation reservation);
    public void declineReservation(Reservation reservation);
    public Map<String, Reservation> getAllReservations();
}
