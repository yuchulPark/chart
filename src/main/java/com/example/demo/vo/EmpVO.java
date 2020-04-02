package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class EmpVO {
	private int eno;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	private int mgr;
	private Date hiredate;
	private int deno;
	private String email;
	private String jumin;
}
