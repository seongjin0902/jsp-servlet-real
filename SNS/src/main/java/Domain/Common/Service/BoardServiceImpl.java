package Domain.Common.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dao.BoardDao;
import Domain.Common.Dao.BoardDaoImpl;
import Domain.Common.Dto.BoardDto;

public class BoardServiceImpl implements BoardService {

	
	
	private BoardDao dao;

	//싱글톤
	private static BoardService instance;
	public static BoardService getInstance() {
		if(instance==null)
			instance = new BoardServiceImpl();
		return instance;
	}
	//
	
	//
	private MemberService memberService;
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
		memberService = MemberServiceImpl.getInstance();
	}

	// 도서조회하기(비회원/회원/사서)
	@Override
	public List<BoardDto> getAllBook(HttpServletRequest req) throws Exception {
		System.out.println("BookService's getAllBook()");
		
		List<BoardDto> result = (List<BoardDto>)dao.select();

		return result;
	}
	
	@Override
	public BoardDto getBook(int bookcode) throws Exception {
		System.out.println("BookService's getBook()");
		return dao.select(bookcode);
	}
	
	
	// 도서등록하기(사서)
	@Override
	public boolean addBook(BoardDto dto, String sid) throws Exception {
		System.out.println("BookService's addBook()");
		
//		String role = memberService.getRole(sid);
		
//		if (role.equals("ROLE_MEMBER")) {
//			int result = dao.insert(dto);
//			if (result > 0)
//				return true;
//		}

		return false;
	}

	// 도서수정하기
	@Override
	public boolean updateBook(BoardDto dto, String sid) throws Exception {
		
//		System.out.println("BookService's updateBook()");
//		String role = memberService.getRole(sid);
//		
//		if (role.equals("ROLE_MEMBER")) {
//			int result = dao.update(dto);
//			if (result > 0)
//				return true;
//		}

		return false;
	}

	// 도서삭제하기
	@Override
	public boolean removeBook(int bookcode, String sid) throws Exception {
		System.out.println("BookService's removeBook()");
		
//		String role = memberService.getRole(sid);
//		
//		if (role.equals("ROLE_MEMBER")) {
//			int result = dao.delete(bookcode);
//			if (result > 0)
//				return true;
//		}
		return false;
	}
}
