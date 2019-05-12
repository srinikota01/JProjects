<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head><title>AddingQuestions</title></head>
<body>  
<form action="addquestion.htm" method="post">
<table> 
<tr>
<th>exam</th>
<td><select name="examId" required> 
<option value="" > 
select Exam
</option>
<c:forEach items="${requestScope.exams}" var="exam" varStatus="st">
<option value="${exam.examId}">
${exam.examTitle} ${exam.examCode}
</option>
</c:forEach>
</select></td>
</tr>
<tr>
<th>Question</th>
<td><textarea name="question" required></textarea></td>
</tr>
<tr>
<th>answer1</th>
<td><textarea name="answer1" required></textarea></td>
</tr>
<tr>
<th>answer2</th>
<td><textarea name="answer2" required></textarea></td>
</tr>
<tr>
<th>answer3</th>
<td><textarea name="answer3" required></textarea></td>
</tr>
<tr>
<th>answer4</th>
<td><textarea name="answer4" required></textarea></td>
</tr>
<tr>
<th>Correct Answer</th>
<td><select name="correctAnswer" required>
<option value="">select answer
</option>
<option value="answer1">answer1</option>
<option value="answer2">answer2</option>
<option value="answer3">answer3</option>
<option value="answer4">answer4</option>
</select></td>
</tr>
<tr>
<td colspan="2" ><input type="submit" value="AddQuestion"/></td>
</tr>
</table>
</form>
</body></html>