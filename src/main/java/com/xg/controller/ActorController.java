package com.xg.controller;

import com.xg.domain.Actor;
import com.xg.service.ActorService;
import com.xg.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 16:49.
 * @DESCRIPTION:
 */
@RestController
@RequestMapping("/rest/actor")
public class ActorController {

    @Autowired
    private ActorService service;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Actor findActor(@PathVariable(value = "id") int id) {
        return service.get(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Actor> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNo = (pageNo == null) ? CommonConstants.DEFAULT_PAGE_NO : pageNo;
        pageSize = (pageSize == null) ? CommonConstants.DEFAULT_PAGE_SIZE : pageSize;
        return service.find(name, new PageRequest(pageNo, pageSize));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Actor add(@RequestBody Actor entity) {
        return service.add(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Actor entity) {
        return service.delete(entity);
    }
    @RequestMapping(value = "/update", method = RequestMethod.DELETE)
    public Actor update(@RequestBody Actor entity) {
        return service.update(entity);
    }
}
