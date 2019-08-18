package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddUserResponsesDTO;
import com.lti.entity.TableUserResult;
import com.lti.service.ScoreCalculatorService;
import com.lti.service.TestDetailsService;

@RestController
public class TestDetailsController {
	@Autowired
	TestDetailsService testDetailsService;
	
	@Autowired
	ScoreCalculatorService scoreCalculateService;
	
	@PostMapping("/addDataToTestDetailsTable.lti")
	public TableUserResult addToTableTestDetails(@RequestBody AddUserResponsesDTO testDetailsData) {
		if(!testDetailsData.isFinish()) {
			testDetailsService.addToTableDetailsService(testDetailsData.getTestId(),
					testDetailsData.getQuestionId(),testDetailsData.getUserResponse());
		
			return null;
		}
		else if(testDetailsData.isFinish()) {
			System.out.println("Test Finished");
			return scoreCalculateService.calculateScore(testDetailsData.getTestId());
			
		}
		return null;
	}

}
