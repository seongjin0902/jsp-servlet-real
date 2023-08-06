package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.CommentDto;

public interface CommentDao {

	//	댓글 조회
	List<CommentDto> select() throws Exception;

	//	댓글 작성 
	int insert(CommentDto dto, String role) throws Exception;

	//	댓글 수정
	int update(CommentDto dto) throws Exception;

	//	댓글 삭제
	int delete(String id) throws Exception;

}