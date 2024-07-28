package teamPrj.diary.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import teamPrj.diary.service.DiaryService;

@WebServlet("/diary/delete")
public class DeleteController extends HttpServlet{
	
	private DiaryService service;

	public DeleteController() {
		service = new DiaryService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));		
		String imgRealPath = req.getServletContext().getRealPath("/diary/imgUpload");
		
		service.deleteDiary(id, imgRealPath);
		
		String path = req.getContextPath() + "/diary/board";
		resp.sendRedirect(path);
	}
}
