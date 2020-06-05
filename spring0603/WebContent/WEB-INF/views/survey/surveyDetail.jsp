<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>surveyDatail</title>
</head>
<body>
<div id="container">
 <form method="post" action="addsurvey" enctype="multipart/form-data">
 <table>
  <thead>
   <tr><th colspan="2">SurveyDatil</th></tr>
  </thead>
  <tbody>

					<c:forEach var="e" items="${list }" varStatus="i">
						<c:if test="${i.index ==0 }">
							<tr>
								<th>제목</th>
								<td><input type="text" name="sub" id="sub"
									value="${e.sub }" readonly="readonly"></td>
							</tr>
							<input type="hidden" id="num" value="${e.num }">
						</c:if>
						<!--  <tr><th>문항수</th><td><input type="number" name="code" id="code"></td></tr> -->
						<tr>
							<th>${i.index+1}번설문문항${e.surveytype}</th>
							<td>${e.surveytitel} => ${e.surveycnt }</td>
						</tr>
					</c:forEach>

				</tbody>
  <tfoot>
  <tr><th colspan="2"><input type="button" value="list"
  onclick="location='surveylist'">
  <%--jQuery을 사용해서 url로 넘기기 --%>
  <input type="button" value="delete" id="delete"
  >
  </th></tr>
  </tfoot>
 </table>
 <div>
 <script
  src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script>
 $(function () {
	$('#delete').click(function () {
		if(confirm('정말로 삭제 하시겠습니까?')){
			var numv = $('#num').val();
			alert("삭제 처리로 이동하기" +numv);
			location="delete?num="+numv;
		}
	});
});
 </script>
 </div>
 </form>
 </div>
</body>
</html>