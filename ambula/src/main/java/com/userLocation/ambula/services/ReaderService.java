package com.userLocation.ambula.services;

import com.userLocation.ambula.exceptions.UserException;
import com.userLocation.ambula.models.User;
import com.userLocation.ambula.models.User_location;

import java.util.List;

public interface ReaderService {

    public List<User_location> get_nearest_users(Integer limit);



}
