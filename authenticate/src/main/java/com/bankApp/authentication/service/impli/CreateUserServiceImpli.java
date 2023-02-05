package com.bankApp.authentication.service.impli;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.dto.request.LoginUserRequest;
import com.bankApp.authentication.dto.request.MobileAppRegRequest;
import com.bankApp.authentication.model.*;
import com.bankApp.authentication.repository.MobileBankingRepository;
import com.bankApp.authentication.repository.UserRepository;
import com.bankApp.authentication.service.CreateUserService;
import com.bankApp.authentication.utils.Response;
import com.bankApp.authentication.utils.Utils;
import com.bankApp.authentication.utils.exemptions.GeneralExceptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static com.bankApp.authentication.utils.Utils.generateRandomNo;

@Service
@Slf4j
public class CreateUserServiceImpli implements CreateUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MobileBankingRepository mobileBankingRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Utils utils;




    public Response createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        Response response = new Response();

        //check if user already exist

        if( utils.findByEmail(createUserRequest) != null){
            response.setResponseCode("99");
            response.setResponseMessage("User already registered");
            return  response;
        }

//        ModelMapper modelMapper = new ModelMapper();
//        user = modelMapper.map(createUserRequest,User.class);

        user.setFirstName(createUserRequest.getFirstName());
        user.setMiddleName(createUserRequest.getMiddleName());
        user.setLastName(createUserRequest.getLastName());
        user.setDateOfBirth(createUserRequest.getDateOfBirth());
        user.setEmail(createUserRequest.getEmail());
        user.setPhone(createUserRequest.getPhone());
        user.setAddress(createUserRequest.getAddress());
        user.setPhone(createUserRequest.getPhone());
        user.setBvn(createUserRequest.getBvn());


        user.setCreateDate(LocalTime.now());

        Account account = new Account();
        account.setAccountNo("00"+generateRandomNo(8));
        account.setAccountType(createUserRequest.getAccountType());
        account.setCreateDate(LocalTime.now());

        Document document = new Document();
//        document.setUserId();
        document.setPassport(createUserRequest.getPassport());

        Utility utility = new Utility();
        utility.setAccountNo(account.getAccountNo());
        utility.setUtilityType(createUserRequest.getUtilityType());
        utility.setUtilityAddress(createUserRequest.getUtilityAddress());
        utility.setUtilityStatus("Pending");

        //cloudinary call
        utility.setCloudinary(createUserRequest.getUtilityImage());


        IdDetails idDetails = new IdDetails();
        idDetails.setIdType(createUserRequest.getIdType());
        idDetails.setIdNumber(createUserRequest.getIdNumber());
        idDetails.setIDLocation(createUserRequest.getIdLocation());
        idDetails.setIdStatus("Pending");
        idDetails.setCloudinary(createUserRequest.getIdImage());
        idDetails.setAccountNo(account.getAccountNo());
        idDetails.setIdSigned(createUserRequest.getIdSigned());

        document.setUtility(utility);
        document.setIdCard(idDetails);
        document.setAccountNo(account.getAccountNo());
        account.setDocument(document);
        user.setAccount(account);



        log.info("User {} ", user);
        userRepository.save(user);
        Long userId= user.getUserId();

        log.info("User {}", userId);

        if (userId != null){
            response.setResponseCode("000");
            response.setResponseMessage("Successful ");

            //Send notification to user

        }else{
            response.setResponseCode("99");
            response.setResponseMessage("Unsuccessful ");
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

        }else{
            response.setResponseCode("99");
            response.setResponseMessage("Unsuccessful ");
        }
        return response;
    }




    public Response mobileAppReg(MobileAppRegRequest mobileAppRegRequest){
        log.info("Request {}", mobileAppRegRequest);
        Response response = new Response();
        //Check if user exist and return user table
        Account account = new Account();
        account.setAccountNo(mobileAppRegRequest.getAccountNo());
        User user = findByAccount(account);
        if (user.getUserId() == null){
            response.setResponseCode("99");
            response.setResponseMessage("User not found");
        }
        //Reg user
        MobileBankingDetails mobileBankingDetails = new MobileBankingDetails();
        mobileBankingDetails.setUserId(user.getUserId());
        mobileBankingDetails.setUsername(user.getEmail());


        mobileBankingDetails.setPassword(passwordEncoder.encode(mobileAppRegRequest.getPassword()));
        mobileBankingDetails = mobileBankingRepository.save(mobileBankingDetails);
        log.info("Response {}", mobileBankingDetails);
        if(mobileBankingDetails.getId() == null){
            response.setResponseCode("99");
            response.setResponseMessage("Unable to register profile");
        }
        response.setResponseCode("00");
        response.setResponseMessage("Profile successfully  created");
        return response;

    }



    @Override
    public Response loginUser(LoginUserRequest request){
        Response response = new Response();
        log.info("Request {}", request);
        //Validate userName
        MobileBankingDetails mobileBankingDetails = utils.validateUserName(request);
        if(mobileBankingDetails == null){
           response.setResponseCode("84");
           response.setResponseMessage("Invalid user");
            return response;
        }
        //Validate password
        Boolean result = passwordEncoder.matches(request.getPassword(), mobileBankingDetails.getPassword());
        log.info("Password validation {}", result);
        if (result == true){
            response.setResponseCode("00");
            response.setResponseMessage("User validated");
        }else{
        response.setResponseCode("84");
        response.setResponseMessage("Invalid user");
        }
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
        log.info("User details {}", user);
//        if(user == null){
//            throw new GeneralExceptions("99","Invalid account provided",HttpStatus.BAD_REQUEST);
//        }
        return user;
    }


}
