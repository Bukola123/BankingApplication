package com.bankApp.admin.accountManagement.service.impli;

import com.bankApp.admin.accountManagement.model.Account;
import com.bankApp.admin.accountManagement.model.User;
import com.bankApp.admin.accountManagement.repository.UserRepository;
import com.bankApp.admin.accountManagement.service.UserManagementService;
import com.bankApp.admin.accountManagement.dto.request.UserRequest;
import com.bankApp.admin.utils.Response;
import com.bankApp.admin.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;



@Service
@Slf4j
public class UserManagementServiceImp implements UserManagementService {

    @Autowired
    UserRepository userRepository;




    public Response createUser(UserRequest userRequest) {
        User user = new User();
        Response response = new Response();

        ModelMapper modelMapper = new ModelMapper();

        user = modelMapper.map(userRequest,User.class);

        user.setCreateDate(LocalTime.now());

        Account account = new Account();
        account.setAccountNo("00"+ Utils.generateRandomNo(8));
        account.setAccountType(userRequest.getAccountType());
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
    public Response updateUser(UserRequest userRequest) {

        log.info("Update user details ");
        User user = new User();
        Response response = new Response();

        ModelMapper modelMapper = new ModelMapper();

        user = modelMapper.map(userRequest,User.class);

        //Check if user on db
        log.info("Email {}", userRequest.getEmail());
        User user1 = userRepository.findByEmail(userRequest.getEmail());
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
        log.info("Account request {}", account);
        Account accountDetails= userRepository.findByAccountNo(account.getAccountNo());
        log.info("Account no {}", accountDetails);
        return  findUserByAccountId(accountDetails.getId());
    }

    public User findUserByAccountId(Long account_id){
        User user= userRepository.findByAccount_Id(account_id);
        return user;
    }

    public User findByEmail(UserRequest userRequest){
        User user = new User();
        log.info("Email {}", userRequest.getEmail());
        user = userRepository.findByEmail(userRequest.getEmail());
        log.info("User here {}", user);
        return user ;
    }
}
