package Domain.Common.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoImpl;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.Auth.Session;

public class MemberServiceImpl implements MemberService {

	public Map<String, Object> sessionMap;

	private MemberDao dao;

	private static MemberServiceImpl instance;

	public static MemberServiceImpl getInstance() {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
		sessionMap = new HashMap();
	}

//	회원 가입하기
	@Override
	public boolean memberJoin(MemberDto dto) throws Exception {
		int result = dao.insert(dto);
		if (result > 0)
			return true;
		return false;
	}

//	회원 조회(전체) - 관리자
	@Override
	public List<MemberDto> memberSearch(String role) throws Exception {
		if (role.equals("MASTER"))
			return dao.select("id", "pw");
		return null;
	}

//	회원 삭제하기
	@Override
	public boolean memberDelete(String id, String role) throws Exception {
		Session session = (Session) sessionMap.get(role);
		if (role == "MASTER" || session.getId().equals(id)) {
			int result = dao.delete(id);
			if (result > 0)
				return true;
		}
		return false;

	}

//	로그인
	@Override
	public boolean login(HttpServletRequest req) throws Exception {
		
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		
//		1 ID/PW 체크 ->Dao 전달받은 id와 일치하는 정보를 가져와서 Pw일치 확인
		MemberDto dto = (MemberDto) dao.select(id, pw);
		if (dto == null) {
			req.setAttribute("msg", "[ERROR] Login Fail... 아이디가 일치하지 않습니다");
			return false;
		}

		if (!pw.equals(dto.getPw())) {
			req.setAttribute("msg", "[ERROR] Login Fail... 패스워드가 일치하지 않습니다");
			return false;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("ID", id);
		session.setAttribute("ROLE", dto.getRole());
		
		return true;
	}

//	로그아웃
	@Override
	public boolean logout(String id, String pw, String role) {

		Session session = (Session) sessionMap.get(role);
		if (id == null || pw == null) {
			System.out.println("[ERROR");
			return false;
		}
		sessionMap.remove(role);
		return true;
	}


//	역할 반환 함수(회원인지 관리자인지)
	@Override
	public String getRole(String role) {
		Session session = (Session) sessionMap.get(role);
		if (session.equals("MASTER")) {
			return session.getRole();
		}

		return null;
	}

}