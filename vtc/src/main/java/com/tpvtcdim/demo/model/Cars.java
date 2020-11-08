package com.tpvtcdim.demo.model;

import javax.persistence.*;

@Entity
public class Cars {
    private int carId;
    private String carBrand;
    private String carModel;
    private String carColor;
    private String carRegistration;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID", nullable = false, precision = 0)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "CAR_BRAND", nullable = false, length = 100)
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @Basic
    @Column(name = "CAR_MODEL", nullable = false, length = 100)
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Basic
    @Column(name = "CAR_COLOR", nullable = false, length = 100)
    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Basic
    @Column(name = "CAR_REGISTRATION", nullable = false, length = 100)
    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars cars = (Cars) o;

        if (carId != cars.carId) return false;
        if (carBrand != null ? !carBrand.equals(cars.carBrand) : cars.carBrand != null) return false;
        if (carModel != null ? !carModel.equals(cars.carModel) : cars.carModel != null) return false;
        if (carColor != null ? !carColor.equals(cars.carColor) : cars.carColor != null) return false;
        if (carRegistration != null ? !carRegistration.equals(cars.carRegistration) : cars.carRegistration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + (carBrand != null ? carBrand.hashCode() : 0);
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + (carColor != null ? carColor.hashCode() : 0);
        result = 31 * result + (carRegistration != null ? carRegistration.hashCode() : 0);
        return result;
    }
}
