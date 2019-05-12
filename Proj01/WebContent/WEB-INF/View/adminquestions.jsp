<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head><title>AdminQuestions</title></head>
<body>  
<table><tr>
<td>
<a href="adminexams.htm">Exams</a>
</td>
<td>
<a href="adminaddexam.htm">AddExams</a>
</td>
<td>
<a href="addquestion.htm">AddQuestions</a>
</td>
<td>
<a href="logout.htm">Logout</a>
</td>
</tr></table>
<table> 
<tr>
<th>S.No</th>
<th>Question </th>
<th>Answer1</th>
<th>Answer2</th>
<th>Answer3</th>
<th>Answer4</th>
<th>CorrectAnswer</th>
</tr>
<c:forEach items="${requestScope.questions}" var="question" varStatus="sts">
<tr>
<td>${sts.count} 
</td>
<td>
${question.question}
</td>
<td>
${question.answer1}
</td>
<td>
${question.answer2}
</td>
<td>
${question.answer3}
</td>
<td>
${question.answer4}
</td>
<td>
${question.correctAnswer}
</td>
</tr>
 </c:forEach>
</table>
</body>
</html>