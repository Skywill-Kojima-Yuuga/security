package com.example.demosecurity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer>{
    Users findByEmail(String email);
}
