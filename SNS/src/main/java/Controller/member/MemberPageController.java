package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Common.Dto.MemberDto;

public class MemberPageController implements SubController {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        MemberDto member = (MemberDto) session.getAttribute("LOGGED_IN_USER");

        if (member != null) {
            req.setAttribute("member", member);
            // mypage.jsp로 포워드합니다.
            try {
                req.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 로그인하지 않은 경우를 처리합니다.
            // 로그인 페이지로 리다이렉트하거나 오류 메시지를 표시할 수 있습니다.
            // 간단하게 로그인 페이지로 리다이렉트하겠습니다.
            try {
                resp.sendRedirect("login.do");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
