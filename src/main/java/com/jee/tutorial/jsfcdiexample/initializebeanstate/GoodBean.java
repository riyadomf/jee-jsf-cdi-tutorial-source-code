package com.jee.tutorial.jsfcdiexample.initializebeanstate;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * DEMONSTRATION: The correct way to perform initialization in a JSF backing bean.
 * This bean uses @PostConstruct to ensure expensive operations run only once.
 */
@Named
@ViewScoped
public class GoodBean implements Serializable {

    // This will hold the data after it's loaded.
    private List<String> items;

    // A real application would inject a service to fetch data.
    // @Inject
    // private ItemService itemService;

    /**
     * This method is annotated with @PostConstruct.
     * It is guaranteed to run exactly ONCE after the bean is created and all
     * dependencies (@Inject) are available.
     * This is the PERFECT place for initialization logic.
     */
    @PostConstruct
    public void init() {
        System.out.println(">>> FAKE DATABASE CALL in @PostConstruct! Fetching items...");
        // In a real app: this.items = itemService.findAll();
        this.items = Arrays.asList("Pre-loaded Item A", "Pre-loaded Item B", "Pre-loaded Item C");
    }

    /**
     * The getter method is now simple, fast, and efficient.
     * It just returns the data that's already loaded into memory.
     * The JSF lifecycle can call this method many times without performance issues.
     * @return The pre-loaded list of items.
     */
    public List<String> getItems() {
        return items;
    }
}
