package com.jee.jeejsfcditutorialsourcecode.scope;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class FeedbackBean {

    @Getter @Setter
    private String message;

    /**
     * Submits the feedback and redirects. After the redirect, this bean instance
     * will be destroyed.
     * @return The navigation outcome with a redirect.
     */
    public String submit() {
        System.out.println("Feedback Received: " + message);
        // After this redirect, the RequestScoped bean is gone.
        return "thankyou.xhtml?faces-redirect=true";
    }
}