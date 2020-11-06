package com.vtctuto.vtctuto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConductorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int conductorId;
    private String conductorName;
    private String conductorLname;

    public int getConductorId() {
        return conductorId;
    }

    public void setConductorId(int conductorId) {
        this.conductorId = conductorId;
    }

    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }


    public String getConductorLname() {
        return conductorLname;
    }

    public void setConductorLname(String conductorLname) {
        this.conductorLname = conductorLname;
    }
}
