package com.tpvtcdim.demo.model;

import javax.persistence.*;

@Entity
public class Conductor {
    private int conductorId;
    private String conductorName;
    private String conductorLname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONDUCTOR_ID", nullable = false, precision = 0)
    public int getConductorId() {
        return conductorId;
    }

    public void setConductorId(int conductorId) {
        this.conductorId = conductorId;
    }

    @Basic
    @Column(name = "CONDUCTOR_NAME", nullable = false, length = 100)
    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    @Basic
    @Column(name = "CONDUCTOR_LNAME", nullable = false, length = 100)
    public String getConductorLname() {
        return conductorLname;
    }

    public void setConductorLname(String conductorLname) {
        this.conductorLname = conductorLname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conductor conductor = (Conductor) o;

        if (conductorId != conductor.conductorId) return false;
        if (conductorName != null ? !conductorName.equals(conductor.conductorName) : conductor.conductorName != null)
            return false;
        if (conductorLname != null ? !conductorLname.equals(conductor.conductorLname) : conductor.conductorLname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conductorId;
        result = 31 * result + (conductorName != null ? conductorName.hashCode() : 0);
        result = 31 * result + (conductorLname != null ? conductorLname.hashCode() : 0);
        return result;
    }
}
