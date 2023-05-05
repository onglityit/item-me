package com.darren.mongorest.model.response;

import lombok.*;

@Data @AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MessageResponse {
    private String message;
}
