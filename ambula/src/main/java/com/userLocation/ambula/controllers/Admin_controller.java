package com.userLocation.ambula.controllers;

import com.userLocation.ambula.dto.User_location_dto;
import com.userLocation.ambula.exceptions.UserException;
import com.userLocation.ambula.models.User;
import com.userLocation.ambula.models.User_location;
import com.userLocation.ambula.repositories.UserRepo;
import com.userLocation.ambula.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin_controller {



    @Autowired
    private AdminService adminService;

// This Api help in add data in User_location table and return data which is saved in user_location tables.
// Only User_type as admin can use this api. For other it will throw UserException.

    @PostMapping("/create_data")
    public ResponseEntity<User_location> create_data(@RequestBody User_location_dto user_location_dto) throws UserException {
        //    This will return responseEntity with User_location object and with response of Created
       return new ResponseEntity<>(adminService.createUserLocation(user_location_dto),
               HttpStatus.CREATED);
    }

//   This Api help in update user data related to user_location table.
//   Only User_type as admin cam use this api. For other it will throw UserException.
    @PutMapping("/update_data")
    public ResponseEntity<User_location> update_data(@RequestBody User_location_dto user_location_dto ) throws UserException {
        //    This will return responseEntity with User_location object and with response of Accepted
        return new ResponseEntity<>(adminService.update_data(user_location_dto),HttpStatus.ACCEPTED);
    }

//    This API help in create user as admin.
//    In future we can add password here so that as admin everybody can not use this API.

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) throws UserException {
        //    This will return responseEntity with User object and with response of Created
        return new ResponseEntity<>(adminService.createNewUser(user),HttpStatus.CREATED);
    }

    @PostMapping("/signupReader")
    public ResponseEntity<User> createReaderUser(@RequestBody User user) throws UserException {
        //    This will return responseEntity with User object and with response of Created
        return new ResponseEntity<>(adminService.createNewReaderUser(user),HttpStatus.CREATED);
    }


}
