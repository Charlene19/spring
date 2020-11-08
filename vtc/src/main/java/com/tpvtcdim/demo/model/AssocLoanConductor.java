package com.tpvtcdim.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "ASSOC_LOAN_CONDUCTOR", schema = "dbo", catalog = "vtc_TP")
@IdClass(AssocLoanConductorPK.class)
public class AssocLoanConductor {
    private int conductorId;
    private int loanId;

    @Id

    @Column(name = "CONDUCTOR_ID", nullable = false, precision = 0)
    public int getConductorId() {
        return conductorId;
    }

    public void setConductorId(int conductorId) {
        this.conductorId = conductorId;
    }

    @Id
    @Column(name = "LOAN_ID", nullable = false, precision = 0)
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

        AssocLoanConductor that = (AssocLoanConductor) o;

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
