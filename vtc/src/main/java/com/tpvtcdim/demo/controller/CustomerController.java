package com.tpvtcdim.demo.controller;

import com.tpvtcdim.demo.model.Customer;
import com.tpvtcdim.demo.model.Loan;
import com.tpvtcdim.demo.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class CustomerController {

    @Autowired
    CustomerServices customerServices;
    @Value("${method.unavailable}")
    private String erreurMessage;

    @PostMapping("/createCustomer")
    public String addCustomer(@RequestParam String customerUsername, @RequestParam String customerPassword) {
        Customer customer = new Customer();
        customer.setCustomerUsername(customerUsername);
        customer.setCustomerPassword(customerPassword);
        customerServices.createCustomer(customer);


        return ("/Ajout");
    }

    @GetMapping("/listCustomers")
    public String customerList(Model model) {

        java.util.List<Customer> customers = customerServices.customerList();
        model.addAttribute("customers", customers);
    return "listCustomers";

    }

    @RequestMapping(value ="/deleteCustomer/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(name = "id") String id){


        return ("listCustomers");
    }

    @GetMapping(value ="/deleteCustomer")
    public String delete(Customer customer, Model model){
        customer = (Customer) model.getAttribute("customer");
        customerServices.deleteCustomer(customer);

        return "/Ajout";
    }
    @GetMapping(value ="/updateCustomer")
    public String update(Model model){
        model.addAttribute("erreurMessage", erreurMessage);
        return "/Erreur";}
}
