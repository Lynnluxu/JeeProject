package com.istv.application.controller;

import com.istv.application.model.Appartment;
import com.istv.application.model.Reservation;
import com.istv.application.model.User;
import com.istv.application.service.AppartmentService;
import com.istv.application.service.ReservationService;
import com.istv.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    AppartmentService appartmentService;
    @Autowired
    ReservationService reservationService;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName());
        modelAndView.setViewName("home.html");
        return modelAndView;
    }

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User current_user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("appartments", appartmentService.listAll());
        List<Appartment> appart = appartmentService.findAppartmentByOwnerId(current_user.getId());

        modelAndView.addObject("user", current_user)
                .addObject("reservations", reservationService.getAllReservations())
                .addObject("appartOwner", appart);
        modelAndView.setViewName("profile.html");
        return modelAndView;
    }

    @RequestMapping(value="/appartment_details", method = RequestMethod.POST)
    public ModelAndView appartment_details(@RequestParam(name = "id")int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User current_user = userService.findUserByEmail(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentUser", current_user);
        modelAndView.addObject("appartment", appartmentService.findAppartmentById(id));
        modelAndView.setViewName("appartment_details");
        return modelAndView;
    }

    @PostMapping(value = "/reservationRequest")
    public ModelAndView sendReservation(Reservation reservation, @RequestParam(name = "id")int id){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User current_user = userService.findUserByEmail(auth.getName());
        Appartment appartment = appartmentService.findAppartmentById(id);
        reservation.setRenterId(current_user.getId());
        reservation.setOwnerId(appartment.getOwner().getId());
        reservation.setAppartmentId(appartment.getId());
        reservationService.sendReservation(reservation);
        modelAndView.addObject("reservation", reservation)
                .addObject("success", "Reservation demand for " + appartment.getTitle() + " sended to " +appartment.getOwner().getName());
        modelAndView.setViewName("reservationRequest");
        return modelAndView;
    }

    @PostMapping(value = "/reservationDecision")
    public ModelAndView reservationDecision(@RequestParam(name = "choice")int choice, @RequestParam(name = "id")String id){
        ModelAndView modelAndView = new ModelAndView();
        Reservation reservation = reservationService.getReservation(id);
        if (choice == 1){
            reservationService.acceptReservation(reservation);
        }else if(choice == 0){
            reservationService.declineReservation(reservation);
        }
        modelAndView.addObject("reservationStatus","status of this demand is : "+reservation.getReservationStatus());
        return modelAndView;
    }

    @RequestMapping(value="/appartment_list", method = RequestMethod.GET)
    public ModelAndView appartment_list(){
        ModelAndView modelAndView = new ModelAndView();
        Appartment appartment = new Appartment();
        modelAndView.addObject("appartments", appartmentService.listAll());
        modelAndView.setViewName("appartment_list");
        return modelAndView;
    }

    @RequestMapping(value="/appartment_registration", method = RequestMethod.GET)
    public ModelAndView appartment_registration(){
        ModelAndView modelAndView = new ModelAndView();
        Appartment appartment = new Appartment();
        modelAndView.addObject("appartment", appartment);
        modelAndView.setViewName("appartment_registration");
        return modelAndView;
    }

    @RequestMapping(value="/appartment_registration", method = RequestMethod.POST)
    public ModelAndView createNewAppartment(@Valid Appartment appartment, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userId",user.getId());
        Appartment appartmentExists = appartmentService.findAppartmentById(appartment.getId());
        if (appartmentExists != null) {
            bindingResult
                    .rejectValue("appartment", "error.appartment",
                            "There is already a appartment registered with this id");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("appartment_registration");
        } else {
            appartmentService.saveAppartment(appartment,user);
            modelAndView.addObject("successMessage", "Appartment has been registered successfully");
            modelAndView.addObject("appartment", new Appartment());
            modelAndView.setViewName("appartment_registration");
        }

        return modelAndView;
    }
}
