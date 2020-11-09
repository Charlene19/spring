package com.tpvtcdim.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "ASSOC_LOAN_CAR", schema = "dbo", catalog = "vtc_TP")
@IdClass(AssocLoanCarPK.class)
public class AssocLoanCar {
    private int carId;
    private int loanId;

    @Id
    @Column(name = "CAR_ID", nullable = false, precision = 0)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

        AssocLoanCar that = (AssocLoanCar) o;

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
