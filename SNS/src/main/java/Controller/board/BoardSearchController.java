package Controller.board;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardSearchController implements SubController {

	private BoardService service = BoardServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("BookSearchController execute");
		// 1 파라미터 추출(keyfield,keyword,criteria)
		String keyword = req.getParameter("keyword");
		// 2 입력값 검증(생략)
		System.out.println(keyword);
		
		// 3 서비스 실행(서비스모듈작업 이후 처리)
		List<BoardDto> list = null;
		try {
			// 서비스를 호출하여 디비에서 게시물 조회
			list = service.boardsearch_id(keyword);
			System.out.println("list"+list);
			
			if (list != null && !list.isEmpty()) {
				// 검색 결과가 존재하는 경우: 검색된 게시물을 뷰로 전달
				req.setAttribute("searchResult", list);
			} else {
				// 검색 결과가 없는 경우: "조회된 게시물이 없습니다" 메시지를 뷰로 전달
				req.setAttribute("searchMessage", "조회된 게시물이 없습니다.");
			}
			
			req.getRequestDispatcher("/tmplate.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}