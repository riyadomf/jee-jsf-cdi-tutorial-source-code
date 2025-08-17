package com.jee.tutorial.jsfcdiexample.initializebeanstate;

import jakarta.inject.Named;
import org.omnifaces.cdi.ViewScoped;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class BadBean implements Serializable {
    public List<String> getItems() {
        // This is BAD PRACTICE!
        System.out.println(">>> FAKE DATABASE CALL! Fetching items...");
        return Arrays.asList("Item A", "Item B", "Item C");
    }

}
