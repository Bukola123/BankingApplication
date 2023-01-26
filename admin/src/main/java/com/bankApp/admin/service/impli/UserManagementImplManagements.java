//package com.bankApp.admin.service.impli;
//
//import com.bankApp.admin.dto.request.UserRequest;
//import com.bankApp.admin.model.Account;
//import com.bankApp.admin.model.User;
//import com.bankApp.admin.repository.UserRepository;
//import com.bankApp.admin.service.UserManagementService;
//import com.bankApp.admin.utils.Response;
//import com.bankApp.admin.utils.Utils;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalTime;
//import java.util.List;
//
//
//@Service
//@Slf4j
//public class UserManagementImplManagements implements UserManagementService {
//
//    @Autowired
//    UserRepository userRepository;
//
//
//
//
//    public Response createUser(UserRequest userRequest) {
//        User user = new User();
//        Response response = new Response();
//
//        ModelMapper modelMapper = new ModelMapper();
//
//        user = modelMapper.map(userRequest,User.class);
//
//        user.setCreateDate(LocalTime.now());
//
//        Account account = new Account();
//        account.setAccountNo("00"+ Utils.generateRandomNo(8));
//        account.setAccountType(userRequest.getAccountType());
//        account.setCreateDate(LocalTime.now());
//        user.setAccount(account);
//
//        log.info("User {} ", user);
//        userRepository.save(user);
//        Long userId= user.getUserId();
//
//        log.info("User {}", userId);
//
//        if (userId != null){
//            response.setResponseCode("000");
//            response.setResponseMessage("Successful ");
//            response.setStatus(HttpStatus.OK);
//
//        }else{
//            response.setResponseCode("99");
//            response.setResponseMessage("Unsuccessful ");
//            response.setStatus(HttpStatus.OK);
//        }
//        return response;
//    }
//
//    @Override
//    public Response updateUser(UserRequest userRequest) {
//
//        log.info("Update user details ");
//        User user = new User();
//        Response response = new Response();
//
//        ModelMapper modelMapper = new ModelMapper();
//
//        user = modelMapper.map(userRequest,User.class);
//
//        //Check if user on db
//        log.info("Email {}", userRequest.getEmail());
//        User user1 = userRepository.findByEmail(userRequest.getEmail());
//        user.setUpdateDate(LocalTime.now());
//
//        log.info("User 00 {}", user1);
//        log.info("User {}", user);
//        userRepository.save(user);
////        userRepository.update(user);
//        Long userId= user.getUserId();
//
//        log.info("User {}", userId);
//
//        if (userId != null){
//            response.setResponseCode("000");
//            response.setResponseMessage("Successful ");
//            response.setStatus(HttpStatus.OK);
//
//        }else{
//            response.setResponseCode("99");
//            response.setResponseMessage("Unsuccessful ");
//            response.setStatus(HttpStatus.OK);
//        }
//        return response;
//    }
//
//
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//
//
//    public User findByAccount(Account account){
//        User user = userRepository.findByAccount(account.getAccountNo());
//        return user;
//    }
//
//    public User findByEmail(UserRequest userRequest){
//        User user = new User();
////        return userRepository.findByEmail(email);
//        log.info("Email {}", userRequest.getEmail());
//        user = userRepository.findByEmail(userRequest.getEmail());
//        log.info("User here {}", user);
//        return user ;
//    }
//}
