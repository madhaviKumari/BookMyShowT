package co.move.in.test.BookMyShow.controller;


import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.move.in.test.BookMyShow.dto.ClientDTO;
import co.move.in.test.BookMyShow.dto.JwtResponse;
import co.move.in.test.BookMyShow.dto.LoginRequest;
import co.move.in.test.BookMyShow.model.ERole;
import co.move.in.test.BookMyShow.model.Role;
import co.move.in.test.BookMyShow.model.User;
import co.move.in.test.BookMyShow.repository.RoleRepository;
import co.move.in.test.BookMyShow.security.jwt.JwtUtils;
import co.move.in.test.BookMyShow.services.UserDetailsImpl;
import co.move.in.test.BookMyShow.services.UserService;
import co.move.in.test.BookMyShow.util.SystemCodes;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

import co.move.in.test.BookMyShow.exceptions.BMSException;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController extends ParentController{
	
	@Autowired
	private UserService service;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("client/signup")
	public ResponseEntity<?> registerClient(@Validated @RequestBody ClientDTO dto) {
			System.out.println("Valid request");
			User user = new User();
			user.setCreatedBy(SystemCodes.sysGen);
			user.setCreatedDate(LocalDateTime.now().toString());
			user.setDescription(SystemCodes.sysGenDec);
			user.setEmail(dto.email);
			user.setFullName(dto.fullName);
			user.setId(dto.getEmail());
			user.setPassword(encoder.encode(dto.getPassword()));
			user.setPhone(dto.phone);
			Set<Role> roles = new HashSet<>();
			Role role = roleRepository.findByName(ERole.ROLE_CLIENT).orElseThrow(() -> new BMSException("System error"));
			roles.add(role);
			user.setRoles(roles);
			user.setUsername(dto.email);
			service.addUser(user);
			return getResponse("User registered successfully");
	}
	
	@PostMapping("admin/signup")
	public ResponseEntity<?> registerAdmin(@Validated @RequestBody ClientDTO dto) {
			System.out.println("Valid request");
			User user = new User();
			user.setCreatedBy(SystemCodes.sysGen);
			user.setCreatedDate(LocalDateTime.now().toString());
			user.setDescription(SystemCodes.sysGenDec);
			user.setEmail(dto.email);
			user.setFullName(dto.fullName);
			user.setId(dto.getEmail());
			user.setPassword(encoder.encode(dto.getPassword()));
			user.setPhone(dto.phone);
			Set<Role> roles = new HashSet<>();
			Role role = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new BMSException("System error"));
			roles.add(role);
			user.setRoles(roles);
			user.setUsername(dto.email);
			service.addUser(user);
			return getResponse("User registered successfully");
	}
	
	
	@PostMapping("client/signin")
	public ResponseEntity<?> loginClient(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		System.out.println(roles);
		boolean isAdmin=false;
		for(String role:roles) {
			if(role.equals(ERole.ROLE_CLIENT.name()) || role.equals(ERole.ROLE_ADMIN.name())) {
				isAdmin=true;
				break;
			}
		}
		if(!isAdmin) {
			return this.createMessageResponse("You are not authorized to login as client.", HttpStatus.FORBIDDEN);
		}
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
		
	}
	
	private ResponseEntity<?> createMessageResponse(String message,HttpStatus status){
		Map<String, String> map = new HashMap<String,String>();
		map.put("msg", message);
		return new ResponseEntity<>(map,status);	
	}
	
	@GetMapping("test/server")
	public ResponseEntity<?> getTestFeed(){
		List<Role> roles = SystemCodes.getInitialSystemRoles();
		roleRepository.saveAll(roles);
		return ResponseEntity.ok("Response ok");
	}

}
