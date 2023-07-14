package com.userLocation.ambula.repositories;

import com.userLocation.ambula.models.User_location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface User_location_repo extends JpaRepository<User_location,String> {



    @Query(value = "SELECT name, latitude, longitude, " +
            "SQRT(POW(latitude - 0, 2) + POW(longitude - 0, 2)) AS distance " +
            "FROM User_location " +
            "ORDER BY distance " +
            "LIMIT :limit", nativeQuery = true)
    List<User_location> findNearestUsers(@Param("limit") int limit);


}
