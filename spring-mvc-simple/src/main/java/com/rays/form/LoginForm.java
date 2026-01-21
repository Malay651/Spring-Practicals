package com.rays.form;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty(message ="email is required" )
}
