package com.example.CoachingWallah.service;

import com.example.CoachingWallah.entity.Users;
import com.example.CoachingWallah.repository.UsersRepo;
import com.example.CoachingWallah.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepo usersRepo;

    public Users addUser(Users user){
        return usersRepo.save(user);
    }

    public Boolean loginUser(LoginRequest loginRequest){
        Optional<Users> user = usersRepo.findById(loginRequest.getUserId());
                if(user== null){
                    return false;
                }
                Users user1 = user.get();

                if(!user1.getPassword().equals(loginRequest.getPassword())){
                    return false;
                }
        return true;
    }
}
