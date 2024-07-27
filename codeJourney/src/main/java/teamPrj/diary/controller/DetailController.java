package teamPrj.diary.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teamPrj.diary.Entity.Diary;
import teamPrj.diary.service.DiaryService;

@WebServlet("/diary/detail")
public class DetailController extends HttpServlet {

	private DiaryService service;

	public DetailController() {
		service = new DiaryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id_ = req.getParameter("id");
		int id = service.getLatestId();
		if (id_ != null)
			id = Integer.parseInt(id_);

		Diary diary = service.getDiary(id);

		// 이전페이지 url
		String referer = req.getHeader("Referer");
		if (referer == null)
			referer = "http://localhost:8080/codeJourney/diary/board";
		else if (!referer.startsWith("http://localhost:8080/codeJourney/diary/board"))
			referer = "http://localhost:8080/codeJourney/diary/board";
		
		req.setAttribute("previousPage", referer);

		req.setAttribute("diary", diary);

		req.getRequestDispatcher("/WEB-INF/view/diary/detail.jsp").forward(req, resp);
	}
}
