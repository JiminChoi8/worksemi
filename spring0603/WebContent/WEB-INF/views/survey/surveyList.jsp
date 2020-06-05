<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>surveyList.jsp</title>
<style>
	#wrap {width: 450px; margin: auto;}
	talbe {border-collapse:collapse; width: 100%}
	th{ background-color: #c0c0c0}
	tbody img{ width: 100px;}
	th,td {padding: 8px; text-align: left; border-bottom: 1px solid #ddd;}
	tr:hover {background: #f5f5f5} 
</style>
</head>
<body>
<div id="wrap">
<h2> Survey Admin List 에제</h2>
<table>
<thead>
	<tr>
		<th>번호</th>
		<th>설문제목</th>
		<th>설문항목</th>
		<th>총투표수</th>
		<th>등록날짜</th>
	</tr>
</thead>
<tbody>
 <c:forEach var="e" items="${list }"> 
	<tr>
		<td>${e.num }</td>	 
		<td><a href="surveyDetail?num=${e.num }">${e.sub }</a></td>		
		<td>${e.code }</td>	
		<td>${e.total }</td>	
		<td>${e.sdate }</td>	
	</tr>
 </c:forEach> 
</tbody>
<tfoot>
	<tr><th colspan="5">
	<input type="button" value="등록품" id="writenBtn">
	<input type="button" value="설문참여하기" id="surveyClient">
	</th></tr>	
</tfoot>
</table>
</div>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script>
  $(function () {
	  $('#writenBtn').click(function () {
		location='surveyForm';
	});
	  $('#surveyClient').click(function () {
			location='surveyClient';
	  });
  });
  </script>
</body>
</html>