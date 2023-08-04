package Domain.Common.Dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Common.Dto.BoardDto;

public class BoardDaoImpl extends ConnectionPool implements BoardDao {

	// 싱글톤 패턴
	private static BoardDao instance;

	public static BoardDao getInstance() {
		if (instance == null)
			instance = new BoardDaoImpl();
		return instance;
	}

	private BoardDaoImpl() {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 사용자 ID 값 가져오기
	    String userId = request.getParameter("userId");

	    // 기타 폼 데이터 가져오기
	    String contents = request.getParameter("contents");
	}

//		CURD
//	글 작성
	@Override
	public int insert(BoardDto dto) throws Exception {
		
		System.out.println("보드Dao 인서트로 들어왔슴다!!!");
		pstmt = conn.prepareStatement("insert into tbl_board values (null,?,?,now(),0,0)");

		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getContents());

		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}

//	전체글 조회
	@Override
	public List<BoardDto> select() throws Exception {
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board");
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				dto = new BoardDto();
				dto.setNumber(rs.getInt("number"));
				dto.setId(rs.getString("id"));
				dto.setContents(rs.getString("contents"));
				dto.setDate(rs.getString("date"));
				dto.setHits(rs.getInt("hits"));
				dto.setLike(rs.getInt("like"));
				list.add(dto);
			}
		}
		return list;
	}

	// 글 하나 조회(number로 조회)
	@Override
	public BoardDto select_one(int number) throws Exception {

		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board where number = ?");
		pstmt.setInt(1, number);
		rs = pstmt.executeQuery();
		if (rs != null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return dto;
	}

//	id 나 title로 글 조회
	@Override
	public List<BoardDto> search_id(String id) throws Exception {
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs != null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}

	@Override
	public List<BoardDto> search_title(String title) throws Exception {
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board where title = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs != null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}

//	내가 쓴 글 조회
	@Override
	public List<BoardDto> search_mine(String id) throws Exception {
		System.out.println("id:" + id);
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_board where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setContents(rs.getString("contents"));
			dto.setDate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			dto.setLike(rs.getInt("like"));
			list.add(dto);
		}
		rs.close();
		System.out.println(list);
		pstmt.close();
		return list;
	}

//	내가 쓴 글 수정
	@Override
	public int update(BoardDto dto) throws Exception {
		pstmt = conn.prepareStatement("update tbl_board set contents=? where number=? ");
		pstmt.setString(1, dto.getContents());
		pstmt.setInt(2, dto.getNumber());

		return pstmt.executeUpdate();
	}

//	내가 쓴 글 삭제
	@Override
	public int delete(String id) throws Exception {
		pstmt = conn.prepareStatement("delete from tbl_board where id = ?");
		pstmt.setString(1, id);
		int result = pstmt.executeUpdate();
		pstmt.close();

		return result;
	}

}