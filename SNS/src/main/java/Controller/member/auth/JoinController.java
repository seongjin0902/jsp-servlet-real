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
    	
    	// JSP 파일 경로 설정
        String jspPath = "/join.jsp";
        
        
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String pwCheck = req.getParameter("pw-check");
        String username = req.getParameter("username"); // HTML의 input name이 "name"으로 되어 있어서 수정
        String phonePrefix = req.getParameter("phonePrefix"); // 콤보박스에서 선택된 번호
        String phone = req.getParameter("phone");
        String birth = req.getParameter("birth");

        if (!pw.equals(pwCheck)) {
            req.setAttribute("msg", "패스워드를 잘 확인해보십시오.");
            req.getRequestDispatcher("/join.jsp").forward(req, resp);
            return;
        }
        
     // 번호 조합해서 전화번호 생성
        String fullPhoneNumber = phonePrefix + phone;

        MemberDto newMember = new MemberDto();
        newMember.setId(id);
        newMember.setPw(pw);
        newMember.setUsername(username);
        newMember.setPhone(fullPhoneNumber); // 조합한 전화번호를 넣어줍니다
        newMember.setBirth(birth);
        newMember.setRole("MEMBER");

        try {
            MemberDao memberDao = MemberDaoImpl.getInstance();
            int result = memberDao.insert(newMember);
            if (result > 0) {
                req.setAttribute("msg", "회원 가입이 완료되었습니다.");
                req.getRequestDispatcher("/join.jsp").forward(req, resp);
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