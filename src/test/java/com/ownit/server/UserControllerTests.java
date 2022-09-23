package com.ownit.server;


import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.user.controller.UserController;
import com.user.dto.UserDto;
import com.user.service.UserService;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Slf4j
@SpringBootTest(classes = UserController.class)
@AutoConfigureMockMvc
public class UserControllerTests {
//	@Autowired
//	MockMvc mockMvc;
//
//
//
//	@MockBean
//	UserService userService;
//
//	UserDto user1 = new UserDto("Dwight");
//	UserDto user2 = new UserDto("Angela");
//
//	@Test
//	public void getAllPolicies() throws Exception{
//				List<UserDto> users = new ArrayList<>(Arrays.asList(user1,user2));
//				Mockito.when(userService.retrieveUsers()).thenReturn(users);
//
//				log.info(String.valueOf(userService.retrieveUsers()));
//
//		 mockMvc.perform(MockMvcRequestBuilders
//				.get("/data/users"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.id", is(1)));
//
//
//
//	}

}
