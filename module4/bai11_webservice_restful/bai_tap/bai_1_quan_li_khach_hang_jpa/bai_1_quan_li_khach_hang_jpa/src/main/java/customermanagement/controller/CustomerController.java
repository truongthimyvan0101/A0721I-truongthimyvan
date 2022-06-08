package customermanagement.controller;

import customermanagement.model.Customer;
import customermanagement.service.CustomerService;
import customermanagement.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {
//    @Autowired
//    private CustomerServiceImpl customerService;
//
//    @GetMapping("")
//    public ModelAndView showIndex() {
//        return new ModelAndView("list", "customers", customerService.findAll());
//    }
//
//    @GetMapping("/create-customer")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-customer")
//    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message", "Created customer successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit-customer/{id}")
//    public ModelAndView showEditForm(@PathVariable int id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("edit");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-customer")
//    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete-customer/{id}")
//    public ModelAndView showDeleteForm(@PathVariable int id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("delete");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("delete-customer")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.remove(customer.getId());
//        return "redirect:/";
//    }
//
//    @GetMapping("/view-customer/{id}")
//    public String viewCustomer(@PathVariable int id, Model model) {
//        model.addAttribute("customer", customerService.findById(id));
//        return "view";
//    }
//
//    @GetMapping("search-customer")
//        public String searchByName(@RequestParam("searchName")String name,Model model){
//            List<Customer> customers = customerService.findByName(name);
//            model.addAttribute("customers",customers);
//            return "list";
//    }
@Autowired
private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.findById(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.findById(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.findById(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(Math.toIntExact(id));
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

}
