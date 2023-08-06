package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dto.BoardDto;
import Domain.Common.Dto.CommentDto;

public interface BoardService {

	// 글 모두 조회하기(비회원,회원,관리자 모두)
	List<BoardDto> getAllBoard() throws Exception;

	// 글 하나 조회
	BoardDto getBoard(int number) throws Exception;

	// 글 등록하기(회원)
	boolean boardAdd(BoardDto dto) throws Exception;

	// 글 수정하기
	boolean boardUpdate(BoardDto dto, String sid, int number) throws Exception;

	//글 삭제하기
	// 이거 선생님말듣고 수정   0704 박영민 13:17
	boolean boardDelete(String id) throws Exception;

	//글 id로 조회
	List<BoardDto> boardsearch_id(String id) throws Exception;

	//글 title로 조회
	boolean boardsearch_title(BoardDto dto) throws Exception;

	//내가 쓴 글 조회
	boolean boardsearch_mine(BoardDto dto) throws Exception;

	//댓글 조회
	List<CommentDto> Commentselect(CommentDto dto) throws Exception;

	//댓글 작성
	boolean Commentadd(CommentDto dto, String role) throws Exception;

	//댓글 수정
	boolean Commentupdate(CommentDto dto, String role) throws Exception;

	//댓글 삭제
	boolean Commentdelete(String id, String role) throws Exception;

}