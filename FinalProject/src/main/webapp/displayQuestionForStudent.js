$(function(){
		$("#allSubjects").on("click",".approve-btn",function(evt){
			evt.preventDefault();
			//var btnText=$(this).text();
			//alert(btnText);
			var test = $(this).attr("id");
			//var sid = $("#1").val();
						
			var subjectObj={
					subjectId:test
			}
			//alert(subjectObj);
		    $.ajax({
				url:'displayQuestions.lti',
				method:'POST',
				data:JSON.stringify(subjectObj),
				contentType:'application/json',
				success:function(response){
					$.each(response,function(index,questionObj){
						$("#divQuestion").append(response[index].question);
						$("#divQuestion").append("<br>");
						$("#divQuestion").append($('<input type="radio" id="choiceOne">'+response[index].choiceOne+'</input>'));
						$("#divQuestion").append("<br>");
						$("#divQuestion").append($('<input type="radio" id="choiceTwo">'+response[index].choiceTwo+'</input>'));
						$("#divQuestion").append("<br>");
						$("#divQuestion").append($('<input type="radio" id="choiceThree">'+response[index].choiceThree+'</input>'));
						$("#divQuestion").append("<br>");
						$("#divQuestion").append($('<input type="radio" id="choiceFour">'+response[index].choiceFour+'</input>'));
						$("#divQuestion").append("<br>");
						$("#divQuestion").append("<hr>");
					
					})
					
					
					
					
					
					
				}
			})
		
		})
	})