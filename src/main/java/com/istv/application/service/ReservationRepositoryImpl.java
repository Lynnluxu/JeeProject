package com.istv.application.service;

import com.istv.application.model.Reservation;
import com.istv.application.model.ReservationStatus;
import com.istv.application.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("reservationRepository")
public class ReservationRepositoryImpl implements ReservationRepository {

    private final Map<String, Reservation> reservations = new ConcurrentHashMap<String, Reservation>();

    @Override
    public void putReservation(Reservation reservation) {
        reservations.put(reservation.getReservationId(), reservation);
    }

    @Override
    public void acceptReservation(Reservation reservation){
        for(String i: reservations.keySet()){
            if(reservation.getReservationId() == i){
                for(Reservation value: reservations.values()){
                    value.setReservationStatus(ReservationStatus.ACCEPTED);
                }
            }
        }
    }

    @Override
    public void declineReservation(Reservation reservation){
        for(String i: reservations.keySet()){
            if(reservation.getReservationId() == i){
                for(Reservation value: reservations.values()){
                    value.setReservationStatus(ReservationStatus.REFUSED);
                }
            }
        }
    }

    @Override
    public Reservation getReservation(String reservationId) {
        return reservations.get(reservationId);
    }

    public Map<String, Reservation> getAllReservations(){
        return reservations;
    }
}
