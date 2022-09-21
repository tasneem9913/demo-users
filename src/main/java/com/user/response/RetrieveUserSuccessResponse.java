package com.user.response;


import com.user.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RetrieveUserSuccessResponse implements OutgoingMessage{
	
	private UserDto user;

}
