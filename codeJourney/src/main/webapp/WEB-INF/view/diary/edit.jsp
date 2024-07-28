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
		<h1>다이어리 수정</h1>
		<form method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>다이어리</legend>
				<p>주의) csv파일에 저장될거라 \n \r ,를 쓸 수 없어요..</p>
				
				<div>
					<label> 제목<input name="title" value="${diary.title}"></label>
				</div>
				
				<div>
					<label>내용<textarea name="content" rows="10" cols="40">${diary.content}</textarea></label>
				</div>
				
				<fieldset>
					<legend>사진업로드</legend>
					<p>새롭게 첨부할 이미지를 다시 업로드해주세요...</p>
					<div>이전에 업로드되었던 사진</div>
					<div><img alt="이미지 없음" src="${pageContext.request.contextPath}/diary/imgUpload/${diary.imgName}"></div>
					<label>사진선택<input type="file" name="img" ></label>
				</fieldset>
				
				<button>작성완료</button>
				<a href="${previousPage}">취소</a>
			</fieldset>
		</form>
	</section>
</body>
</html>
</html>