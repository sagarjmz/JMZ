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
h1 {
	text-align: center;
}

.button {
	width: 80px;
	height: 25px;
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

#container1 {
	width: 50%;
	margin: 150px auto;
	padding: 40px 30px;
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
</body>
</html>

<script>
// 	private String qsn;
// 	private String oOne;
// 	private String oTwo;
// 	private String oThree;
// 	private String oFour;
// 	private String ans;

var obj = ${sessionScope.json[0]}; 
console.log(obj);
var obj1 = ${sessionScope.json[1]}; 
console.log(obj1); 
var obj2 = ${sessionScope.json[2]}; 
console.log(obj2); 
var obj3 = ${sessionScope.json[3]}; 
console.log(obj3); 
var obj4 = ${sessionScope.json[4]}; 
console.log(obj4); 
var objArray =[{obj},{obj1},{obj2},{obj3},{obj4}]; 
console.log(obj.qsn); 
console.log(obj.ans);

 

(function() 
		 {
		  var allQuestions = [{
		    question: obj.qsn,
		    options: [obj.oOne, obj.oTwo, obj.oThree, obj.oFour],
		    answer: obj.ans
		  }, {
			  question: obj1.qsn,
			    options: [obj1.oOne, obj1.oTwo, obj1.oThree, obj1.oFour],
			    answer: obj1.ans
		  }, {
			  question: obj2.qsn,
			    options: [obj2.oOne, obj2.oTwo, obj2.oThree, obj2.oFour],
			    answer: obj2.ans
		  },{
			  question: obj3.qsn,
			    options: [obj3.oOne, obj3.oTwo, obj3.oThree, obj3.oFour],
			    answer: obj3.ans
		  }, {
			  question: obj4.qsn,
			    options: [obj4.oOne, obj4.oTwo, obj4.oThree, obj4.oFour],
			    answer: obj4.ans
		  }];
		  
		  var quesCounter = 0;
		  var selectOptions = [];
		  var quizSpace = $('#quiz');
		    
		  nextQuestion();
		    
		  $('#next').click(function () 
		    {
		        chooseOption();
		        if (isNaN(selectOptions[quesCounter])) 
		        {
		            alert('Please select an option !');
		        } 
		        else 
		        {
		          quesCounter++;
		          nextQuestion();
		        }
		    });
		  
		  $('#prev').click(function () 
		    {
		        chooseOption();
		        quesCounter--;
		        nextQuestion();
		    });
		  
		  function createElement(index) 
		    {
		        var element = $('<div>',{id: 'question'});
		        var header = $('<h2>Question No. ' + (index + 1) + ' :</h2>');
		        element.append(header);

		        var question = $('<p>').append(allQuestions[index].question);
		        element.append(question);

		        var radio = radioButtons(index);
		        element.append(radio);

		        return element;
		    }
		  
		  function radioButtons(index) 
		    {
		        var radioItems = $('<ul>');
		        var item;
		        var input = '';
		        for (var i = 0; i < allQuestions[index].options.length; i++) {
		          item = $('<li>');
		          input = '<input type="radio" name="answer" value=' + i + ' />';
		          input += allQuestions[index].options[i];
		          item.append(input);
		          radioItems.append(item);
		        }
		        return radioItems;
		  }
		  
		  function chooseOption() 
		    {
		        selectOptions[quesCounter] = +$('input[name="answer"]:checked').val();
		    }
		   
		  function nextQuestion() 
		    {
		        quizSpace.fadeOut(function() 
		            {
		              $('#question').remove();
		              if(quesCounter < allQuestions.length)
		                {
		                    var nextQuestion = createElement(quesCounter);
		                    quizSpace.append(nextQuestion).fadeIn();
		                    if (!(isNaN(selectOptions[quesCounter]))) 
		                    {
		                      $('input[value='+selectOptions[quesCounter]+']').prop('checked', true);
		                    }
		                    if(quesCounter === 1)
		                    {
		                      $('#prev').show();
		                    } 
		                    else if(quesCounter === 0)
		                    {
		                      $('#prev').hide();
		                      $('#next').show();
		                    }
		                }
		              else 
		                {
		                    var scoreRslt = displayResult();
		                    quizSpace.append(scoreRslt).fadeIn();
		                    $('#next').hide();
		                    $('#prev').hide();
		                }
		        });
		    }
		  
		  function displayResult() 
		    {
		        var score = $('<h1>',{id: 'question'});
		        var correct = 0;
		        for (var i = 0; i < selectOptions.length; i++) 
		        {
		          if (selectOptions[i] == allQuestions[i].answer) 
		          {
		            correct++;
		          }
		        }
		        if(correct>=3)
		        	{
// 		        score.append('You scored ' + correct + ' out of ' +allQuestions.length);
                score.append('examination pass '+'correct answer : '+correct);
		        return score;
		        	}else
		        		{
		        		score.append('examination fail '+'correct answer : '+correct);
		        		return score;
		        		}
		        
		  }
		})();

	</script>


<%-- 	<c:forEach items="${questions}" var="s"> --%>
<!-- 		<br> -->
<%-- 	 ${s}<br> --%>
<%-- 	</c:forEach> --%>
