package com.baeldung.simplereactiveapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.simplereactiveapi.model.Foo;
import com.baeldung.simplereactiveapi.service.FooService;

import reactor.core.publisher.Flux;

@RestController
public class FooController {
	

	@Autowired
	private FooService fooService;
	
	// This endpoint emits a new Foo as JSON object every 1 second
    @GetMapping(value = "/foo")
    public Flux<Foo> getFoo() {
    	
        return fooService.getFoo();
    }
    


}
