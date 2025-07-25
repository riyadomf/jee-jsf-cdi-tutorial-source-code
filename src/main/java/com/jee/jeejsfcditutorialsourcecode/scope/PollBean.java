package com.jee.jeejsfcditutorialsourcecode.scope;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named
@ViewScoped
// ViewScoped beans should always be Serializable as a best practice.
public class PollBean implements Serializable {

    @Getter
    private int votesForJava = 0;
    @Getter
    private int votesForCSharp = 0;
    @Getter @Setter
    private String selectedOption;


//    /**
//     * This action method returns void, which means JSF will stay on the same view.
//     * Because the bean is ViewScoped, its state (the vote counts) will be preserved.
//     */
//    public void vote() {
//        if ("java".equals(selectedOption)) {
//            votesForJava++;
//        } else if ("csharp".equals(selectedOption)) {
//            votesForCSharp++;
//        }
//    }


    @Inject // Inject the one-and-only instance of our stats bean
    private SiteStatsBean siteStatsBean;

    public void vote() {
        if ("java".equals(selectedOption)) {
            votesForJava++;
            siteStatsBean.incrementVoteCount(); // Increment global counter
        } else if ("csharp".equals(selectedOption)) {
            votesForCSharp++;
            siteStatsBean.incrementVoteCount(); // Increment global counter
        }
    }
}
