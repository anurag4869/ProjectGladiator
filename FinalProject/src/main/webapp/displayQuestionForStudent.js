$(function(){
		var list;
		var count=1;
		var subjectId;
		var testId;
		var counter=0;
		$("#allSubjects").on("click",".approve-btn",function(evt){
			evt.preventDefault();
			
			subjectId = $(this).attr("id");
			alert(subjectId);
			// var sid = $("#1").val();
						
			var subjectObj={
					subjectId:subjectId
			}
			$("#allSubjects").hide();
			
			// alert(subjectObj);
			
			
		    $.ajax({
				url:'displayQuestionsUsingDto.lti',
				method:'POST',
				data:JSON.stringify(subjectObj),
				contentType:'application/json',
				success:function(response){
					list=response;				
				}
		    })
		    
		    var buttonStart=$('<button type="submit">Start</button>');
			buttonStart.appendTo("#btnClickStart");
			

	    })
				
	    $("#btnClickStart").on("click","",function(evt){
	    	evt.preventDefault();
	    	if(count++==1){
	    	var buttonNext=$('<button type="submit">Next</button>');
			buttonNext.appendTo("#btnClickNext");
		
			$("#btnClickStart").hide();
			
			}
	    	
	    	///////////////// To add SubjectId and StudentId in TableTest////////////////
	    	
	    
	    	//alert(test);
	    	var tableTestObj={
	    			studentId:1,
	    			subjectId:subjectId
	    	}
	    	//alert("SubjectId"+tableTestObj.subjectId);
	    	$.ajax({
	    		url:'addDataToTestTable.lti',
	    		method:'POST',
				data:JSON.stringify(tableTestObj),
				contentType:'application/json',
				success:function(response){
					alert("done");
					testId=JSON.stringify(response.testId);
					alert(testId);
					
				}
	    		
	    		
	    	}) 	
	    	
	    	
	    	$("#divQuestion").empty();
			$("#divQuestion").append(list[counter].question);
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" value="CHOICE1" name="choice">'+list[counter].choiceOne+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" value="CHOICE2"  name="choice">'+list[counter].choiceTwo+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" value="CHOICE3" name="choice">'+list[counter].choiceThree+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" value="CHOICE4" name="choice">'+list[counter].choiceFour+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append("<hr>");
	    	

	    	
	    	
			var maxQuestions=2;
			var choiceSelected;
			$("#btnClickNext").on("click","",function(evt){
				evt.preventDefault();
				 choiceSelected = $("input[type='radio'][name='choice']:checked").val();
				 alert("ChoiceSelected "+choiceSelected);
				if(counter>maxQuestions){ 
					$("#btnClickNext").hide();
					$("#btnSubmit").append('<button type="submit">Submit</button>')
					alert("Submit");
					return;
					}
				
				/////////////// Add data to TableTestDetails///////////////////

				var testDetailsObj={
						questionId:list[counter].questionId,
						testId:testId,
						userResponse:choiceSelected
				}
			
				alert("questionId"+list[counter].questionId);
				alert("testId"+testId);
				alert("UR"+choiceSelected);
				counter++;
		$.ajax({
					url:'addDataToTestDetailsTable.lti',
		    		method:'POST',
					data:JSON.stringify(testDetailsObj),
					contentType:'application/json',
					
				})
				
					/////////////// Add data to TableTestDetails///////////////////

				
				$("#divQuestion").empty();
				$("#divQuestion").append(list[counter].question);
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio" value="CHOICE1" name="choice">'+list[counter].choiceOne+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio" value="CHOICE2" name="choice">'+list[counter].choiceTwo+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio" value="CHOICE3" name="choice">'+list[counter].choiceThree+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio"  value="CHOICE4" name="choice">'+list[counter].choiceFour+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append("<hr>");
			
			
	    	
	    })
		
		})
})