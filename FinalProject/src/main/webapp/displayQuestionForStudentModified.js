
$(function(){
	var listOfQuestionIds;
	var subjectId;
	var testId;
	var countForQuestionList=0;
	var count=1;
	var selected;
	var maxQuestions=5;
	$("#allSubjects").on("click",".approve-btn",function(evt){
		evt.preventDefault();
		
		subjectId = $(this).attr("id");
		
					
		var subjectObj={
				subjectId:subjectId
		}
		$("#allSubjects").hide();
		$("#Instructions").append("Instructions To Take The Test:"+"<br>").css({"font-weight":"bold","margin":"20px 0px 100px 10px","font-size":"px"});
		$("#Instructions").append("1. Make sure you have a good connection."+"<br>")
		$("#Instructions").append(" 2.Never click the Back button on the browser. This will take you out of the test."+"<br>");
		$("#Instructions").append("3. Do not resize the browser during the test."+"<br>")
		$("#Instructions").append("<br>")
		$("#Instructions").append("Passing Criteria:"+"<br>");
		$("#Instructions").append("1. The Test comprises of 10 questions totally."+"<br>")
		$("#Instructions").append(" 2. You have to score 60% to successfully clear the test."+"<br>");
		$("#Instructions").append("3. That means you have to score 6 out of 10 to clear the test."+"<br>")
		shuffleQuestionFunction();
		addToTestTableFunction();
		
		
	    var buttonStart=$('<input type="submit" id="btnChange" value="Start"></input>').css({"color":"white","background-color":"#4CAF50","border":"none","color":"none","padding":"15px 32px","text-align":"center"," text-decoration":"none","margin":"4px 2px"});
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
			
			}
		})
		
	}
	function addToTestTableFunction(){
		var tableTestObj={
    			studentId:sessionStorage.sid,
    			subjectId:subjectId
    	}
		 $.ajax({
			 url:'addDataToTestTable.lti',
			 method:'POST',
			 data:JSON.stringify(tableTestObj),
			 contentType:'application/json',
			 success:function(response){
				
				 testId=JSON.stringify(response.testId);
				
			

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
				 if(countForQuestionList != (maxQuestions - 1)) {
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
			 }
	})
	}
    
	$('#examForm').on("click", 'input[type="radio"]', function(){
		 selected=$(this).val();
		
	 })
  
	$("#btnClickStart").on("click","",function(evt){
		evt.preventDefault();
		
		countForQuestionList = 0;
		loadQuestion(countForQuestionList);
		$(this).hide();
		$("#Instructions").hide();	
		 $("#btnClickNext").append('<input type="submit" value="Next" id="btnNext"></input>');
		 $("#btnNext").css({"color":"white","background-color":"#4CAF50","border":"none","color":"none","padding":"15px 32px","text-align":"center"," text-decoration":"none","margin":"4px 2px"})
		 
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
			
			
		 }
		 
		 $.ajax({
			 url:'addDataToTestDetailsTable.lti',
			 method:'POST',
			 data:JSON.stringify(testDetailsObj),
			 contentType:'application/json',
			 success:function(response){
				 if($.trim(response) ){
					
					 sessionStorage.setItem("userResult",JSON.stringify(response));
					 window.location.href="UserScore.html";
				 }
			
			 }
		 })
		
		countForQuestionList ++;
		 if(countForQuestionList == (maxQuestions - 1)) {
			 $(this).text("Finish Exam");
		 }
		
		
		loadQuestion(countForQuestionList); 
		
		
	})
	
		
		
	})
	

