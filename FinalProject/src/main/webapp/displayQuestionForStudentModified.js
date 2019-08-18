$(function(){
	var listOfQuestionIds;
	var subjectId;
	var testId;
	var countForQuestionList=0;
	var count=1;
	var selected;
	var maxQuestions=8;
	$("#allSubjects").on("click",".approve-btn",function(evt){
		evt.preventDefault();
		// var btnText=$(this).text();
		// alert(btnText);
		subjectId = $(this).attr("id");
		//alert(subjectId);
		// var sid = $("#1").val();
					
		var subjectObj={
				subjectId:subjectId
		}
		$("#allSubjects").hide();
		shuffleQuestionFunction();
		addToTestTableFunction();
		
		// alert(subjectObj);
	    var buttonStart=$('<input type="submit" id="btnChange" value="Start"></input>');
		buttonStart.appendTo("#btnClickStart");

    })

    
	
	/////////////////////////////// OnClick Start and Next ///////////////////////////////
    
    function shuffleQuestionFunction(){
		var subjectObj={
				subjectId:subjectId
		}
		$.ajax({
			url:'displayQuestionIdsUsingDto.lti',
			method:'POST',
			data:JSON.stringify(subjectObj),
			contentType:'application/json',
			success:function(response){
				listOfQuestionIds=response;			
				alert(JSON.stringify(listOfQuestionIds));
			}
		})
		
	}
	function addToTestTableFunction(){
		var tableTestObj={
    			studentId:1,
    			subjectId:subjectId
    	}
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
		
	}
	
	function loadQuestion(questionNo) {
		var questionIds={
				 questionId:listOfQuestionIds[questionNo]
		 };
		 $.ajax({
			 url:'getSingleQuestion.lti',
			 method:'POST',
			 data:JSON.stringify(questionIds),
			 contentType:'application/json',
			 success:function(response){
				 $("#divQuestion").empty();
				 $("#divQuestion").append(response.question);
				 $("#divQuestion").append("<br>");
				 $("#divQuestion").append($('<input type="radio" value="CHOICE1" name="choice">'+response.choiceOne+'</input>'));
				 $("#divQuestion").append("<br>");
				 $("#divQuestion").append($('<input type="radio" value="CHOICE2"  name="choice">'+response.choiceTwo+'</input>'));
				 $("#divQuestion").append("<br>");
				 $("#divQuestion").append($('<input type="radio" value="CHOICE3" name="choice">'+response.choiceThree+'</input>'));
				 $("#divQuestion").append("<br>");
				 $("#divQuestion").append($('<input type="radio" value="CHOICE4" name="choice">'+response.choiceFour+'</input>'));
				 $("#divQuestion").append("<br>");
				 $("#divQuestion").append("<hr>");
			
			 }
	})
	}
    
	$('#examForm').on("click", 'input[type="radio"]', function(){
		 selected=$(this).val();
		 //alert(selected)
	 })
  
	$("#btnClickStart").on("click","",function(evt){
		evt.preventDefault();
		countForQuestionList = 0;
		loadQuestion(countForQuestionList);
		$(this).hide();
		 $("#btnClickNext").append('<input type="submit" value="Next" />')
		 
	})
	
	
	$("#btnClickNext").on("click","",function(evt){
		evt.preventDefault();
		
		 var testDetailsObj={
				 questionId:listOfQuestionIds[countForQuestionList],
				 testId:testId,
				 userResponse:selected,
				 finish:false
		}
		 if(countForQuestionList == (maxQuestions - 1))
		 { 
			 testDetailsObj.finish = true;
			 alert("Submit Test");
			
		 }
		 
		 $.ajax({
			 url:'addDataToTestDetailsTable.lti',
			 method:'POST',
			 data:JSON.stringify(testDetailsObj),
			 contentType:'application/json',
			 success:function(response){
				 if($.trim(response)){
					 //alert(JSON.stringify(response));
					 sessionStorage.setItem("userResult",JSON.stringify(response));
					 window.location.href="UserScore.html";
				 }
			
			 }
		 })
		
		countForQuestionList ++;
		if(countForQuestionList == (maxQuestions - 1))
			$(this).text("Finish Exam");
		else if(countForQuestionList == maxQuestions)
			alert("last question submitted");
		
		loadQuestion(countForQuestionList);
		
		//alert("next");
	})
	
		
		
	})
	
