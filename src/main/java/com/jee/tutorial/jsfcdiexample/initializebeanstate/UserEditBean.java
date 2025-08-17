package com.jee.tutorial.jsfcdiexample.initializebeanstate;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named
@ViewScoped
public class UserEditBean implements Serializable {

    @Inject
    private UserService userService;

    // This property will be populated by <o:viewParam> from the URL.
    @Getter @Setter
    private Long userId;

    // This property will hold the loaded User entity for the view to display.
    @Getter
    private User user;

    /**
     * This method is called by <f:viewAction> AFTER the userId has been
     * set and validated by <o:viewParam>.
     * It's the central logic for preparing this view's data.
     */
    public void loadUser() {
        System.out.println(">>> Loading user with ID: " + userId);
        userService.findById(userId).ifPresentOrElse(
                foundUser -> {
                    // If the user is found, assign it to our property.
                    this.user = foundUser;
                },
                () -> {
                    // If user is not found, add a global FacesMessage for the user.
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not Found", "User could not be found."));
                }
        );
    }

}