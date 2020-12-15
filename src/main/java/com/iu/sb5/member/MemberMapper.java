package com.iu.sb5.member;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface MemberMapper {

	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
}
