package com.istv.application.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "APPARTMENT")
public class Appartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPARTMENT_ID", nullable=false, unique=true)
    private int id;
    @Column(name = "APPARTMENT_TITLE", nullable = false, unique = true)
    @NotEmpty(message = "Ce champs est obligatoire")
    private String title;
    @Column(name = "APPARTMENT_PRICE", nullable = false)
    @NotNull
    private double price;
    @Column(name = "APPARTMENT_ADDRESS", nullable = false, unique = true)
    @NotEmpty(message = "Ce champs est obligatoire")
    private String address;
    @Column(name = "APPARTMENT_CAPACITY", nullable = false)
    @NotNull
    private int capacity;
    @Column(name = "APPARTMENT_DESCRIPTION")
    @NotEmpty(message = "Ce champs est obligatoire")
    private String description;
    @Column(name = "APPARTEMENT_TYPE", nullable = false)
    @NotNull
    private Type type;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APPARTMENT_OWNER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User owner;

    public Appartment(){

    }

    public Appartment(double price, String description, User owner) {
        this.price = price;
        this.description = description;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
