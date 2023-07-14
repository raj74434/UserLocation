package com.userLocation.ambula.repositories;

import com.userLocation.ambula.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
//    This method will string name as parameter and find according to name and if name found then return
//     User Object else return null value.
    public User findByName(String name);
}
