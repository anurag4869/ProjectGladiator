$(function(){
		var list;
		var count=1;
		var test;
		$("#allSubjects").on("click",".approve-btn",function(evt){
			evt.preventDefault();
			// var btnText=$(this).text();
			// alert(btnText);
			 test = $(this).attr("id");
			alert(test);
			// var sid = $("#1").val();
						
			var subjectObj={
					subjectId:test
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
	    			subjectId:test
	    	}
	    	//alert("SubjectId"+tableTestObj.subjectId);
	    	$.ajax({
	    		url:'addDataToTestTable.lti',
	    		method:'POST',
				data:JSON.stringify(tableTestObj),
				contentType:'application/json',
				success:function(response){
					alert("done");
				}
	    		
	    		
	    	})
	    	
	    	
	    	
	    	$("#divQuestion").empty();
			$("#divQuestion").append(list[0].question);
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" name="choice">'+list[0].choiceOne+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" name="choice">'+list[0].choiceTwo+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" name="choice">'+list[0].choiceThree+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append($('<input type="radio" name="choice">'+list[0].choiceFour+'</input>'));
			$("#divQuestion").append("<br>");
			$("#divQuestion").append("<hr>");
	    	
	    	
	    	var counter = 0;
			var maxQuestions=1;
			$("#btnClickNext").on("click","",function(evt){
				evt.preventDefault();
				counter++;
				if(counter>maxQuestions) return;
				$("#divQuestion").empty();
				$("#divQuestion").append(list[counter].question);
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio" name="choice">'+list[counter].choiceOne+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio" name="choice">'+list[counter].choiceTwo+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio" name="choice">'+list[counter].choiceThree+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append($('<input type="radio" name="choice">'+list[counter].choiceFour+'</input>'));
				$("#divQuestion").append("<br>");
				$("#divQuestion").append("<hr>");
	    	
	    })
		
		})
})