package com.jee.jeejsfcditutorialsourcecode;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;


@Named
@RequestScoped
public class GreeterBean {
    @Getter
    @Setter
    private String name;










    /**
    This is Dependency Injection!
    It tells CDI: "Please find a MessageService and give me an instance."
    **/
    @Inject
    MessageService messageService;

    public String getMessage() {
        return messageService.getGreeting();
    }
}
