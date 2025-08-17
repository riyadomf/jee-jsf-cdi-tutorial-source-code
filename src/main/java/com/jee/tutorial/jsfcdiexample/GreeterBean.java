package com.jee.tutorial.jsfcdiexample;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;


@Named
@RequestScoped
public class GreeterBean {
    @Getter @Setter
    private String name;
}
