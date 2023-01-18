package com.bankApp.authentication.service.impli;

import com.bankApp.authentication.dto.request.CreateUserRequest;
import com.bankApp.authentication.model.Account;
import com.bankApp.authentication.model.User;
import com.bankApp.authentication.repository.UserRepository;
import com.bankApp.authentication.service.CreateUserService;
import com.bankApp.authentication.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateUserServiceImple implements CreateUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Response createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        Response response = new Response();

        ModelMapper modelMapper = new ModelMapper();

        user = modelMapper.map(createUserRequest,User.class);
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
}
