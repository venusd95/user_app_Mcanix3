package com.mcanics.user_app.data.payloads.response;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class MechanicMessageResponse {

    private String message;

    public MechanicMessageResponse(String message){
        this.message = message;
    }

   
}
