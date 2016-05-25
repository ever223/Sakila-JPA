package com.xg.controller;

import com.xg.domain.City;
import com.xg.service.CityService;
import com.xg.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 23:03.
 * @DESCRIPTION:
 */
@RestController
@RequestMapping("/rest/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public City findActor(@PathVariable(value = "id") int id) {
        return cityService.get(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<City> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNo = (pageNo == null) ? CommonConstants.DEFAULT_PAGE_NO : pageNo;
        pageSize = (pageSize == null) ? CommonConstants.DEFAULT_PAGE_SIZE : pageSize;
        return cityService.find(name, new PageRequest(pageNo, pageSize));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public City add(@RequestBody City city) {
        return cityService.add(city);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody City city) {
        return cityService.delete(city);
    }
}
