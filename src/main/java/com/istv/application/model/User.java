package com.istv.application.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable=false, unique=true)
    private int id;
    @Column(name="USER_EMAIL", length=50, nullable=false, unique=true)
    @Email(message = "*Merci d'insérer un email valide")
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String email;
    @Column(name="USER_PASSWORD", length=200, nullable=false)
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String password;
    @Column(name="USER_NAME", length=50, nullable=false)
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String name;
    @Column(name="USER_LASTNAME", length=50, nullable=false)
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String lastName;
    @Column(name="USER_ACTIVE", length=5, nullable=false)
    private int active;
    @ManyToMany
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;

    public User(){

    }

    public User(int id, String email, String password, String name, String lastName, int active) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.active = active;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", roles=" +
                '}';
    }

}
