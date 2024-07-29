package teamPrj.diary.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import teamPrj.diary.Entity.Diary;
import teamPrj.diary.service.DiaryService;

@WebServlet("/diary/edit")
@MultipartConfig(maxFileSize = 20 * 1024 * 1024, maxRequestSize = 200 * 1024 * 1024)
public class EditController extends HttpServlet {
	private DiaryService service;

	public EditController() {
		service = new DiaryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 수정할 게시물 id
		// 게시물 detail페이지에서 오지 않고 ?id=임의로 입력했는데 id에 해당하는 게시물이 없을 케이스 추가처리해줘야됨
		int id = 0;
		String id_ = req.getParameter("id");
		if (id_ != null)
			id = Integer.parseInt(id_);

		// <input type="file"태그에 전에 첨부한 이미지를 채워놓을 수는 없음...ㅠㅠ
		Diary diary = service.getDiary(id);

		// 이전페이지 url
		String referer = req.getHeader("Referer");
		if (referer == null)
			referer = "http://localhost:8080/codeJourney/diary/board";

		req.setAttribute("previousPage", referer);
		req.setAttribute("diary", diary);
		req.getRequestDispatcher("/WEB-INF/view/diary/edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Part> parts = new ArrayList<>(req.getParts());

		String imgRealPath = req.getServletContext().getRealPath("/diary/imgUpload");

		int id = Integer.parseInt(req.getParameter("id"));

		service.editDiary(id, parts, imgRealPath);

		String diaryDetailPath = req.getContextPath() + "/diary/detail?id=" + id;
		resp.sendRedirect(diaryDetailPath);
	}
}
