<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- article ���� ���� -->
    <div id="article">
        <div id="header2">
            <h1>member����Ʈ ������ ó�� ����</h1>
            <p id="time">Oct 1th, 2020</p>
        </div>
     <div id="content">
        <p>����� ���� ������ </p>
        <div id ="cont"></div> 
 
		<table>
			<thead>
			 	<tr>
			 		<th colspan="4">����Ʈ</th>
			 	</tr>
				<tr>
					<td>��ȣ</td>
					<td>���̵�</td>
					<td>�̸�</td>
					<td>��¥</td>
				
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
				<%--pageó�� --%>
			<%-- 	<%@include file="pageProcess.jsp"%> --%>
				</td>
				</tr>
				
				<tr>
					<th colspan="6">
					<form method="post" action="memberserachlist">
	<%-- 					<input type="hidden" name ="page" value="${param.page }"> --%>
						 	<select name ="searchType">
						 		<option value="1">���̵�</option>
						 		<option value="2">�̸�</option>
					<!-- 	 		<option value="3">����</option> -->
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
 <%-- Content ������ ���ڸ� --%> 
 <p>�������ؽ�Ʈ�� �� �������� �Ҹ��� ���α׷��� ���� �� �������� "����"�� �� ���������� ���� ������ �о�鿩 ��ǻ�� ����Ϳ� ����ϴ� ���·� ���̰� �ȴ�. �׷��� ���� ����ڴ� �� �������� �ִ� �����۸�ũ�� ���� �ٸ� ������ �̵��ϰų�, �� �������� �����ϰ� �ִ� ������ �Ϸ��� ������ ���� ���� �ִ�. �����۸�ũ�� ���� �̵��ϴ� ������ ���� �� ����(web surfing, ��ȭ��: ������) �Ǵ� �� ����¡�̶� �Ѵ�. �׸��� ���õ� ������� ���ִ� �� ���������� ������ �� ����Ʈ�� �Ѵ�.</p>
            <div id="footer2">
                <p>���� ���̵� ���� ������ ������ ������� ����� �� �ְڴ�. ù��° ���ϵ� �� �ڿ��� ��ġ ���� ��� ���� ��� URL. �ι�° ���� �ڿ� �̸��� �����ϴ� ��������(protocol) ���� ��� HTTP, �ڿ��� ���̸� ���� ���� �� �� �ִ� ��� ���� ��� HTML.</p>
            </div>
        </div>
        <div id="footer3">
            Article Footer
        </div>
    </div>
    <!-- article ���� �� -->
    <div id="aside">
        <div id="header5">
            <h1>Siderbar Heading</h1>
        </div>
        <p>������ �� ������ �ƴ� ���ü��� ���� ������� aside�� ǥ���� �� �ִ�.
  ������ ���������� ����� ���� ���� ����Ʈ ��ũ�� �ȳ���,
   nav ����� �׷� ���� aside ��ҷ� ��� �� �� �ִ�.
  ���� ��α׿��� �¿��� ���̵�ٸ� �ǹ��ϴ� �����μ� ���̵���� Ư������ 
  ���� �ʼ������� �ʾƼ� ǥ�ø� �ص� �ǰ� �� �ص� �Ǵ� ����� �Ǵ� ��������
   ������� �ڸ��� �� �ִ�.</p>
    </div>
 <script>
 $(function () {
	 $('#idChkBtn').click(function () {
		$.ajax({
			url:'idChk?id='+$('#id').val(),
			success:function(data){
				console.log("data:"+data)
				if(data === 0 ){
					$('#target').html("<p style='color:blue'>��� ���</p>");
				}else{
					$('#target').html("<p style='color:red'>�̹� ����</p>");
					$('#id').val("");
				}
			}
		})
	});
});
 </script>   
    
    
    
    