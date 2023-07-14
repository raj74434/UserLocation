package com.userLocation.ambula.services;

import com.userLocation.ambula.dto.User_location_dto;
import com.userLocation.ambula.exceptions.UserException;
import com.userLocation.ambula.models.User;
import com.userLocation.ambula.models.User_location;

public interface AdminService {

    public User_location createUserLocation(User_location_dto user_location_dto) throws UserException;
    public User createNewUser(User user) throws UserException;
    public User_location update_data(User_location_dto  user_location_dto) throws UserException;
    public User createNewReaderUser(User user) throws UserException;



}
