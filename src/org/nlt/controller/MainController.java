package org.nlt.controller;

import org.nlt.controller.services.AdminService;
import org.nlt.controller.services.QuestionnarieService;
import org.nlt.controller.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class MainController {
	@Autowired
	public AdminService adminService;
	@Autowired
	public QuestionnarieService questionnarieService;
	@Autowired
	public StudentService studentService;
}
