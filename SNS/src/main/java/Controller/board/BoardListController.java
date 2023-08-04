package Controller.board;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dao.BoardDao;
import Domain.Common.Dao.BoardDaoImpl;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardListController extends HttpServlet implements SubController{
	
	private BoardService service = BoardServiceImpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("보드리스트 익스큐트임");
		
		if (req.getMethod().equals("GET")) {
			System.out.println("보트리스트에 있는 GET요청 받았어요.");
			//BoardDao 객체 생성
//		BoardDao boardDao = BoardDaoImpl.getInstance();
		
		try {
			// 게시물 목록 조회
			List<BoardDto> boardList = service.getAllBoard();
			System.out.println(boardList);
			
			// 조회한 게시물 목록을 JSP로 전달
			req.setAttribute("boardList", boardList);
			
			// JSP로 포워딩
			req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
