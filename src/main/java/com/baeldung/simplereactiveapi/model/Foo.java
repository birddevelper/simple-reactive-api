package com.baeldung.simplereactiveapi.model;

public class Foo {
	
    private Long id;
    private String name;

    public Foo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    

    
}
