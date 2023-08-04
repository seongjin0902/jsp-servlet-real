package Controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

//@WebServlet("/board/delete.do")
@SuppressWarnings("serial")
public class BoardDeleteController extends HttpServlet implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BoardDeleteController execute");
		System.out.println("글좀 삭제할게요......씨...부랄");
		String id = req.getParameter("id");
		try {

			BoardService service = BoardServiceImpl.getInstance();
			boolean result = service.boardDelete(id);

			if (result) {
				req.setAttribute("Success", "해당글이 삭제되었습니다.");

			} else {
				req.setAttribute("Warning", "글 삭제 권한이 없습니다.");
			}
			req.getRequestDispatcher("/mypage.do").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("Fail", "시도하신 요청이 실패하였습니다.");
			req.getRequestDispatcher("/mypage.do").forward(req, resp);
		}
	}

}