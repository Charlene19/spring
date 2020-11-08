package com.tpvtcdim.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Loan {
    private int loanId;
    private Date loanDateStart;
    private Date loanDateEnd;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_ID", nullable = false, precision = 0)
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Basic
    @Column(name = "LOAN_DATE_START", nullable = false)
    public Date getLoanDateStart() {
        return loanDateStart;
    }

    public void setLoanDateStart(Date loanDateStart) {
        this.loanDateStart = loanDateStart;
    }

    @Basic
    @Column(name = "LOAN_DATE_END", nullable = false)
    public Date getLoanDateEnd() {
        return loanDateEnd;
    }

    public void setLoanDateEnd(Date loanDateEnd) {
        this.loanDateEnd = loanDateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        if (loanId != loan.loanId) return false;
        if (loanDateStart != null ? !loanDateStart.equals(loan.loanDateStart) : loan.loanDateStart != null)
            return false;
        if (loanDateEnd != null ? !loanDateEnd.equals(loan.loanDateEnd) : loan.loanDateEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loanId;
        result = 31 * result + (loanDateStart != null ? loanDateStart.hashCode() : 0);
        result = 31 * result + (loanDateEnd != null ? loanDateEnd.hashCode() : 0);
        return result;
    }
}
