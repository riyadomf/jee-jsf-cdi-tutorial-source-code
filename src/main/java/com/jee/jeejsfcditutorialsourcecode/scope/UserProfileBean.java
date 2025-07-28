package com.jee.jeejsfcditutorialsourcecode.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named
@SessionScoped
// SessionScoped beans MUST be Serializable for clustering and server restarts.
public class UserProfileBean implements Serializable {

    @Getter @Setter
    private String theme = "light"; // Default theme

    public void toggleTheme() {
        this.theme = "light".equals(theme) ? "dark" : "light";
    }




    @PostConstruct
    public void init() {
        System.out.println(">>> SessionScoped bean created: " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(">>> SessionScoped bean destroyed: " + this);
    }
}