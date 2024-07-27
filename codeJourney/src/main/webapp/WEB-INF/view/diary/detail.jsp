<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 작성글</title>
</head>
<body>
	<h1></h1>

	<table>
		<thead>
			<tr>
				<th>${diary.id}</th>
				<th>${diary.title}</th>
			</tr>
		</thead>

		<tbody>			
				<tr>
					<td colspan="2">${diary.content}</td>					
				</tr>			
		</tbody>
	</table>
	
	<div>
		<a href="${previousPage}">목록으로</a>
	</div>

</body>
</html>