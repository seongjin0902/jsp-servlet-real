package Domain.Common.Dao;

import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.BoardDto;
 

public class BoardDaoImpl extends ConnectionPool implements BoardDao {
	
	//싱글톤 패턴
	private static BoardDao instance; 
	public static BoardDao getInstance() {
		if(instance==null)
			instance=new BoardDaoImpl();
		return instance;
	}
	//
	
	private BoardDaoImpl(){
		
	}
	
	
	//CRUD
	@Override
	public int insert(BoardDto dto) throws Exception{
	 
		pstmt=conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
		pstmt.setInt(1, dto.getBookcode());
		pstmt.setString(2, dto.getBookname());
		pstmt.setString(3,dto.getPublisher());
		pstmt.setString(4, dto.getIsbn());
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
		
	}
	
	@Override
	public List<BoardDto> select() throws Exception{
		List<BoardDto> list = new ArrayList();
		BoardDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_book");
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next()) {
				dto=new BoardDto();
				dto.setBookcode(rs.getInt("bookcode"));
				dto.setBookname(rs.getString("bookname"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			}
			rs.close();
		}
		pstmt.close();
			
		return list;
	}
	@Override
	public BoardDto select(int bookcode) throws Exception{
		 
		BoardDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_book where bookcode=?");
		pstmt.setInt(1, bookcode);
		rs=pstmt.executeQuery();
		if(rs!=null&& rs.isBeforeFirst())
		{
				rs.next();
				dto=new BoardDto();
				dto.setBookcode(rs.getInt("bookcode"));
				dto.setBookname(rs.getString("bookname"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				 		
				rs.close();
		}
		pstmt.close();
		return dto;
	}	
	
	
	@Override
	public List<BoardDto> select(String keyword){
		return null;
	}
	@Override
	public List<BoardDto> select(String keyfield,String keyword){
		return null;
	}
	@Override
	public int update(BoardDto dto) throws Exception{
		pstmt=conn.prepareStatement("update tbl_book set bookname=?,publisher=?,isbn=? where bookcode=?");
		pstmt.setString(1,dto.getBookname() );
		pstmt.setString(2,dto.getPublisher() );
		pstmt.setString(3,dto.getIsbn());
		pstmt.setInt(4,dto.getBookcode() );
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	@Override
	public int delete(int bookcode)  throws Exception{
		 
		pstmt=conn.prepareStatement("delete from tbl_book where bookcode=?");
		pstmt.setInt(1, bookcode);
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	
	
	
	
}
