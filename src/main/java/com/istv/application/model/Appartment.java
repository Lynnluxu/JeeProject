package com.istv.application.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Appartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPARTMENT_ID", nullable=false, unique=true)
    private int id;
    @Column(name = "APPARTMENT_PRICE", nullable = false)
    @NotEmpty(message = "*Ce champs est obligatoire")
    private double price;

    private Date startDate;
    private Date endDate;
    private User lodger;
    private User owner;
}
