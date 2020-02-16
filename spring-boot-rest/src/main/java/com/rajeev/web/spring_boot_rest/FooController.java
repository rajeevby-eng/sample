package com.rajeev.web.spring_boot_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.rajeev.web.spring_boot_rest.persistence.Foo;
import com.rajeev.web.spring_boot_rest.persistence.IFooService;

import com.google.common.base.Preconditions;

@RestController
@RequestMapping("/foos")
class FooController {
 
    @Autowired
    private IFooService service;
 
    @GetMapping
    public List<Foo> findAll() {
    	System.out.println("find all");
        return service.findAll();
    }
 
    @GetMapping(value = "/{id}")
    public Foo findById(@PathVariable("id") Long id) {
    	System.out.println("find by id: " + id);
        return RestPreconditions.checkFound(service.findById(id));
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Foo resource) {
        Preconditions.checkNotNull(resource);
        return service.create(resource).getId();
    }
 
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Foo resource) {
    	System.out.println("update id: " + id);
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkFound(service.findById(resource.getId()));
        service.update(resource);
    }
 
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
    	System.out.println("delete id: " + id);
        service.deleteById(id);
    }
 
}