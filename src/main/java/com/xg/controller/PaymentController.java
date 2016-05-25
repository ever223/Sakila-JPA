package com.xg.controller;

import com.xg.domain.Payment;
import com.xg.service.PaymentService;
import com.xg.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 15:25.
 * @DESCRIPTION:
 */

@RestController
@RequestMapping("/rest/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Payment findPayment(@PathVariable(value = "id") int id) {
        return service.get(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Payment> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNo = (pageNo == null) ? CommonConstants.DEFAULT_PAGE_NO : pageNo;
        pageSize = (pageSize == null) ? CommonConstants.DEFAULT_PAGE_SIZE : pageSize;
        return service.findAll(name, new PageRequest(pageNo, pageSize));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Payment add(@RequestBody Payment entity) {
        return service.add(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Payment entity) {
        return service.delete(entity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.DELETE)
    public Payment update(@RequestBody Payment entity) {
        return service.update(entity);
    }
}