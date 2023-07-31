package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.BoardDto;

public interface BoardDao {

	//CRUD
	int insert(BoardDto dto) throws Exception;

	List<BoardDto> select() throws Exception;

	BoardDto select(int bookcode) throws Exception;

	List<BoardDto> select(String keyword);

	List<BoardDto> select(String keyfield, String keyword);

	int update(BoardDto dto) throws Exception;

	int delete(int bookcode) throws Exception;

}