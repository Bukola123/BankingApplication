package com.bankApp.authentication.service.impli;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.model.Account;
import com.bankApp.authentication.model.User;
import com.bankApp.authentication.repository.UserRepository;
import com.bankApp.authentication.service.CreateUserService;
import com.bankApp.authentication.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

import static com.bankApp.authentication.utils.Utils.generateRandomNo;

@Service
@Slf4j
public class CreateUserServiceImpli implements CreateUserService {

    @Autowired
    UserRepository userRepository;




    public Response createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        Response response = new Response();

        ModelMapper modelMapper = new ModelMapper();

        user = modelMapper.map(createUserRequest,User.class);

        user.setCreateDate(LocalTime.now());

        Account account = new Account();
        account.setAccountNo("00"+generateRandomNo(8));
        account.setAccountType(createUserRequest.getAccountType());
        account.setCreateDate(LocalTime.now());
        user.setAccount(account);

        log.info("User {} ", user);
        userRepository.save(user);
        Long userId= user.getUserId();

        log.info("User {}", userId);

        if (userId != null){
            response.setResponseCode("000");
            response.setResponseMessage("Successful ");
            response.setStatus(HttpStatus.OK);

        }else{
            response.setResponseCode("99");
            response.setResponseMessage("Unsuccessful ");
            response.setStatus(HttpStatus.OK);
        }
        return response;
    }

    @Override
    public Response updateUser(CreateUserRequest createUserRequest) {

        log.info("Update user details ");
        User user = new User();
        Response response = new Response();

        ModelMapper modelMapper = new ModelMapper();

        user = modelMapper.map(createUserRequest,User.class);

        //Check if user on db
        log.info("Email {}", createUserRequest.getEmail());
        User user1 = userRepository.findByEmail(createUserRequest.getEmail());
        user.setUpdateDate(LocalTime.now());

        log.info("User 00 {}", user1);
        log.info("User {}", user);
        userRepository.save(user);
//        userRepository.update(user);
        Long userId= user.getUserId();

        log.info("User {}", userId);

        if (userId != null){
            response.setResponseCode("000");
            response.setResponseMessage("Successful ");
            response.setStatus(HttpStatus.OK);

        }else{
            response.setResponseCode("99");
            response.setResponseMessage("Unsuccessful ");
            response.setStatus(HttpStatus.OK);
        }
        return response;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User findByAccount(Account account){
        User user = userRepository.findByAccount(account.getAccountNo());
        return user;
    }

    public User findByEmail(CreateUserRequest createUserRequest){
        User user = new User();
//        return userRepository.findByEmail(email);
        log.info("Email {}", createUserRequest.getEmail());
        user = userRepository.findByEmail(createUserRequest.getEmail());
        log.info("User here {}", user);
        return user ;
    }
}
