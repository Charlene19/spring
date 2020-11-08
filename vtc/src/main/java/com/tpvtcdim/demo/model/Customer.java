package com.tpvtcdim.demo.model;

import javax.persistence.*;

@Entity
public class Customer {
    private int customerId;
    private String customerUsername;
    private String customerPassword;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false, precision = 0)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "CUSTOMER_USERNAME", nullable = false, length = 100)
    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    @Basic
    @Column(name = "CUSTOMER_PASSWORD", nullable = false, length = 100)
    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (customerUsername != null ? !customerUsername.equals(customer.customerUsername) : customer.customerUsername != null)
            return false;
        if (customerPassword != null ? !customerPassword.equals(customer.customerPassword) : customer.customerPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (customerUsername != null ? customerUsername.hashCode() : 0);
        result = 31 * result + (customerPassword != null ? customerPassword.hashCode() : 0);
        return result;
    }
}
