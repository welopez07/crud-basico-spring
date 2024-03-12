package com.api.crud.models;

import jakarta.persistence.*;

@Entity //una entidad que rep. una tabla en la BBDD, cada instancia de una entidad corresponde a una fila en la tabla
@Table(name= "user") //proporciona detalles adicionales sobre la tabla a la que está mapeada la entidad
public class UserModel {

    @Id // actúa como la llave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // especifica cómo se debe generar el valor de la llave primaria.
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
