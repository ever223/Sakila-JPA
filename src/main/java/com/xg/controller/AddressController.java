package com.xg.controller;

import com.xg.domain.Address;
import com.xg.service.AddressService;
import com.xg.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-25 14:10.
 * @DESCRIPTION:
 */

@RestController
@RequestMapping("/rest/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Address findActor(@PathVariable(value = "id") int id) {
        return addressService.get(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Address> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNo = (pageNo == null) ? CommonConstants.DEFAULT_PAGE_NO : pageNo;
        pageSize = (pageSize == null) ? CommonConstants.DEFAULT_PAGE_SIZE : pageSize;
        return addressService.findAll(name, new PageRequest(pageNo, pageSize));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Address add(@RequestBody Address address) {
        return addressService.add(address);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Address address) {
        return addressService.delete(address);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

}
