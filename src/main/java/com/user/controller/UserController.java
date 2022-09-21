package com.user.controller;
import com.user.dto.UserDto;

import com.user.response.*;
import com.user.response.Error;
import com.user.service.UserService;
import com.user.Enum.LogStatus;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {


    @Autowired
    UserService userService;

    Error error = new Error("Failed to add", HttpStatus.INTERNAL_SERVER_ERROR, "FAILURE");

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutgoingMessage> saveUser(  @RequestBody UserDto users) {

        try {
            log.info("event={}, action={}, reason={}, status={}, data={}", "Users","SaveUser","To Save user", LogStatus.STARTED, users);
            BigInteger saveUsersResult = userService.saveUser( users);

            if (saveUsersResult.equals(0)) {
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

            } else {
                SaveUsersSuccessResponse saveusersSuccessResponse =
                        new SaveUsersSuccessResponse(saveUsersResult);
                return (new ResponseEntity<>(saveusersSuccessResponse, HttpStatus.OK));
            }
        }catch (Exception e)
        {

            log.error("event={}, action={}, reason={}, status={}","Users","SaveUser",e.getMessage(),LogStatus.ERROR);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/{id}/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutgoingMessage> updateUser(@RequestBody UserDto users, @PathVariable Integer id) {

        try {
            log.info("event={}, action={}, reason={}, status={}","Users","UpdateUser","To Update User", LogStatus.STARTED);
            BigInteger updateUsersResult = userService.updateUser(id, users);

            if (updateUsersResult.equals(0)) {
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

            } else {
                UpdateUsersSuccessResponse updateUsersSuccessResponse =
                        new UpdateUsersSuccessResponse(updateUsersResult,users.getName());

                return (new ResponseEntity<>(updateUsersSuccessResponse, HttpStatus.OK));
            }
        }catch (Exception e)
        {
            log.error("event={}, action={}, reason={}, status={}","Users","UpdateUser",e.getMessage(),LogStatus.ERROR);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/{id}/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutgoingMessage> retrieveUser(@PathVariable Integer id) {

        try {
            log.info("event={}, action={}, reason={}, status={}", "Users", "RetrieveSpecificUser", "To Retrieve Specific User", LogStatus.STARTED);
            UserDto users = userService.retrieveUser(id);

            if (users == null) {
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

            } else {
                RetrieveUserSuccessResponse retrieveUserSuccessResponse = new RetrieveUserSuccessResponse(users);
                return (new ResponseEntity<>(retrieveUserSuccessResponse, HttpStatus.OK));
            }
        }catch (Exception e)
        {
            log.error("event={}, action={}, reason={}, status={}","Users","RetrieveSpecificUser",e.getMessage(),LogStatus.ERROR);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OutgoingMessage> retrieveAllUsers(@AuthenticationPrincipal OidcUser user) {

        try {
            log.info("event={}, action={}, reason={}, status={}", "Users", "RetrieveAllUsers", "To Retrieve all Users", LogStatus.STARTED);
            List<UserDto> users = userService.retrieveUsers();

            if (users== null) {
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

            } else {
                RetrieveAllUserSuccessResponse retrieveUserSuccessResponse = new RetrieveAllUserSuccessResponse(users);

                return (new ResponseEntity<>(retrieveUserSuccessResponse, HttpStatus.OK));
            }
        }catch (Exception e)
        {
            log.error("event={}, action={}, reason={}, status={}","Users","RetrieveAllUsers",e.getMessage(),LogStatus.ERROR);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}/user", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<OutgoingMessage> deleteUser(@PathVariable  Integer id) {

        try {
            log.info("event={}, action={}, reason={}, status={}", "Users", "DeleteUser", "To Delete User", LogStatus.STARTED);
            Boolean user = userService.deleteUser(id);

            if (!user) {
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

            } else {
                DeleteUserSuccessResponse deleteGoalsSuccessResponse =
                        new DeleteUserSuccessResponse(user);

                return (new ResponseEntity<>(deleteGoalsSuccessResponse, HttpStatus.OK));
            }
        }catch (Exception e)
        {
            log.error("event={}, action={}, reason={}, status={}","Users","DeleteUser",e.getMessage(),LogStatus.ERROR);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
