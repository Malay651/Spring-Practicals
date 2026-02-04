package com.rays.form;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class LoginForm extends BaseForm {

	private String loginId;
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String login) {
		loginId = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setLoginId(loginId);
		dto.setPassword(password);
		return dto;
	}
}
