package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.TestTableDataDTO;
import com.lti.entity.TableTest;
import com.lti.service.TestServiceImpl;

@RestController
public class TestController {
	@Autowired
	private TestServiceImpl testService;
	
	@PostMapping("/addDataToTestTable.lti")
	public TableTest addDataToTestTable(@RequestBody TestTableDataDTO testData) {
		TableTest toFetchTestId=testService.addToTestTable(testData.getStudentId(),testData.getSubjectId());	
		return toFetchTestId;
		
	}

}
