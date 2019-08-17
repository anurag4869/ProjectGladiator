package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddUserResponsesDTO;
import com.lti.service.TestDetailsService;

@RestController
public class TestDetailsController {
	@Autowired
	TestDetailsService testDetailsService;
	
	@PostMapping("/addDataToTestDetailsTable.lti")
	public void addToTableTestDetails(@RequestBody AddUserResponsesDTO testDetailsData) {
		testDetailsService.addToTableDetailsService(testDetailsData.getTestId(),
				testDetailsData.getQuestionId(),testDetailsData.getUserResponse());
		/*if(testDetailsData.isFinish()) {
			
		}*/
	}

}
