package com.istv.application.service;

import com.istv.application.model.Appartment;
import com.istv.application.model.User;
import com.istv.application.repository.AppartmentRepository;
import com.istv.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("appartmentService")
public class AppartmentService {

    private AppartmentRepository appartmentRepository;
    private UserRepository userRepository;

    @Autowired
    public AppartmentService(UserRepository userRepository, AppartmentRepository appartmentRepository) {
        this.appartmentRepository = appartmentRepository;
        this.userRepository = userRepository;
    }

    public Appartment findAppartmentById(int id) {
        return appartmentRepository.findById(id);
    }

    public void saveAppartment(Appartment appartment, User user) {
        appartment.setOwner(user);
        appartmentRepository.save(appartment);
    }

    public List<Appartment> findAppartmentByOwnerId(int owner_id){
        List<Appartment> appartments = new ArrayList<>();
        appartmentRepository.findByOwnerId(owner_id).forEach(appartments::add);
        return appartments;
    }

    public List<Appartment> listAll() {
        List<Appartment> appartments = new ArrayList<>();
        appartmentRepository.findAll().forEach(appartments::add);
        return appartments;
    }
}
