<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.Scanner"%>
<%@page import="com.file.Questions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Online Examination System</title>
<!-- <link rel="stylesheet" href="quiz.css" /> -->
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet" />
<style type="text/css">
body{
/* background-color: #3f51b5; */
background-color:;

}
h1 {
	text-align: center;
}

.button {
	width: 100px;
	height: 30px;
	text-align: center;
	float: left;
	background-color: green;
	margin: 0 2px 0 2px;
	border-radius: 5px;
	cursor: pointer;
}

.button a {
	text-decoration: none;
	color: white;
	line-height: 25px;
}
#myForm{
display:none;
}
#f{
text-decoration: none;
	color: white;
	line-height: 25px;
	font-size:30px;"
}
#container {
font-size:20px;
	width: 70%;
	margin: 110px auto;
	padding: 70px 60px;
	background-color: #3f51b5;
	border-radius: 3px;
	color: #fff;
	box-shadow: 0 0 10px 0 #999;
}

ul {
	list-style-type: none;
	padding: 0;
	margin: 0;
	width: 500px;
}

ul li {
	width: 200px;
	margin: 10px;
	padding: 5px;
	display: inline-block;
}

#prev {
	display: none;
}

#start {
	display: none;
	width: 100px;
}

input[type="radio"] {
	cursor: pointer;
}
</style>
</head>
<body>

	<div id="container">
		<h1>Online Examination System</h1>
		<br />
		<div id="quiz"></div>

		<div class="button" id="prev">
			<a href="#">Prev</a>
		</div>
		<div class="button" id="next">
			<a href="#">Next</a>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
	<!-- 	<script src="quiz.js"></script> -->


<div></div>
	<form name="myForm" id="myForm" action="./../Store" method="POST" >
		<input type="text" id="f" class="button" name="result" value=""/>
		<input type="text" id="f" class="button" name="len" value=""/>
		<input type="text" id="f" class="button" name="examId" value="${sessionScope.examId}"/>
		<input type="text" id="f" class="button" name="userId" value="${sessionScope.userId}"/>
		<input type="submit" id="f" class="button"/>
	</form>

</body>
</html>
<%-- <c:forEach items="${questions}" var="s"> --%>
<!-- 	      <br>  -->
<%--       ${s}<br> --%>
<%-- </c:forEach> --%>
<script>
	// var session = ${sessionScope.len};
	//  console.log(session);
	var range = ${len};
	var session = ${sessionScope.questions};
	console.log(session);
	var newArray = ${questions};
	var ranges = newArray.length;
	console.log('ranges : ' + ranges);
	var newObject = [];
	console.log(newArray);
	for (var num = 0; num < newArray.length; num++) {
		newObject.push(newArray[num]); //pushing objects to newArray
	}

	var allObjects = [];
	//question:"prabhakar",options: ["1", "2", "3", "4"],answer: 2
	for (var num = 0; num < newObject.length; num++)//setting object into perticular format
	{
		allObjects[num] = {
			question : newObject[num].qsn,
			options : [ newObject[num].oOne, newObject[num].oTwo,
					newObject[num].oThree, newObject[num].oFour ],
			answer : newObject[num].ans
		}

	}

	(function() {

		var quesCounter = 0;
		var selectOptions = [];
		var quizSpace = $('#quiz');

		nextQuestion();

		$('#next').click(function() {
			chooseOption();
			if (isNaN(selectOptions[quesCounter])) {
				alert('Please select an option !');
			} else {
				quesCounter++;
				nextQuestion();
			}
		});

		$('#prev').click(function() {
			chooseOption();
			quesCounter--;
			nextQuestion();
		});

		function createElement(index) {
			var element = $('<div>', {
				id : 'question'
			});
			var header = $('<h2>Question No. ' + (index + 1) + ' :</h2>');
			element.append(header);

			//  var question = $('<p>').append(allQuestions[index].question);
			var question = $('<p>').append(allObjects[index].question);
			element.append(question);

			var radio = radioButtons(index);
			element.append(radio);

			return element;
		}

		function radioButtons(index) {
			var radioItems = $('<ul>');
			var item;
			var input = '';
			//  for (var i = 0; i < allQuestions[index].options.length; i++) {
			for (var i = 0; i < allObjects[index].options.length; i++) {
				item = $('<li>');
				input = '<input type="radio" name="answer" value=' + i + ' />';
				//   input += allQuestions[index].options[i];
				input += allObjects[index].options[i];
				item.append(input);
				radioItems.append(item);
			}
			return radioItems;
		}

		function chooseOption() {
			selectOptions[quesCounter] = +$('input[name="answer"]:checked')
					.val();
		}

		function nextQuestion() {
			quizSpace.fadeOut(function() {
				$('#question').remove();
				//if(quesCounter < allQuestions.length)
				if (quesCounter < allObjects.length) {
					var nextQuestion = createElement(quesCounter);
					quizSpace.append(nextQuestion).fadeIn();
					if (!(isNaN(selectOptions[quesCounter]))) {
						$('input[value=' + selectOptions[quesCounter] + ']')
								.prop('checked', true);
					}
					if (quesCounter === 1) {
						$('#prev').show();
					} else if (quesCounter === 0) {
						$('#prev').hide();
						$('#next').show();
					}
				} else {
					var scoreRslt = displayResult();
					quizSpace.append(scoreRslt).fadeIn();
					$('#next').hide();
					$('#prev').hide();
				}
			});
		}

		function displayResult() {
			//submitform();
			var score = $('<h1>', {
				id : 'question'
			});
			var correct = 0;
			for (var i = 0; i < selectOptions.length; i++) {
				if (selectOptions[i] == allObjects[i].answer)
				//  if (selectOptions[i] == allQuestions[i].answer) 

				{
					correct++;
				}
			}
			var Myelement = document.querySelector('input[name="result"]');
			var Myelements = document.querySelector('input[name="len"]');
			Myelement.value = correct ;
			Myelements.value = range ;
			console.log(Myelement.value);
			console.log(Myelements.value);
			
			submitform();
			var count = correct/2;
		
				score.append('<h1 style="color:white">Thank you for giving Exam</h1>');
				return score;
			
		}
	})();

	
	 function submitform()
	    {
	
	      document.myForm.submit();
	    }
    
	
</script>


<%-- 	<c:forEach items="${questions}" var="s"> --%>
<!-- 		<br> -->
<%-- 	 ${s}<br> --%>
<%-- 	</c:forEach> --%>
