<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- article 영역 시작 -->
    <div id="article">
        <div id="header2">
            <h1>member리스트 페이지 처리 예제</h1>
            <p id="time">Oct 1th, 2020</p>
        </div>
     <div id="content">
        <p>여기는 메인 컨텐츠 </p>
        <div id ="cont"></div> 
 
		<table>
			<thead>
			 	<tr>
			 		<th colspan="4">리스트</th>
			 	</tr>
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>날짜</td>
				
				</tr>
			</thead>
			<tbody>
			<c:forEach var ="listv" items="${list }">
				<tr>
				<td>${listv.num }</td>
				<td>${listv.id }</td>
				<td>${listv.name }</td>
				<td>${listv.rdate }</td>
				</tr>	
			</c:forEach>			
			</tbody>
			<tfoot>
				<tr>
				<td colspan="4" id="pageTd">
				<%--page처리 --%>
			<%-- 	<%@include file="pageProcess.jsp"%> --%>
				</td>
				</tr>
				
				<tr>
					<th colspan="6">
					<form method="post" action="memberserachlist">
	<%-- 					<input type="hidden" name ="page" value="${param.page }"> --%>
						 	<select name ="searchType">
						 		<option value="1">아이디</option>
						 		<option value="2">이름</option>
					<!-- 	 		<option value="3">내용</option> -->
						 	</select> <input name="searchValue">
						 <input type="submit" value="Search">					
					</form>
					
					</th>			
				</tr>
				<tr>
					<th colspan="4"><input type="button" value="writer"
					onclick="location='memberForm'">
					</th>
				</tr>
			</tfoot>
		</table>  
 <%-- Content 내용들어 갈자리 --%> 
 <p>하이퍼텍스트는 웹 브라우저라 불리는 프로그램을 통해 웹 서버에서 "문서"나 웹 페이지등의 정보 조각을 읽어들여 컴퓨터 모니터에 출력하는 형태로 보이게 된다. 그러고 나서 사용자는 각 페이지에 있는 하이퍼링크를 따라 다른 문서로 이동하거나, 그 페이지를 서비스하고 있는 서버로 일련의 정보를 보낼 수도 있다. 하이퍼링크를 따라 이동하는 행위를 흔히 웹 서핑(web surfing, 문화어: 망유람) 또는 웹 브라우징이라 한다. 그리고 관련된 내용들이 모여있는 웹 페이지들의 집합을 웹 사이트라 한다.</p>
            <div id="footer2">
                <p>월드 와이드 웹은 다음의 세가지 기능으로 요약할 수 있겠다. 첫번째 통일된 웹 자원의 위치 지정 방법 예를 들면 URL. 두번째 웹의 자원 이름에 접근하는 프로토콜(protocol) 예를 들면 HTTP, 자원들 사이를 쉽게 항해 할 수 있는 언어 예를 들면 HTML.</p>
            </div>
        </div>
        <div id="footer3">
            Article Footer
        </div>
    </div>
    <!-- article 영역 끝 -->
    <div id="aside">
        <div id="header5">
            <h1>Siderbar Heading</h1>
        </div>
        <p>문서의 주 내용이 아닌 관련성이 낮은 내용들은 aside로 표시할 수 있다.
  본문과 직접적으로 상관이 없는 관련 사이트 링크나 안내글,
   nav 요소의 그룹 등이 aside 요소로 기술 될 수 있다.
  보통 블로그에서 좌우측 사이드바를 의미하는 것으로서 사이드바의 특성으로 
  볼때 필수적이지 않아서 표시를 해도 되고 안 해도 되는 내용들 또는 광고물같은
   내용들이 자리할 수 있다.</p>
    </div>
 <script>
 $(function () {
	 $('#idChkBtn').click(function () {
		$.ajax({
			url:'idChk?id='+$('#id').val(),
			success:function(data){
				console.log("data:"+data)
				if(data === 0 ){
					$('#target').html("<p style='color:blue'>사용 기능</p>");
				}else{
					$('#target').html("<p style='color:red'>이미 존재</p>");
					$('#id').val("");
				}
			}
		})
	});
});
 </script>   
    
    
    
    