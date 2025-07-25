package com.jee.jeejsfcditutorialsourcecode.scope;

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
}