<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 작성글</title>
</head>
<body>
	
	<section>
		<h1>다이어리 게시물</h1>
		<div>id ${diary.id}</div>
		<hr>
		<div>${diary.title}</div>
		<hr>
		<div><img alt="이미지 없음" src="${imgPath}"></div>
		<div>${diary.content}</div>
		<hr>
	</section>

	
	
	<div>
		<a href="${previousPage}">목록으로</a>
		<a href="edit?id=${diary.id}">수정</a>
		<a href="delete?id=${diary.id}">삭제</a>
	</div>

</body>
</html> --%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 작성글</title>
</head>
<body>
	
	<section>
		<h1>다이어리 게시물</h1>
		<div>id ${diary.id}</div>
		<hr>
		<div>${diary.title}</div>
		<hr>
		<div><img alt="이미지 없음" src="${imgPath}"></div>
		<div>${diary.content}</div>
		<hr>
	</section>

	
	
	<div>
		<a href="${previousPage}">목록으로</a>
		<a href="edit?id=${diary.id}">수정</a>
		<a href="delete?id=${diary.id}">삭제</a>
	</div>

</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 작성글</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 20px;
}

section {
	width: 80%;
	margin: 20px auto;
	background-color: #fff;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

h1 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
}

hr {
	border: 0;
	height: 1px;
	background: #ddd;
	margin: 20px 0;
}

div {
	margin-bottom: 20px;
	color: #555;
}

img {
	max-width: 100%;
	height: auto;
	display: block;
	margin: 0 auto;
}

.actions {
	display: flex;
	justify-content: center; /* Center align items by default */
	gap: 10px;
}

.actions.right {
	justify-content: flex-end; /* Align to the right */
}

.actions a {
	text-decoration: none;
	padding: 10px 20px;
	background-color: #007bff;
	color: white;
	border-radius: 4px;
	transition: background-color 0.3s;
}

.actions a:hover {
	background-color: #0056b3;
}

.actions a.first {
	background-color: #6c757d;
}

.actions a.first:hover {
	background-color: #5a6268;
}
</style>
</head>
<body>
	<section>
		<h1>다이어리 게시물</h1>
		<div>
			<strong>id:</strong> ${diary.id}
		</div>
		<hr>
		<div>
			<strong>제목:</strong> ${diary.title}
		</div>
		<hr>
		<div>
			<img alt="이미지 없음" src="imgUpload/${diary.imgName}">
		</div>
		<div>
			<strong>내용:</strong> ${diary.content}
		</div>
		<hr>
		
		<div class="actions">
			<a href="${previousPage}" class="first">목록으로</a>
		</div>
		<div class="actions right">
			<a href="edit?id=${diary.id}">수정</a> <a href="delete?id=${diary.id}">삭제</a>
		</div>
	</section>
</body>
</html>