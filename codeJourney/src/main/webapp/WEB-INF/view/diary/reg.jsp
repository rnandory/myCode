<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 작성페이지</title>
</head>
<body>
	<section>
		<h1>다이어리 작성</h1>
		<form method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>다이어리</legend>
				<div>
					<label> 제목<input name="title"></label>
				</div>
				
				<div>
					<label>내용<textarea name="content" rows="10" cols="40"></textarea></label>
				</div>
				
				<fieldset>
					<legend>사진업로드</legend>
					<label>사진선택<input type="file" name="img" ></label>
				</fieldset>
				
				<button>작성완료</button>
				<a href="${previousPage}">목록으로</a>
			</fieldset>
		</form>
	</section>
</body>
</html>