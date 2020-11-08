package com.tpvtcdim.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AssocLoanConductorPK implements Serializable {
    private int conductorId;
    private int loanId;

    @Column(name = "CONDUCTOR_ID", nullable = false, precision = 0)
    @Id
    public int getConductorId() {
        return conductorId;
    }

    public void setConductorId(int conductorId) {
        this.conductorId = conductorId;
    }

    @Column(name = "LOAN_ID", nullable = false, precision = 0)
    @Id
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssocLoanConductorPK that = (AssocLoanConductorPK) o;

        if (conductorId != that.conductorId) return false;
        if (loanId != that.loanId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conductorId;
        result = 31 * result + loanId;
        return result;
    }
}
