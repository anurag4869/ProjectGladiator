$(function(){
		var list;
		var idOfSubject;
		$("#allSubjects").on("click",".approve-btn",function(evt){
			evt.preventDefault();
			// var btnText=$(this).text();
			// alert(btnText);
			 idOfSubject = $(this).attr("id");
			alert(idOfSubject);
			alert("hey");
			// var sid = $("#1").val();
						
			var subjectObj={
					subjectId: idOfSubject
			}
			alert(idOfSubject);
			alert("hey2");
			$("#allSubjects").hide();
			window.location.href= "AddQuestion.html";
			
			// alert(subjectObj);
		})
		
			
		 $("#addQuestionForm").submit(function (evt) {
             evt.preventDefault();
             alert(idOfSubject);
 			alert("hey3");
             var questionObj = {
                     question: $("#question").val(),
                     choiceOne: $("#choice1").val(),
                     choiceTwo: $("#choice2").val(),
                     choiceThree: $("#choice3").val(),
                     choiceFour: $("#choice4").val(),
                     questionLevel: $("#level").val(),
                     correctAns: $("#correctAnswer").val()    
                 }
             
             var subjectObj={
             		subjectId:idOfSubject
             }
           alert(idOfSubject);
             $("#addQuestionForm").submit(function(evt){
     			evt.preventDefault();
                   $.ajax({
                        url:'addQuestion.lti',
                        method:'POST',
                        data: JSON.stringify(questionObj),
                        contentType : 'application/json',
                        success : function(response){
                     	   alert(JSON.stringify(response));
                     	   
                     	   $.ajax({
                     		   url:'addQuestionForSubject.lti',
                     		   method:'POST',
                     		   data:JSON.stringify(subjectObj),
                     		   contentType : 'application/json',
                     		   success : function(response){
                     			   alert(JSON.stringify(response.subjectId));
                     			   
                     		   }
                      })
                      
                        }
                   })
             })
		  })
})
             