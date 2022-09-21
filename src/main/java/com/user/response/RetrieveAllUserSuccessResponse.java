package com.user.response;


import com.user.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RetrieveAllUserSuccessResponse implements OutgoingMessage{
	
	private List<UserDto> users;

}
