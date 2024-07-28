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
import teamPrj.diary.service.DiaryService;

@WebServlet("/diary/reg")
@MultipartConfig(maxFileSize = 20 * 1024 * 1024, maxRequestSize = 200 * 1024 *1024)
public class RegController extends HttpServlet {
	
	private DiaryService service;

	public RegController() {
		service = new DiaryService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 이전페이지 url
		String referer = req.getHeader("Referer");
		if (referer == null)
			referer = "http://localhost:8080/codeJourney/diary/board";
		
        req.setAttribute("previousPage", referer);
		req.getRequestDispatcher("/WEB-INF/view/diary/reg.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Part> parts = new ArrayList<>(req.getParts());		
		
		String imgRealPath = req.getServletContext().getRealPath("/diary/imgUpload");
		
		int id = service.uploadDiary(parts, imgRealPath);
		String diaryDetailPath = req.getContextPath() + "/diary/detail?id=" + id; 
		resp.sendRedirect(diaryDetailPath);
	}
}
