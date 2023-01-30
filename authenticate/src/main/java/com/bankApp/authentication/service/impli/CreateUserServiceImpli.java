package com.bankApp.authentication.service.impli;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.dto.request.LoginUserRequest;
import com.bankApp.authentication.dto.request.MobileAppRegRequest;
import com.bankApp.authentication.model.Account;
import com.bankApp.authentication.model.MobileBankingDetails;
import com.bankApp.authentication.model.User;
import com.bankApp.authentication.repository.MobileBankingRepository;
import com.bankApp.authentication.repository.UserRepository;
import com.bankApp.authentication.service.CreateUserService;
import com.bankApp.authentication.utils.Response;
import com.bankApp.authentication.utils.exemptions.GeneralExceptions;
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

    @Autowired
    MobileBankingRepository mobileBankingRepository;




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

            //Send notification to user

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

    public Response mobileAppReg(MobileAppRegRequest mobileAppRegRequest){
        log.info("Request {}", mobileAppRegRequest);
        Response response = new Response();
        //Check if user exist and return user table
        User user = findByAccount(mobileAppRegRequest.getAccount());
        if (user.getUserId() == null){
            response.setResponseCode("99");
            response.setResponseMessage("User not found");
        }
        //Reg user
        mobileAppRegRequest.getMobileBankingDetails().setUserId(user.getUserId());
        mobileAppRegRequest.getMobileBankingDetails().setEmail(user.getEmail());
        MobileBankingDetails mobileBankingDetails = mobileBankingRepository.save(mobileAppRegRequest.getMobileBankingDetails());
        log.info("Response {}", mobileBankingDetails);
        if(mobileBankingDetails.getId() == null){
            response.setResponseCode("99");
            response.setResponseCode("Unable to register profile");
        }
        response.setResponseCode("00");
        response.setResponseCode("Profile successfully created");
        return response;

    }





    public User findByAccount(Account account){
        log.info("Account request {}", account);
        Account accountDetails= userRepository.findByAccountNo(account.getAccountNo());

        if(accountDetails == null){
            throw new GeneralExceptions("99","Invalid account provided",HttpStatus.BAD_REQUEST);
        }
        log.info("Account no {}", accountDetails);
        return  findUserByAccountId(accountDetails.getId());
    }

    public User findUserByAccountId(Long account_id){
        User user = userRepository.findByAccount_Id(account_id);
        log.info("User {}", user);
        if(user == null){
            throw new GeneralExceptions("99","Invalid account provided",HttpStatus.BAD_REQUEST);
        }
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
