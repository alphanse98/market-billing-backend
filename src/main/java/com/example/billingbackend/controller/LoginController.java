package com.example.billingbackend.controller;
import com.example.billingbackend.dto.AccountDto;
import com.example.billingbackend.dto.LoginDto;
import com.example.billingbackend.entity.AccountEntity;
import com.example.billingbackend.entity.LoginEntity;
import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import com.example.billingbackend.security.JwtUtil;
import com.example.billingbackend.service.AccountService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

     JwtUtil JwtUtil;
     AuthenticationManager authenticationManager;
     UserService UserService;
     AccountService AccountService;
     UsersRepository usersRepository;

    @GetMapping("api/login")
    public ResponseEntity<LoginDto> jwt (@RequestBody LoginEntity requestData){

        String userName = requestData.getUsername();
        String password = requestData.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);

        authenticationManager.authenticate(token);

        String jwtToken = JwtUtil.generateJwt(userName); // generate jwtToken

        UserEntity userDetails = usersRepository.findByUsername(userName).get(); // find username from DB

        // jetToken and userDetails  to LoginResponse
        LoginDto LoginResponse = new LoginDto();

        LoginResponse.setAuthToken(jwtToken);
        LoginResponse.setBusinessID(userDetails.getBusinessID());
        LoginResponse.setUsername(userDetails.getUsername());
        LoginResponse.setRole(userDetails.getRole());

        return ResponseEntity.ok(LoginResponse);
    }

    @PostMapping("api/register")
    public  ResponseEntity<String>  account (@RequestBody AccountDto requestData){

        System.out.println(" <<<<<<<<<<<<<<< register >>>>>>" +  requestData);

        // Convert AccountDto to AccountEntity
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(requestData.getName());
        accountEntity.setBusinessName(requestData.getBusinessName());
        accountEntity.setMobile(requestData.getMobile());
        accountEntity.setSecMobile(requestData.getSecMobile());
        accountEntity.setEmail(requestData.getEmail());
        accountEntity.setAddress(requestData.getAddress());
        accountEntity.setActive(requestData.isActive());

        AccountService.accountRegister(accountEntity);
        AccountEntity accountData =  AccountService.findByMobile(requestData.getMobile());
        System.out.println(" <<<<<<<<<<<<<<< mobile >>>>>>" +  accountData);

        // Convert AccountDto to UserEntity
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(requestData.getUsername());
        userEntity.setPassword(requestData.getPassword());
        userEntity.setRole(requestData.getPassword());
        userEntity.setBusinessID(accountData.getBusinessID());

        // Pass the entities to the respective service methods

        UserService.userRegister(userEntity);

        return ResponseEntity.ok("Register successfully");
    }
}