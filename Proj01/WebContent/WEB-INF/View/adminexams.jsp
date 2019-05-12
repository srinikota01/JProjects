<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head><title>AdminExams</title></head>
<body>
<table><tr>
<td>
<a href="adminexams.htm">Exams</a>
</td>
<td>
<a href="addexam.htm">AddExams</a>
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
<th>Exam Title</th>
<th>Exam Code</th>
<th></th>
</tr>
<c:forEach items="${requestScope.exams}" var="exam" varStatus="st">
<tr>
<td>${st.count} 
</td>
<td>
${exam.examTitle}
</td>
<td>
${exam.examCode}
</td>
<td>
<a href="adminquestions.htm?examId=${exam.examId}">ViewQuestions</a>
</td>
</tr>
 </c:forEach>
</table>
</body>
</html>