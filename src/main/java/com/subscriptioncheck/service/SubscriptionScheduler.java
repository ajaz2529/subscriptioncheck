package com.subscriptioncheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionScheduler {

    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void checkSubscriptions() {
        userService.checkExpiredSubscriptions();
    }
}

