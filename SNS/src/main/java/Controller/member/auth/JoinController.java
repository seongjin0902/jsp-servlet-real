package Controller.member.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoImpl;
import Domain.Common.Dto.MemberDto;

@WebServlet("/register.do")
public class JoinController extends HttpServlet implements SubController {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String pwCheck = req.getParameter("pw-check");
        String username = req.getParameter("username"); // HTML의 input name이 "name"으로 되어 있어서 수정
        String phone = req.getParameter("phone");
        String birth = req.getParameter("birth");

        if (!pw.equals(pwCheck)) {
            req.setAttribute("msg", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            req.getRequestDispatcher("/join.jsp").forward(req, resp);
            return;
        }

        MemberDto newMember = new MemberDto();
        newMember.setId(id);
        newMember.setPw(pw);
        newMember.setUsername(username);
        newMember.setPhone(phone);
        newMember.setBirth(birth);
        newMember.setRole("MEMBER");

        try {
            MemberDao memberDao = MemberDaoImpl.getInstance();
            int result = memberDao.insert(newMember);
            if (result > 0) {
                req.setAttribute("msg", "회원 가입이 완료되었습니다.");
                req.getRequestDispatcher("/WEB-INF/view/member/auth/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", "회원 가입에 실패했습니다.");
                req.getRequestDispatcher("join.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "오류가 발생하여 회원 가입에 실패했습니다.");
            req.getRequestDispatcher("join.jsp").forward(req, resp);
        }
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO Auto-generated method stub

    }
}