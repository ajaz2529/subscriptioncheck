package com.subscriptioncheck.service;

import com.subscriptioncheck.UserRepository;
import com.subscriptioncheck.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    public void checkExpiredSubscriptions() {
        LocalDate today = LocalDate.now();
        List<User> expiredSubscriptions = userRepository.findByExpiryDateBefore(today);

        for (User user : expiredSubscriptions) {
            // Add your logic to handle expired subscriptions
            System.out.println("Subscription expired for user: " + user.getUsername());
            emailService.sendSimpleMessage(user.getEmail(), "Subscription Expired", "you subscription is expired please recharge to continue your services");

        }
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
