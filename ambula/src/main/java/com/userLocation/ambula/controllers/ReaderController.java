package com.userLocation.ambula.controllers;

import com.userLocation.ambula.exceptions.UserException;
import com.userLocation.ambula.models.User;
import com.userLocation.ambula.models.User_location;
import com.userLocation.ambula.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

//    This Api created to fetch user_location data according to needs.
//    Here N is number of user_location data which user want.
//    Data will sorted according to location. Which is near it show on top.
    @GetMapping("/get_users/{N}")
    public ResponseEntity<List<User_location>> get_users(@PathVariable("N") Integer limit_of_users){
//        This will return responseEntity with list of user_location and with response of OK .
        return  new ResponseEntity<>(readerService.get_nearest_users(limit_of_users), HttpStatus.OK);
    }
//  admin can register user


}
