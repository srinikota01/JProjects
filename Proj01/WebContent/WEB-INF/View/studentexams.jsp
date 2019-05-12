<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head><title>StudentExams</title></head>
<body>
<table><tr>
<td>
<a href="studentexams.htm">Exams</a>
</td>
<td>
<a href="results.htm">Results</a>
</td>
<td>
<a href="studentlogout.htm">Logout</a>
</td>
</tr></table> 
<form action="studentquestions.htm" method="POST">
<table> 
<tr>
<th>exam
</th>
<td>
<select name="examId" required> 
<option value="" > 
select Exam
</option>
<c:forEach items="${requestScope.exams}" var="exam" varStatus="st">
<option value="${exam.examId}">
${exam.examTitle} ${exam.examCode}
</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="SelectExam"></td>
</tr>
</table>
</form>
</body>
</html>