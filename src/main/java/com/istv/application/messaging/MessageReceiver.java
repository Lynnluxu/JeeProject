package com.istv.application.messaging;

import com.istv.application.model.InventoryReservation;
import com.istv.application.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MessageReceiver {
    private static final String RESERVATION_RESPONSE_QUEUE = "reservation-response-queue";

    @Autowired
    ReservationService reservationService;


    @JmsListener(destination = RESERVATION_RESPONSE_QUEUE)
    public void receiveMessage(final Message<InventoryReservation> message) throws JMSException {
        MessageHeaders headers =  message.getHeaders();
        InventoryReservation response = message.getPayload();
        reservationService.updateReservation(response);
    }
}
