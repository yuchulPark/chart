package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MemberVO {
	private String id;
	private String name;
	private String tel;
	private int age;
	private String pwd;
}
