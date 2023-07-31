package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.BoardDto;

public interface BoardDao {

	// CURD
	// 글 작성
	int insert(BoardDto dto) throws Exception;

	// 전체글 조회
	List<BoardDto> select() throws Exception;

	// 글 하나 조회(number로 조회)
	BoardDto select_one(int number) throws Exception;

	// id 나 title로 글 조회
	List<BoardDto> search_id(String id) throws Exception;

	List<BoardDto> search_title(String title) throws Exception;

	// 내가 쓴 글 조회
	List<BoardDto> search_mine(String id) throws Exception;

	// 내가 쓴 글 수정
	int update(BoardDto dto) throws Exception;

	// 내가 쓴 글 삭제
	int delete(String id) throws Exception;

}