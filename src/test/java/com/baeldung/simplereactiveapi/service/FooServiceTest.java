package com.baeldung.simplereactiveapi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.test.StepVerifier;

@SpringBootTest
class FooServiceTest {

	@Autowired
	private FooService fooService;
	
	// The test takes 3 first objects emitted by getFoo() function, and evaluates them
	@Test
	void testGetFoo() {
		
		fooService.getFoo().take(3)
		.as(StepVerifier::create)
        .consumeNextWith(foo -> {
            assertEquals("Foo No.0", foo.getName());
            assertEquals(0, foo.getId());
        })
        .consumeNextWith(foo -> {
            assertEquals("Foo No.1", foo.getName());
            assertEquals(1, foo.getId());
        })
        .consumeNextWith(foo -> {
            assertEquals("Foo No.2", foo.getName());
            assertEquals(2, foo.getId());
        })
        .expectNextCount(0)
        .verifyComplete();
		
	}

}
