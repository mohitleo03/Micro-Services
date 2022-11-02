package org.ncu.hirewheels.repository;

import java.util.Optional;

import org.ncu.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.first_name like ?1")
    public Optional<User> getUserByFirstName(String firstName);

    @Query("select u from User u where u.first_name like ?1 or u.last_name like ?1")
    public Optional<User> getUserByFirstOrLastName(String firstOrLastName);

    @Query("select u from User u where u.email like ?1")
    public Optional<User> getUserByEmail(String email);

    @Query("select u from User u where u.mobile_no like ?1")
    public Optional<User> getUserByMobileNo(String mobileno);
}
