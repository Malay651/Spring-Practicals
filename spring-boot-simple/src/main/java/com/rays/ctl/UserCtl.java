package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

import com.rays.form.UserForm;
import com.rays.service.RoleService;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl {

	@Autowired
	UserService service;
	
	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {
		
		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) {
			return res;
		}
		
		UserDTO dto = (UserDTO) form.getDto();
		
	
	   if (dto.getId() != null && dto.getId() > 0) {
			service.update(dto);
			res.addData(dto.getId());
			res.addMessage("Data Updated Successfully..!!");
			res.setSuccess(true);
		} else {
			long pk = service.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
			res.setSuccess(true);
		}
		return res;
	
	}

	@PostMapping("update")
	public ORSResponse update(@RequestBody @Valid UserForm form, BindingResult bindingResult) {
		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

       UserDTO dto =(UserDTO)form.getDto();

		service.update(dto);

		res.setSuccess(true);
		res.addMessage("role update successfully");
		res.addData(dto);

		return res;
	}

	
	@PostMapping("delete/{id}")
	public ORSResponse delete(@PathVariable long id) {
		ORSResponse res = new ORSResponse();
		service.delete(id);
		res.addMessage("deleted successfully");
		res.setSuccess(true);
		
		return res;
	}
	
    @GetMapping("get/{id}")
    public ORSResponse get(@PathVariable long id) {
    	ORSResponse res = new ORSResponse();
    	UserDTO dto =service.findById(id);
    
    if (dto != null) {
    	res.setSuccess(true);
    }
       res.addData(dto);
       return res;
       
   }
   
    @GetMapping("search/{pageNo}")
    public ORSResponse search(@RequestBody UserForm form , @PathVariable int pageNo) {
    	
    	ORSResponse res = new ORSResponse();
    	
    	UserDTO dto  = (UserDTO)form.getDto();
    	
    	
    	List<UserDTO> list = service.search(dto , pageNo, 5);
    	
    	if (list.size() == 0) {
			res.addMessage("Result not found...!!!");
		} else {
			res.setSuccess(true);
			res.addData(list);
		}
		return res;

	}
    	
    	
    	
    }
	
	
	
	
