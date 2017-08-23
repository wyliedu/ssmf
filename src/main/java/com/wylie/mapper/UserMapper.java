package com.wylie.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Options;

import com.wylie.entity.UserEntity;



public interface UserMapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	Integer insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}