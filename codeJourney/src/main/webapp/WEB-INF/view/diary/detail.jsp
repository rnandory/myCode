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
</html>