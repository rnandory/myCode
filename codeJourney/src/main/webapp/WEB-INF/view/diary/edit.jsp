<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
					<div>
						<img alt="이미지 없음"
							src="${pageContext.request.contextPath}/diary/imgUpload/${diary.imgName}">
					</div>
					<label>사진선택<input type="file" name="img"></label>
				</fieldset>

				<button>수정완료</button>
				<a href="${previousPage}">취소</a>
			</fieldset>
		</form>
	</section>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추억다이어리 수정페이지</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 20px;
    }
    
    section {
        width: 80%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    h1 {
        text-align: center;
        color: #333;
    }
    
    form {
        display: flex;
        flex-direction: column;
    }
    
    fieldset {
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 20px;
        margin-bottom: 20px;
    }
    
    legend {
        font-weight: bold;
        color: #333;
    }
    
    p {
        color: #666;
    }
    
    div {
        margin-bottom: 15px;
    }
    
    label {
        display: block;
        margin-bottom: 5px;
        color: #333;
    }
    
    input[type="text"], textarea, input[type="file"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }
    
    textarea {
        resize: vertical;
    }
    
    button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        margin-right: 10px;
    }
    
    button:hover {
        background-color: #0056b3;
    }
    
    a {
        text-decoration: none;
        color: #007bff;
        font-size: 16px;
    }
    
    a:hover {
        text-decoration: underline;
    }
    
    img {
        max-width: 100%;
        height: auto;
        display: block;
        margin-bottom: 10px;
    }
</style>
</head>
<body>
	<section>
		<h1>다이어리 수정</h1>
		<form method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>다이어리</legend>
				<p>주의) csv파일에 저장될거라 \n \r ,를 쓸 수 없어요..</p>
				
				<div>
					<label> 제목<input name="title" type="text" value="${diary.title}"></label>
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
				
				<button>수정완료</button>
				<a href="${previousPage}">취소</a>
			</fieldset>
		</form>
	</section>
</body>
</html>