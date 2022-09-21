package com.user.response;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateUsersSuccessResponse implements OutgoingMessage{
	
	private BigInteger updatedRowCount;
	private String updatedName;

}
