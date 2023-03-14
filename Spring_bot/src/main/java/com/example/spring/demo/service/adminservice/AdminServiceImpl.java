package com.example.spring.demo.service.adminservice;


import com.example.spring.demo.config.SecurityConfiguration;
import com.example.spring.demo.dtos.request.AddAuthorityDto;
import com.example.spring.demo.dtos.request.AddUserDto;
import com.example.spring.demo.dtos.response.AddedUserDto;
import com.example.spring.demo.dtos.response.PreviewUserDto;
import com.example.spring.demo.entity.Authority;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.repo.AuthorityRepository;
import com.example.spring.demo.repo.UserDetailsRepository;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AuthorityRepository repo;
    @Autowired
    SecurityConfiguration securityConfiguration;
    @Autowired
    UserDetailsRepository adminRepository;

    @Override
    public List<PreviewUserDto> getPreviewUsers() {
        return adminRepository.findAll().stream()
                .map(user -> new PreviewUserDto(user.getId(),user.getUserName(), user.isEnabled()))
                .collect(Collectors.toList());
    }



    @Override
    public ResponseEntity<AddedUserDto> createUser(AddUserDto addUserDto) {


        //User.setAuthorities(authorityList);
        User savedUser = adminRepository.save(buildFromAddUserDto(addUserDto));

        System.out.println("User id " + savedUser.getUsername());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUsername()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<AddAuthorityDto> addAuthority(Authority auth) {
        Authority saveAuthority = repo.save(auth);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveAuthority.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    private User buildFromAddUserDto(AddUserDto addUserDto) {


        return new User(addUserDto.getUserName(),
                securityConfiguration.passwordEncoder().encode(addUserDto.getPassword()),
                addUserDto.isEnabled(),
                fetchAuthoritiesFromRepo(addUserDto.getRolesId()));
    }
    private List<Authority> fetchAuthoritiesFromRepo(List<Integer>  rolesId) {

        return rolesId.stream()
                .map(roleId -> repo.findById(roleId) )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
