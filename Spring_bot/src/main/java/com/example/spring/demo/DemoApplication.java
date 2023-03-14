package com.example.spring.demo;

import com.example.spring.demo.config.Roles;
import com.example.spring.demo.entity.Authority;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.repo.AuthorityRepository;
import com.example.spring.demo.repo.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@PostConstruct
//	protected void init() {
//
//		List<Authority> authorityList = new ArrayList<>();
//		List<Authority> authorityList2 = new ArrayList<>();
//		List<Authority> authorityList3 = new ArrayList<>();
//		List<Authority> authorityList4 = new ArrayList<>();
//		authorityList.add(createAuthority(Roles.USER.getRoleCode(), Roles.USER.getRoleDescription()));
//		authorityList2.add(createAuthority(Roles.ADMIN.getRoleCode(), Roles.ADMIN.getRoleDescription()));
//		authorityList3.add(createAuthority(Roles.AXIOMATIC.getRoleCode(), Roles.AXIOMATIC.getRoleDescription()));
//		authorityList4.add(createAuthority(Roles.EMPLOYEE.getRoleCode(), Roles.EMPLOYEE.getRoleDescription()));
//
//
//
//		User user=new User();
//		user.setUserName("root");
//		user.setPassword(passwordEncoder.encode("pass123"));
//		user.setEnabled(true);
//		user.setAuthorities(authorityList2);
//		userDetailsRepository.save(user);
//
//		User user2=new User();
//		user2.setUserName("user");
//		user2.setPassword(passwordEncoder.encode("user"));
//		user2.setEnabled(true);
//		user2.setAuthorities(authorityList);
//		userDetailsRepository.save(user2);
//
//		User user3=new User();
//		user3.setUserName("axiomatic");
//		user3.setPassword(passwordEncoder.encode("axiomatic"));
//		user3.setEnabled(true);
//		user3.setAuthorities(authorityList3);
//		userDetailsRepository.save(user3);
//
//		User user4=new User();
//		user4.setUserName("employee");
//		user4.setPassword(passwordEncoder.encode("employee"));
//		user4.setEnabled(true);
//		user4.setAuthorities(authorityList4);
//		userDetailsRepository.save(user4);
//	}
//
//
//	private Authority createAuthority(String roleCode,String roleDescription) {
//		Authority authority=new Authority();
//		authority.setRoleCode(roleCode);
//		authority.setRoleDescription(roleDescription);
//		authorityRepository.save(authority);
//		return authority;
//	}
}
