package com.mcanics.user_app.data.payloads.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
public class MechanicRequest {


	@NotBlank
	@NotNull
	private String firstName;
	@NotBlank
	@NotNull
    private String lastName;
	@NotBlank
	@NotNull
    private String mobileNumber;
	@Email(message="please enter the valid mail id")
    private String email;
    @NotBlank
	@NotNull
    private String password;
    @NotBlank
	@NotNull(message="adhar should not be null")
    private String adharNumber;
	
	
	
}
