package Domain.Common.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dto.BoardDto;

public interface BoardService {

	// 도서조회하기(비회원/회원/사서)
	List<BoardDto> getAllBook(HttpServletRequest req) throws Exception;

	BoardDto getBook(int bookcode) throws Exception;

	// 도서등록하기(사서)
	boolean addBook(BoardDto dto, String sid) throws Exception;

	// 도서수정하기
	boolean updateBook(BoardDto dto, String sid) throws Exception;

	// 도서삭제하기
	boolean removeBook(int bookcode, String sid) throws Exception;

}