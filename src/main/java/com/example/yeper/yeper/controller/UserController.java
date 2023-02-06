package com.example.yeper.yeper.controller;

import java.util.List;
import java.util.Optional;

import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.AuthRequest;
import com.example.yeper.yeper.entity.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeper.yeper.entity.Cards;
import com.example.yeper.yeper.entity.Users;
import com.example.yeper.yeper.services.UserServices;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	public AuthenticationManager authenticationManager;
	@Autowired
	public JwtService jwtService;

	@Autowired
	public UserServices user;
	@Autowired
	private UserDao userDao;

	@GetMapping(path="/test")
	public String test() {
		return "Running...";
	}


	@GetMapping(path = "/getall")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Users> getall() {
		return this.user.getall();

	}

	@GetMapping(path = "/getref/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Users> getref(@PathVariable String id) {
		return this.user.getreferals(id);

	}

	@PostMapping(path = "/add")
//	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Users add(@RequestBody Users user) {
		return this.user.adduser(user);
	}

	@PutMapping(path = "/update/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Users update(@PathVariable String id, @RequestBody Users user) {
		return this.user.update(id, user);
	}

	@DeleteMapping(path = "/delete/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public boolean delete(@PathVariable String id) {
		return this.user.delete(id);
	}

	@GetMapping(path = "/isuser/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public boolean checkuser(@PathVariable String id) {
		return this.user.delete(id);
	}

	@GetMapping(path = "/getsingle/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Users getsingle(@PathVariable String id) {
		return this.user.getsingle(id);
	}

	@GetMapping(path = "/getwalletbalance/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public long getwallet(@PathVariable String id) {
		return this.user.getwalletid(id);
	}

	@GetMapping(path = "/getcards/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Cards> getcards(@PathVariable String id) {
		return this.user.usercards(id);
	}

	@PostMapping(path = "/addcards/{id}/{id2}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Users addcards(@PathVariable String id, @PathVariable String id2) {
		return this.user.addcard(id, id2);
	}


	@PostMapping(path ="/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException{
//		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUid(), authRequest.getPassword()));
        Optional<Users> users= userDao.findById(authRequest.getUid());
		if(users.isPresent()){
			return jwtService.generateToken(authRequest.getUid());
		}else {
			throw new UsernameNotFoundException("Invalid User");
		}

	}
}
