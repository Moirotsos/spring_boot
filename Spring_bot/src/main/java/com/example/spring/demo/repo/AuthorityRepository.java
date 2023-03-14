package com.example.spring.demo.repo;

import com.example.spring.demo.entity.Authority;
import com.example.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {


}
