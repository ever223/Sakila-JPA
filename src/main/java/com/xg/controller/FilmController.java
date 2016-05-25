package com.xg.controller;

import com.xg.domain.Film;
import com.xg.service.FilmService;
import com.xg.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-24 23:47.
 * @DESCRIPTION:
 */
@RestController
@RequestMapping("/rest/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Film findActor(@PathVariable(value = "id") int id) {
        return filmService.get(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Film> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pageNo", required = false) Integer pageNo,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNo = (pageNo == null) ? CommonConstants.DEFAULT_PAGE_NO : pageNo;
        pageSize = (pageSize == null) ? CommonConstants.DEFAULT_PAGE_SIZE : pageSize;
        return filmService.find(name, new PageRequest(pageNo, pageSize));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Film add(@RequestBody Film film) {
        return filmService.add(film);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Film film) {
        return filmService.delete(film);
    }
}
