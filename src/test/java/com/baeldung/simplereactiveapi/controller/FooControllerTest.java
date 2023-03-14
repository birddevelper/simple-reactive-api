package com.baeldung.simplereactiveapi.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.baeldung.simplereactiveapi.model.Foo;
import reactor.test.StepVerifier;


@SpringBootTest
@AutoConfigureWebTestClient
class FooControllerTest {

    @Autowired
    private WebTestClient webTestClient;
	
	
	@Test
	void testGetFoo() {
		
			// The test takes 3 first objects emitted by /foo endpoint, and evaluates them
	        webTestClient.get()
	        .uri("/foo")
	        .exchange()
	        .expectStatus().isOk()
	        .returnResult(Foo.class)
	        .getResponseBody()
	        .take(3)
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
