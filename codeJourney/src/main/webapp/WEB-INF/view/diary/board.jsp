<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 목록</title>
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

    td.id-column {
        width: 100px; /* Fixed width for ID column */
    }

    td.title-column {
        max-width: 600px; /* Fixed maximum width for Title column */
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    
    .post-image {
        max-width: 50px;
        max-height: 50px;
        object-fit: cover;
        border-radius: 4px;
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
    justify-content: center; /* Center-align the items horizontally */
    align-items: center;
    background-color: #f8f9fa;
    padding: 10px;
    border: 1px solid #ddd;
    margin: 20px auto;
    width: 80%;
    gap: 10px; /* Space between items */
}

nav div, nav ul {
    margin: 0;
    padding: 0;
}

nav ul {
    display: flex;
    list-style-type: none;
    gap: 10px; /* Space between page numbers */
}

nav li {
    margin: 0;
}

nav a {
    text-decoration: none;
    color: #007bff;
}

nav a:hover {
    text-decoration: underline;
}

.current-page {
    font-weight: bold;
    color: #000;
}

.button-link {
    display: inline-block;
    padding: 10px 20px;
    margin: 5px;
    background-color: #007bff;
    color: white;
    text-align: center;
    border-radius: 4px;
    text-decoration: none;
    transition: background-color 0.3s;
}

.button-link:hover {
    background-color: #0056b3;
}

.button-link.gray {
    background-color: #6c757d;
}

.button-link.gray:hover {
    background-color: #5a6268;
}

    .current-page {
        font-weight: bold;
        color: #000;
    }

    .actions {
        width: 80%;
        margin: 20px auto;
        display: flex;
        justify-content: flex-end; /* Right align the button */
        align-items: center;
    }

    .actions div {
        color: #333;
    }

    .actions a {
        color: white; /* White text color for the write button */
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
                <th colspan="2">title</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${list}">
                <tr>
                    <td class="id-column">${post.id}</td>
                    <td class="id-column"><img alt="" class="post-image" src="imgUpload/${post.imgName}"></td>
                    <td class="title-column"><a href="detail?id=${post.id}">${post.title}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="actions">
        <a href="reg" class="button-link">작성하기</a>
    </div>

    <nav>
        <div>
            <a href="?p=1" class="button-link gray">처음으로</a>
        </div>
        <div>
            <a href="?p=${prevPage}" class="button-link gray">이전</a>
        </div>
        <ul>
            <c:forEach var="p" items="${pages}">
                <li><a href="?p=${p}" class="${p == page ? 'current-page' : ''}">${p}</a></li>
            </c:forEach>
        </ul>
        <div>
            <a href="?p=${nextPage}" class="button-link gray">다음</a>
        </div>
        <div>
            <a href="?p=${lastPage}" class="button-link gray">끝으로</a>
        </div>
    </nav>
</body>
</html>

