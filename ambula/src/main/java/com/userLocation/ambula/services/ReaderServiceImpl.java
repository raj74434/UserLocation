package com.userLocation.ambula.services;

import com.userLocation.ambula.exceptions.UserException;
import com.userLocation.ambula.models.User;
import com.userLocation.ambula.models.User_location;
import com.userLocation.ambula.repositories.UserRepo;
import com.userLocation.ambula.repositories.User_location_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService{
    @Autowired
    private User_location_repo user_location_repo;

    @Autowired
    private UserRepo userRepo;


//    Here we fetch user which are near to location(0,0)
    @Override
    public List<User_location> get_nearest_users(Integer limit){

        List<User_location> allLocations=user_location_repo.findAll();
        allLocations
                .sort(Comparator.comparingDouble(location -> calculate_latitude_and_longitude(location.getLatitude(), location.getLongitude())));


        List<User_location> result=new ArrayList<>();
        for(int x=0;x<limit;x++){
            result.add(allLocations.get(x));
        }
        return result;

    }

    public static double calculate_latitude_and_longitude(double latitude, double longitude) {
        double lat1 = Math.toRadians(0);
        double lon1 = Math.toRadians(0);
        double lat2 = Math.toRadians(latitude);
        double lon2 = Math.toRadians(longitude);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return 6371 * c; // Radius of the Earth in kilometers
    }




}
