package com.xg.controller;

import com.xg.domain.Rental;
import com.xg.service.RentalService;
import com.xg.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 15:26.
 * @DESCRIPTION:
 */

@RestController
@RequestMapping("/rest/rental")
public class RentalController {

    @Autowired
    private RentalService service;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Rental findRental(@PathVariable(value = "id") int id) {
        return service.get(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Rental> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNo = (pageNo == null) ? CommonConstants.DEFAULT_PAGE_NO : pageNo;
        pageSize = (pageSize == null) ? CommonConstants.DEFAULT_PAGE_SIZE : pageSize;
        return service.findAll(name, new PageRequest(pageNo, pageSize));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Rental add(@RequestBody Rental entity) {
        return service.add(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Rental entity) {
        return service.delete(entity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.DELETE)
    public Rental update(@RequestBody Rental entity) {
        return service.update(entity);
    }
}