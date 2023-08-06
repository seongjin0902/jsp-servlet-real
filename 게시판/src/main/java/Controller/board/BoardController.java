package Controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardController implements SubController{

	private static final BoardDto Dto = null;
	private BoardService service; // 파라미터를 보드소비스로 전달하기 위한 변수 생성

	public BoardController() {
		service = BoardServiceImpl.getInstance();
	}

	// 1 Select , 2 Insert , 3 Update , 4 Delete
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {

		if (serviceNo == 1) {// select
			// 1 파라미터 추출(생략)
			// 2 입력값 검증(생략)
			// 3 서비스 실행(서비스모듈작업 이후 처리)
			List<BoardDto> list = null;
			try {
				list = service.getAllBoard();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4 View로 전달
			System.out.println("Board_Select Block");
			Map<String, Object> result = new HashMap();
			result.put("result", list);

			return result;
		} else if (serviceNo == 2) {
			//1 파라미터 추출
			Integer number = (Integer) param.get("number");
			String id = (String) param.get("id");
			String title = (String) param.get("title");
			String contents = (String) param.get("contents");
			String date = (String) param.get("date");
			Integer hits = (Integer) param.get("hits");
			//2 입력값 검증
			if (number == null || id == null || title == null || contents == null || date == null || hits == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			//3 서비스 실행
			BoardDto dto = new BoardDto(number, id, title, contents, date, hits);
			System.out.println("Dto + " + dto);

			Boolean rValue = false;
			try {
				rValue = service.boardAdd(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//4 view로 전달
			System.out.println("Board_Insert Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 3) { // update
			//1 파라미터 추출
			Integer number = (Integer) param.get("number");
			String id = (String) param.get("id");
			String title = (String) param.get("title");
			String contents = (String) param.get("contents");
			String date = (String) param.get("date");
			Integer hits = (Integer) param.get("hits");
			//2 입력값 검증
			if (number == null || id == null || title == null || contents == null || date == null || hits == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			//3 서비스 실행
			BoardDto dto = new BoardDto(number, id, title, contents, date, hits);
			System.out.println("Dto : " + dto);
			Boolean rValue = false;

			try {
				rValue = service.boardUpdate(dto, id, number);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//4 view로 전달
			System.out.println("Board_Update Block");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 4) { // delete
			//1 파라미터 추출
			Integer number = (Integer) param.get("number");
			String id = (String) param.get("id");
			String role = (String) param.get("role");
			//2 입력값 검증
			if (number == null || id == null || role == "MEMBER") {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			//3 서비스 실행

			Boolean rValue = false;
			try {
				rValue = service.boardDelete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//4 view로 전달
			System.out.println("Board_Delete Block");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}
		return null;

	}

}