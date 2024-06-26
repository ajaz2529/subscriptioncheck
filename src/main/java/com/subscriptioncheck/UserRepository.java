package com.subscriptioncheck;

import com.subscriptioncheck.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByExpiryDateBefore(LocalDate date);
}
