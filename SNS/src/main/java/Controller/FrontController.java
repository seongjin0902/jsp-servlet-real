package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.board.BoardAddController;
import Controller.board.BoardDeleteController;
import Controller.board.BoardSearchController;
import Controller.board.BoardUpdateController;
import Controller.member.MemberAddController;
import Controller.member.MemberDeleteController;
import Controller.member.MemberPageController;
import Controller.member.MemberSearchController;
import Controller.member.MemberUpdateController;
import Controller.member.auth.JoinController;
import Controller.member.auth.LoginController;
import Controller.member.auth.LogoutController;

public class FrontController extends HttpServlet {

	private Map<String, SubController> map = new HashMap();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String projectPath = config.getServletContext().getContextPath();
//		board
		map.put(projectPath + "/board/search.do", new BoardSearchController());
		map.put(projectPath + "/board/delete.do", new BoardDeleteController());
		map.put(projectPath + "/board/add.do", new BoardAddController());
		map.put(projectPath + "/board/update.do", new BoardUpdateController());

//		member
		map.put(projectPath + "/member/search.do", new MemberSearchController());
		map.put(projectPath + "/member/delete.do", new MemberDeleteController());
		map.put(projectPath + "/member/add.do", new MemberAddController());
		map.put(projectPath + "/member/update.do", new MemberUpdateController());

//		member.auth
		map.put(projectPath + "/login.do", new LoginController());
		map.put(projectPath + "/logout.do", new LogoutController());
		
		 // Mypage
        map.put(projectPath + "/mypage.do", new MemberPageController());

//		main
		map.put(projectPath + "/main.do", new MainController());
		
		//Join
        map.put(projectPath + "/register.do", new JoinController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FrontController's service Uri : " + req.getRequestURI());//

		SubController controller = map.get(req.getRequestURI());
		controller.execute(req, resp);
	}

}