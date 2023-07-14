package com.userLocation.ambula.services;

import com.userLocation.ambula.dto.User_location_dto;
import com.userLocation.ambula.exceptions.UserException;
import com.userLocation.ambula.models.User;
import com.userLocation.ambula.models.User_location;
import com.userLocation.ambula.repositories.UserRepo;
import com.userLocation.ambula.repositories.User_location_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private User_location_repo user_location_repo;
    @Autowired
    private User_location  user_location;


//    This method take user_location_dto and conver in User_location class and save in database and
//    return saved User_location object
    @Override
    public User_location createUserLocation(User_location_dto  user_location_dto) throws UserException {

        User user =check_userDto_details(user_location_dto);//here we called this method to veryfy user details like user type ,signup  or not , and password is matching or not

        User_location userLocationForSave = convert_User_location_dto_TO_User_location(user_location_dto);//When every condition passed then we convert User_location dto into User_location object
        return user_location_repo.save(userLocationForSave);// here we saved user_location object in to database with help of repository layer
    }



    @Override
    public User_location update_data(User_location_dto  user_location_dto) throws UserException {
        User user =check_userDto_details(user_location_dto);//here we called this method to veryfy user details like user type ,signup  or not , and password is matching or not
        User_location userLocationForSave = convert_User_location_dto_TO_User_location(user_location_dto); //When every condition passed then we convert User_location dto into User_location object
        return user_location_repo.save(userLocationForSave);//here we update the old user of database.



    }

//    here we called this method to veryfy user details like user type ,signup  or not , and password is matching or not
    public User check_userDto_details(User_location_dto user_location_dto) throws UserException {
        User user =userRepo.findByName(user_location_dto.getName());
        if(user==null)
            throw new UserException("Please do signup first");

        if(!user.getPassword().equals(user_location_dto.getPassword()))
            throw new UserException("Password is incorrect");

        if(!user.getUser_type().equals(User_type.ADMIN))
            throw new UserException("Only admin allowed to use this functionality");

        return user;
    }


//    This method used used by admin to register a admin
    @Override
    public User createNewUser(User user) throws UserException {

        user.setUser_type(User_type.ADMIN);//        Here we set usertype as admin
        User already_user=userRepo.findByName(user.getName());//Here we check is any user with this name already present or not
        if(already_user ==null)return userRepo.save(user);//If user is not present then we saved our user
        else throw new UserException("User already present with this name "+user.getName());//if user is already present with this name then we throw exception
    }

//    Here we register User as a reader
    @Override
    public User createNewReaderUser(User user) throws UserException {

        user.setUser_type(User_type.READER);//        Here we set usertype as reader
        User already_user=userRepo.findByName(user.getName());//Here we check is any user with this name already present or not
        if(already_user ==null)return userRepo.save(user);//If user is not present then we saved our user
        else throw new UserException("User already present with this name "+user.getName());//if user is already present with this name then we throw exception
    }



    //When every condition passed then we convert User_location dto into User_location object
    public User_location convert_User_location_dto_TO_User_location(User_location_dto  user_location_dto){
        if(user_location_dto.getName()!=null||user_location_dto.getName()!="")
            user_location.setName(user_location_dto.getName());

        user_location.setLongitude(user_location_dto.getLongitude());
        user_location.setLatitude(user_location_dto.getLatitude());
        return user_location;
    }

}
