package com.baeldung.simplereactiveapi.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.baeldung.simplereactiveapi.model.Foo;

import reactor.core.publisher.Flux;

@Service
public class FooService {
	
	/**
	 * This method emits a new Foo object every second
	 * @return Flux of Foo objects
	 */
	public Flux<Foo> getFoo() {
		
		// Using interval method to emit an Id for new Foo object every second starting from 0
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new Foo(i, "Foo No." + i));
	}
	

}
