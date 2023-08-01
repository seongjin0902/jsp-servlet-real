package Controller.member.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoImpl;
import Domain.Common.Dto.MemberDto;

@WebServlet("/editMember")
public class EditMemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        // 회원 정보를 데이터베이스에서 조회하는 로직
        MemberDao memberDao = new MemberDaoImpl();
        try {
            MemberDto member = memberDao.select(id);

            // 회원 정보를 request에 저장하여 뷰로 전달
            request.setAttribute("member", member);
            request.getRequestDispatcher("editMember.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("pw");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phone");
        String birthdate = request.getParameter("birth");

        // 회원 정보를 생성하여 데이터베이스에 수정하는 로직
        MemberDto updatedMember = new MemberDto();
        updatedMember.setId(id);
        updatedMember.setPw(password);
        updatedMember.setUsername(name);
        updatedMember.setPhone(phoneNumber);
        updatedMember.setBirth(birthdate);

        MemberDao memberDao = new MemberDaoImpl();
        try {
            int result = memberDao.update(updatedMember);

            if (result == 1) {
                // 수정 완료 후, 수정된 회원 정보를 다시 조회해서 뷰로 전달
                MemberDto updatedMemberInfo = memberDao.select(id);
                request.setAttribute("member", updatedMemberInfo);
                request.getRequestDispatcher("editMember.jsp").forward(request, response);
            } else {
                // 수정 실패 시 에러 페이지로 리다이렉트
                response.sendRedirect("/mypage.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/mypage.jsp");
        }
    }
}
