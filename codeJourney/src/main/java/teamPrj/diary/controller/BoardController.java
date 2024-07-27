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
		int page = 1;
		String page_ = req.getParameter("p");
		
		if (page_ != null)
			page = Integer.parseInt(page_);

		List<Diary> list = service.getList(page);
		
		List<Integer> pages = service.getPages(page);
		
		int lastPage = pages.getLast();
		int prevPage = page-1;
		int nextPage = page+1;
		if (prevPage<1)
			prevPage = 1;
		if (nextPage > lastPage)
			nextPage = lastPage;
		
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		req.setAttribute("pages", pages.subList(1, pages.size()-1));
		req.setAttribute("prevPage", prevPage);
		req.setAttribute("nextPage", nextPage);
		req.setAttribute("lastPage", lastPage);
		

		req.getRequestDispatcher("/WEB-INF/view/diary/board.jsp").forward(req, resp);
	}

}
