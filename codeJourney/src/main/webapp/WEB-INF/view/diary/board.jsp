<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 목록</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 20px;
    }
    
    h1 {
        text-align: center;
        color: #333;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        background-color: #fff;
    }

    th, td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f8f9fa;
        color: #333;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    a {
        color: #007bff;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    nav {
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #f8f9fa;
        padding: 10px;
        border: 1px solid #ddd;
        margin: 20px auto;
        width: 80%;
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

    .actions {
        width: 80%;
        margin: 20px auto;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .actions div {
        color: #333;
    }

    .actions a {
        color: #007bff;
        text-decoration: none;
    }

    .actions a:hover {
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

    <div class="actions">
        <div>page : ${page}</div>
        <div>
            <a href="reg">작성하기</a>
        </div>
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