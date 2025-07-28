package com.jee.jeejsfcditutorialsourcecode.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;

@Named
@ApplicationScoped
public class SiteStatsBean {

    // Using AtomicInteger makes our counter thread-safe, which is CRITICAL
    // for a shared ApplicationScoped bean.
    private AtomicInteger totalVotes;



    public void incrementVoteCount() {
        totalVotes.incrementAndGet();
    }

    public int getTotalVotes() {
        return totalVotes.get();
    }






//    @PostConstruct
//    public void init() {
//        totalVotes = new AtomicInteger(0);
//        System.out.println("Application-scoped SiteStatsBean created!");
//    }

    @PostConstruct
    public void init() {
        totalVotes = new AtomicInteger(0);
        System.out.println(">>> ApplicationScoped bean created: " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(">>> ApplicationScoped bean destroyed: " + this);
    }

}