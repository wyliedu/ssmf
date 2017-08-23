package com.wylie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wylie.common.dto.CommonData;
import com.wylie.entity.UserEntity;
import com.wylie.exception.NotFoundException;
import com.wylie.mapper.UserMapper;
import com.wylie.models.InChangePassword;


@RestController
@RequestMapping("/api")
public class UserController extends BaseController{
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper user1Mapper;
	
	
	@RequestMapping(value ="/getUsers", method = RequestMethod.GET)
	public ResponseEntity<CommonData<Object>> getUsers(@CookieValue(required = false) final String locale) {
		PageHelper.startPage(1, 1);  
		List<UserEntity> users=user1Mapper.getAll();
		PageInfo pageInfo = new PageInfo(users);  
		logger.debug("locale================================="+locale);
		return ResponseEntity.ok(getSuccessOutPojo(users));
	}
	
	
    @RequestMapping(value ="/getUser", method = RequestMethod.POST)
    public ResponseEntity<CommonData<Object>> getUser(@Validated @RequestBody InChangePassword User) {
    	List<UserEntity> users=user1Mapper.getAll();
		return ResponseEntity.ok(getSuccessOutPojo(users));
    }

    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public void save(@RequestBody UserEntity user) {
        int i = user1Mapper.insert(user);
        throw new NotFoundException("9000", "eee");
    }
    

    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }
    
}