package teamPrj.diary.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teamPrj.diary.Entity.Diary;
import teamPrj.diary.service.DiaryService;

@WebServlet("/diary/board")
public class BoardController extends HttpServlet {
	private DiaryService service;

	public BoardController() {
		service = new DiaryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Diary> list = service.getList();

		req.setAttribute("list", list);

		req.getRequestDispatcher("/WEB-INF/view/diary/board.jsp").forward(req, resp);
	}

}
