//package com.backend.taskmanagement.contoller;
//
//import com.backend.taskmanagement.dto.AuthenticationRequest;
//import com.backend.taskmanagement.dto.SignupRequest;
//import com.backend.taskmanagement.dto.UserDto;
//import com.backend.taskmanagement.entity.*;
//import com.backend.taskmanagement.repository.UserRepository;
//import com.backend.taskmanagement.services.auth.AuthService;
//import com.backend.taskmanagement.utils.JwtUtil;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.swing.*;
//import java.io.IOException;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final UserDetailsService userDetailsService;
//
//    private final UserRepository userRepository;
//
//    private final JwtUtil jwtUtil;
//
//    public static final String TOKEN_PRIFIX = "Bearer ";
//    public static final String HEADER_STRING = "Authorization";
//
//    private final AuthService authService;
//
//    @PutMapping("/authentication")
//    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException, JSONException {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        }
//        catch (BadCredentialsException e) {
//            throw new BadCredentialsException("incorrect username or password");
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
//
//        if (optionalUser.isPresent()) {
//            response.getWriter().write(new JSONObject()
//                    .put("userId", optionalUser.get().getId())
//                    .put("role", optionalUser.get().getRole())
//                    .toString());
//
//            response.addHeader(HEADER_STRING, TOKEN_PRIFIX + jwt);
//        }
//
//    }
//    @PutMapping("/sin-up")
//    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
//        if (authService.hasUserWithEmail(signupRequest.getEmail())){
//            return new ResponseEntity<>("user already exist", HttpStatus.NOT_ACCEPTABLE);
//        }
//        UserDto userDto = authService.createUser(signupRequest);
//        return new ResponseEntity<>(userDto, HttpStatus.OK);
//
//    }
//}
