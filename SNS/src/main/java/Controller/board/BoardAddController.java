package Controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceImpl;

public class BoardAddController implements SubController {

	private BoardService service = BoardServiceImpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("BookAddController execute");

		// GET 요청 처리
		if (req.getMethod().equals("GET")) {
			try {
				System.out.println("get req들어옴");
				req.getRequestDispatcher("/WEB-INF/view/board/add.jsp").forward(req, resp);
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
		System.out.println("");
		// post 요청 처리
		String title = (String) req.getParameter("title");
		String contents = (String) req.getParameter("contents");
		System.out.println("BoardAddController paramtes : " + title + " " + contents);

		try {
			// 2 입력값 검증
			if (title.isEmpty() || contents.isEmpty()) {
				System.out.println("[ERROR] Data Validation Check Error!");
				req.setAttribute("msg", "[ERROR] 제목이나 내용을 입력해주세요.");
				req.getRequestDispatcher("/add.jsp").forward(req, resp);
				return;
			}

			 // BoardDto 객체 생성하여 title과 contents를 담음
	        BoardDto dto = new BoardDto();
	        dto.setTitle(title);
	        dto.setContents(contents);
	        System.out.println(title+" "+contents);

	        // 3 서비스 실행 - BoardService를 활용하여 데이터 삽입
	        int isInserted = service.boardAdd(dto);

	        if (isInserted>0) {
	            // 게시물 등록 성공 시 메인 페이지로 이동 - Redirect
	            resp.sendRedirect(req.getContextPath() + "/main.jsp");
	        } else {
	            // 게시물 등록 실패 시 오류 메시지와 함께 글 작성 페이지로 이동 - Forward
	            req.setAttribute("msg", "게시물 등록에 실패했습니다.");
	            req.getRequestDispatcher("/add.jsp").forward(req, resp);
	        }

		} catch (Exception e) {
            e.printStackTrace();
		}
	}

}