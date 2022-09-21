package com.user.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeleteUserSuccessResponse implements OutgoingMessage{
	
	private Boolean isDeleted;

}
