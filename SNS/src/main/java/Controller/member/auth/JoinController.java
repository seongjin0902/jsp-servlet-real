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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String pwCheck = req.getParameter("pw-check");
        String username = req.getParameter("username");
        String phonePrefix = req.getParameter("phonePrefix"); // 콤보박스에서 선택된 번호
        String phone = req.getParameter("phone"); // 입력된 번호
        String birth = req.getParameter("birth");

        // 아이디 중복 체크
        try {
            MemberDao memberDao = MemberDaoImpl.getInstance();
            boolean isDuplicate = memberDao.checkIdDuplicate(id);
            if (isDuplicate) {
                req.setAttribute("msg", "이미 사용 중인 아이디입니다.");
                req.getRequestDispatcher("/join.jsp").forward(req, resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "오류가 발생하여 회원 가입에 실패했습니다.");
            req.getRequestDispatcher("/join.jsp").forward(req, resp);
            return;
        }

        if (!pw.equals(pwCheck)) {
            req.setAttribute("msg", "패스워드가 일치하지 않습니다.");
            req.getRequestDispatcher("/join.jsp").forward(req, resp);
            return;
        }

        // 번호 조합해서 전화번호 생성
        String fullPhoneNumber = phonePrefix + phone;
        
        // 회원 가입 처리
        MemberDto newMember = new MemberDto();
        newMember.setId(id);
        newMember.setPw(pw);
        newMember.setUsername(username);
        newMember.setPhone(fullPhoneNumber); // 조합한 전화번호를 넣어줍니다.
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
                req.getRequestDispatcher("/join.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "오류가 발생하여 회원 가입에 실패했습니다.");
            req.getRequestDispatcher("/join.jsp").forward(req, resp);
        }
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        // TODO Auto-generated method stub

    }
}
