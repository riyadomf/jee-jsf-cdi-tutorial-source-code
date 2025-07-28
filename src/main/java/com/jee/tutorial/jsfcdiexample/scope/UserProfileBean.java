package com.jee.tutorial.jsfcdiexample.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named
@SessionScoped
// SessionScoped beans MUST be Serializable for clustering and server restarts.
public class UserProfileBean implements Serializable {
    @Inject
    HttpServletRequest request;

    @Getter @Setter
    private String theme = "light"; // Default theme

    public String toggleTheme() {
        this.theme = "light".equals(theme) ? "dark" : "light";
        return "page1?faces-redirect=true";
    }

    public String destroySession() throws ServletException {
        request.logout();
        request.getSession().invalidate();
        return "page1?faces-redirect=true";
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