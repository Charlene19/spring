package com.vtctuto.vtctuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private static List<com.vtctuto.vtctuto.model.Customer> customers = new ArrayList<>();

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setLogin(first);
        customer.setPassword(last);
        customerRepository.save(customer);

        return "Added new customer to repo!";
    }

    @GetMapping("/listCustomers")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    @RequestMapping(value = { "/listCl" }, method = RequestMethod.GET)
    public String customerList(Model model) {

        model.addAttribute("customers", customers);

        return "/listCustomers";
    }


    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }
}
