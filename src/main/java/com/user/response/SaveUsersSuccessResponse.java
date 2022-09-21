package com.user.response;

import lombok.*;

import java.math.BigInteger;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaveUsersSuccessResponse implements OutgoingMessage{
    private BigInteger id;
}
