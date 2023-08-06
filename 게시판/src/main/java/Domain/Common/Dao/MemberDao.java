
package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.MemberDto;

public interface MemberDao {

	//id 게터
	String getId();

	//	회원 id/pw 저장
	int insert(MemberDto dto) throws Exception;

	// 	회원 id/pw 조회
	List<MemberDto> select(String id, String pw) throws Exception;

	//	회원 id/pw 삭제
	int delete(String id) throws Exception;

}