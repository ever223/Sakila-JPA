package com.xg.controller;

import com.xg.domain.Customer;
import com.xg.service.CustomerService;
import com.xg.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 15:21.
 * @DESCRIPTION:
 */

@RestController
@RequestMapping("/rest/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Customer findCustomer(@PathVariable(value = "id") int id) {
        Customer customer = service.get(id);
        return customer;
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Customer> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNo = (pageNo == null) ? CommonConstants.DEFAULT_PAGE_NO : pageNo;
        pageSize = (pageSize == null) ? CommonConstants.DEFAULT_PAGE_SIZE : pageSize;
        return service.findAll(name, new PageRequest(pageNo, pageSize));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer add(@RequestBody Customer entity) {
        return service.add(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Customer entity) {
        return service.delete(entity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.DELETE)
    public Customer update(@RequestBody Customer entity) {
        return service.update(entity);
    }
}