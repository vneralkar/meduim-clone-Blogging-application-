package com.myprojects.blogging.payloads;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	@NotEmpty
	private String name;
	@Email(message = "Email address is not valid")
	private String email;
	@NotEmpty
	@Size(min = 2, max= 10, message = "It should not be Empty")
	private String password;
	@NotNull(message = "It should not be Empty")
	private String about;
	

}
