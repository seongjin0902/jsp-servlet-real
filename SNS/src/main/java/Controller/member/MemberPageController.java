package Controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class MemberPageController implements SubController {
	private BoardService service = BoardServiceImpl.getInstance();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("memberpagecontroller 실행할거임");
		System.out.println("execute로 들어옴");
		try {
			HttpSession session = req.getSession();
			String role = (String) session.getAttribute("ROLE");
			System.out.println("session: " + role);
			if (role.equals("ROLE_USER")) {
				req.getRequestDispatcher("/WEB-INF/view/member/user.jsp").forward(req, resp);
				return ;
			} else if (role.equals("MEMBER")) {

				// 회원 아이디 가져오기 
				// 이게 문제다 유진아
				String memberId = (String) session.getAttribute("ID");
				System.out.println("memberid : " + memberId);
				// 회원의 작성 게시물 데이터 가져오기
				List<BoardDto> posts = service.boardsearch_mine(memberId);
				System.out.println("posts: " +posts);

				// 게시물 데이터를 request에 저장하여 JSP로 전달
				req.setAttribute("posts", posts);
				req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;

	}

}