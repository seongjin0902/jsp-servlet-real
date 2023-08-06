package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;

public class MemberPageController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			HttpSession session = req.getSession();
			String role = (String)session.getAttribute("ROLE");
			if(role.equals("ROLE_USER")){
				req.getRequestDispatcher("/WEB-INF/view/member/user.jsp").forward(req, resp);
			}else if(role.equals("ROLE_MEMBER")) {
				req.getRequestDispatcher("/WEB-INF/view/member/member.jsp").forward(req, resp);

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}