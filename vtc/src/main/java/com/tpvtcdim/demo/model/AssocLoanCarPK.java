package com.tpvtcdim.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AssocLoanCarPK implements Serializable {
    private int carId;
    private int loanId;

    @Column(name = "CAR_ID", nullable = false, precision = 0)
    @Id
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

        AssocLoanCarPK that = (AssocLoanCarPK) o;

        if (carId != that.carId) return false;
        if (loanId != that.loanId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + loanId;
        return result;
    }
}
