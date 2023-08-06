package Domain.Common.Service;

import java.util.List;
import java.util.Map;

import Domain.Common.Dao.BoardDao;
import Domain.Common.Dao.BoardDaoImpl;
import Domain.Common.Dao.CommentDao;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Dto.CommentDto;
import Domain.Common.Service.Auth.Session;

public class BoardServiceImpl implements BoardService{

	private BoardDao Bdao;
	private CommentDao Cdao;

	// 싱글톤
	public static BoardService instance;

	public static BoardService getInstance() {
		if (instance == null)
			instance = (BoardService) new BoardServiceImpl();
		return instance;
	}

	private MemberServiceImpl memberService;

	private BoardServiceImpl() {
		Bdao = BoardDaoImpl.getInstance();
		memberService = MemberServiceImpl.getInstance();
	}

	// 글 모두 조회하기(비회원,회원,관리자 모두)
	public List<BoardDto> getAllBoard() throws Exception {
		System.out.println("BoardService's getAllBoard()");
		return Bdao.select();
	}

	// 글 하나 조회
	public BoardDto getBoard(int number) throws Exception {
		System.out.println("BoardService's getBoard()");
		return Bdao.select_one(number);
	}

	// 내가 쓴 글 조회
	public List<BoardDto> boardsearch_mine(String id) throws Exception {
		System.out.println("BoardService's boardsearch_mine()");

		return Bdao.search_mine(id);
	}

	// 글 id로 조회
	public List<BoardDto> boardsearch_id(String id) throws Exception {
		System.out.println("BoardService's boardsearch()");
		return Bdao.search_id(id);
	}

	// 글 title로 조회
	public List<BoardDto> boardsearch_title(String title) throws Exception {
		System.out.println("BoardService's boardsearch_title()");

		return Bdao.search_title(title);
	}

	// 글 등록하기(회원)
	public boolean boardAdd(BoardDto dto) throws Exception {
		System.out.println("BoardService's boardAdd()");

		// 멤버서비스에서 role(권한-회원인지아닌지) 정보를 가져옴
		Map<String, Object> results = memberService.login("id", "pw");
		String role = (String) results.get("result");

		if (role.equals("MEMBER")) {
			int result = Bdao.insert(dto, role);
			if (result > 0)
				return true;
		}

		return false;
	}

	// 글 수정하기
	public boolean boardUpdate(BoardDto dto, String sid, int number) throws Exception {
		System.out.println("BoardService's boardupdate()");

		// 멤버서비스에서 role(권한-회원인지아닌지) 정보를 가져옴
		String role = memberService.getRole(sid);
		Session session = (Session) memberService.sessionMap.get(sid);

		Map<String, Object> results = memberService.login("id", "pw");

		if (session.getId().equals(dto.getId()) || role == "MASTER") {
			int result = Bdao.update(dto);
			if (result > 0)
				return true;
		}
		return false;
	}

	// 글 삭제하기
	// 이거 선생님말듣고 수정 0704 박영민 13:17
	public boolean boardDelete(String id) throws Exception {
		System.out.println("BoardService's boardDelete()");
		String role = memberService.getRole(id);
		Session session = (Session) memberService.sessionMap.get(id);
		Map<String, Object> results = memberService.login("id", "pw");

		if (session.getId().equals(id) || role == "MASTER") {
			int result = Bdao.delete(id);
			if (result > 0)
				return true;
		}
		return false;
	}

	@Override
	public boolean boardsearch_title(BoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean boardsearch_mine(BoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CommentDto> Commentselect(CommentDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Commentadd(CommentDto dto, String role) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Commentupdate(CommentDto dto, String role) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Commentdelete(String id, String role) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	// Comment Area----------------------------------------------------

//	// 댓글 조회
//	public List<CommentDto> Commentselect(CommentDto dto) throws Exception {
//		System.out.println("BoarsService's Commentselect()");
//
//		return Cdao.select();
//	}
//
//	// 댓글 작성
//	public boolean Commentadd(CommentDto dto, String role) throws Exception {
//		System.out.println("BoarsService's Commentadd()");
//
//		// 멤버서비스에서 role(권한-회원인지아닌지) 정보를 가져옴
//		Map<String, Object> results = memberService.login("id", "pw");
//		role = (String) results.get("result");
//
//		if (role.equals("MEMBER")) {
//			int result = Cdao.insert(dto, role);
//			if (result > 0)
//				return true;
//		}
//		return false;
//	}
//
//	// 댓글 수정
//	public boolean Commentupdate(CommentDto dto, String sid) throws Exception {
//		System.out.println("BoarsService's Commentupdate()");
//
//		// 멤버서비스에서 role(권한-회원인지아닌지) 정보를 가져옴
//		String role = memberService.getRole(sid);
//		Session session = (Session) memberService.sessionMap.get(sid);
//
//		// BoardDao 에서 내용꺼내옴
//
//		if (session.getId().equals(dto.getId()) || role == "MASTER") {
//			int result = Cdao.update(dto, role);
//			if (result > 0)
//				return true;
//		}
//		return false;
//	}
//
//	// 댓글 삭제
//	public boolean Commentdelete(String id, String sid) throws Exception {
//		System.out.println("BoarsService's Commentdelete()");
//
//		String role = memberService.getRole(sid);
//		Session session = (Session) memberService.sessionMap.get(sid);
//
//		if (role.equals("MASTER")) {
//			int result = Cdao.delete(dto);
//			if (result > 0)
//				return true;
//		}
//		return false;
//	}

}