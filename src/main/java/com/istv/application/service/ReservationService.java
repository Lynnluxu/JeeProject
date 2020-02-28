package com.istv.application.service;

import com.istv.application.messaging.MessageSender;
import com.istv.application.model.Appartment;
import com.istv.application.model.InventoryReservation;
import com.istv.application.model.Reservation;
import com.istv.application.model.ReservationStatus;
import com.istv.application.repository.ReservationRepository;
import com.istv.application.util.BasicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("reservationService")
public class ReservationService {
    @Autowired
    MessageSender messageSender;
    @Autowired
    ReservationRepository reservationRepository;

    public ReservationService() {
    }

    public ReservationService(MessageSender messageSender, ReservationRepository reservationRepository){
        this.messageSender = messageSender;
        this.reservationRepository = reservationRepository;
    }

    public Reservation getReservation(String reservationId){
        Reservation reservation = reservationRepository.getReservation(reservationId);
        return  reservation;
    }

    public void sendReservation(Reservation reservation) {

        reservation.setReservationId(BasicUtil.getUniqueId());
        reservation.setReservationStatus(ReservationStatus.CREATED);

        reservationRepository.putReservation(reservation);
        messageSender.sendMessage(reservation);

    }

    public void acceptReservation(Reservation reservation){
        reservationRepository.acceptReservation(reservation);
    }

    public void declineReservation(Reservation reservation){
        reservationRepository.declineReservation(reservation);
    }

    public void updateReservation(InventoryReservation response) {

        Reservation reservation = reservationRepository.getReservation(response.getReservationId());
        if(response.getReturnCode()==200){
            reservation.setReservationStatus(ReservationStatus.CONFIRMED);
        }else if(response.getReturnCode()==300){
            reservation.setReservationStatus(ReservationStatus.FAILED);
        }else{
            reservation.setReservationStatus(ReservationStatus.PENDING);
        }
        reservationRepository.putReservation(reservation);
    }

    public Map<String, Reservation> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

}
