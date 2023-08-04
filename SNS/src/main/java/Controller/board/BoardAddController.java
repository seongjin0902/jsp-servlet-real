package Controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardAddController implements SubController {

	BoardService service = BoardServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("BoardAddController execute");

		// GET 요청 처리
		if (req.getMethod().equals("GET")) {
			try {
				System.out.println("get req들어옴");
				req.getRequestDispatcher("/WEB-INF/view/write.jsp").forward(req, resp);
				return;
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		// -------------------------------------------------------------------
		// -------------------------------------------------------------------
		// post 요청 처리
		if (req.getMethod().equals("POST")) {
			
			String contents = req.getParameter("contents");
			String userId = (String) req.getSession().getAttribute("userId");
			
			System.out.println("BoardAddController paramtes : " + contents + userId);
			
			try {
				// 2 입력값 검증
				if (contents == null || contents.isEmpty()) {
					System.out.println("[ERROR] Data Validation Check Error!");
					req.setAttribute("msg", "[ERROR] 내용을 입력해주세요.");
					req.getRequestDispatcher("/WEB-INF/view/write.jsp").forward(req, resp);
					return;
				}
				


				// BoardDto 객체 생성하여 title과 contents를 담음
				BoardDto dto = new BoardDto();
				dto.setContents(contents);
				 dto.setId(userId);
				System.out.println(contents);
				System.out.println(userId);

				// 3 서비스 실행 - BoardService를 활용하여 데이터 삽입
				int isInserted = service.boardAdd(dto);

				if (isInserted > 0) {
					// 게시물 등록 성공 시 메인 페이지로 이동 - Redirect
//					req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
					resp.sendRedirect(req.getContextPath()+"/list.do");
				} else {
					// 게시물 등록 실패 시 오류 메시지와 함께 글 작성 페이지로 이동 - Forward
					req.setAttribute("msg", "게시물 등록에 실패했습니다.");
					req.getRequestDispatcher("/WEB-INF/view/write.jsp").forward(req, resp);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}