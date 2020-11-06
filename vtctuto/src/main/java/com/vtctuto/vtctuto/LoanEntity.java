package com.vtctuto.vtctuto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanId;
    private Date loanDateStart;
    private Date loanDateEnd;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }


    public Date getLoanDateStart() {
        return loanDateStart;
    }

    public void setLoanDateStart(Date loanDateStart) {
        this.loanDateStart = loanDateStart;
    }


    public Date getLoanDateEnd() {
        return loanDateEnd;
    }

    public void setLoanDateEnd(Date loanDateEnd) {
        this.loanDateEnd = loanDateEnd;
    }
}
