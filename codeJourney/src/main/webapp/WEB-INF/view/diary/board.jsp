<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 목록</title>
<style>
nav {
	display: inline-flex;
	align-items: center;
	background-color: #f8f9fa;
	padding: 10px;
	border: 1px solid #ddd;
}

nav div, nav ul {
	margin: 0;
	padding: 0;
}

nav ul {
	display: flex;
	list-style-type: none;
	margin-left: 10px;
	margin-right: 10px;
}

nav li {
	margin: 0 5px;
}

nav a {
	text-decoration: none;
	color: #007bff;
}

nav a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1>다이어리 목록</h1>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>title</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="post" items="${list}">
				<tr>
					<td>${post.id}</td>
					<td><a href="detail?id=${post.id}">${post.title}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>page : ${page}</div>
	
	<div>
		<a href="reg">작성하기</a>
	</div>

	<nav>
		<div>
			<a href="?p=1">처음으로</a>
		</div>
		<div>
			<a href="?p=${prevPage}">이전</a>
		</div>
		<ul>
			<c:forEach var="p" items="${pages}">
				<li><a href="?p=${p}">${p}</a></li>
			</c:forEach>
		</ul>
		<div>
			<a href="?p=${nextPage}">다음</a>
		</div>
		<div>
			<a href="?p=${lastPage}">끝으로</a>
		</div>
	</nav>

</body>
</html>