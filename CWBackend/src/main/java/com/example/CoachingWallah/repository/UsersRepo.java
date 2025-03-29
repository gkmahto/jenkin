package com.example.CoachingWallah.repository;

import com.example.CoachingWallah.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository <Users, String> {
}
