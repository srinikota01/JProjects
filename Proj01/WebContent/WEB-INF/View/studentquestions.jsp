<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head><title>AdminQuestions</title>
<script type="text/javascript">
var maxtimemin = 0;
var maxtimesec = 10;
function timeout()
{
	document.getElementById("ptime").innerText = "RemainingTime" + maxtimemin+":"+maxtimesec;
	maxtimesec--;
	if(maxtimesec==0){
		maxtimemin--;
		maxtimesec = 59;
}	
	
	if(maxtimemin==0 && maxtimesec==1)
		alert("Your time is out. please submit your exam");
	 //document.getElementById("examform").submit(); 
	  	}
	
setInterval(timeout,1000);	
</script>
</head>
<body>  
<table><tr>
<td>
<a href="studentlogout.htm">Logout</a>
<p id="ptime"></p>
</td>
</tr></table>
<form id="examform" action="submitexam.htm" method="POST">
<table> 
<c:forEach items="${requestScope.questions}" var="question" varStatus="sts">
<tr>
<td>${sts.count} 
</td>
<td>
${question.question}
</td>
</tr>
<tr>
<td>
<input type="radio" name="question${question.questionId}" value="answer1">
${question.answer1}
<input type="radio" name="question${question.questionId}" value="answer2">
${question.answer2}
</td>
<td>
<input type="radio" name="question${question.questionId}" value="answer3">
${question.answer3}
<input type="radio" name="question${question.questionId}" value="answer4">
${question.answer4}
<input type="hidden" name="question" value="${question.questionId}">
</td>
</tr>
 </c:forEach>
 <tr>
 <td colspan="2">
 <input type="submit" value="SubmitAnswer">
 <input type="hidden" value="${param.examId}" name="examId">
 </td>
 </tr>
</table>
</form>
</body>
</html>