package com.iu.sb5.member;

import lombok.Data;

@Data
public class MemberVO {
	private long num;
	private String id;
	private String pw;
	private String name;
	private long age;
	private String email;
}
