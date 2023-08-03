package Controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Service.BoardService;
import Domain.Common.Service.BoardServiceImpl;

public class BoardUpdateController implements SubController {

    private BoardService service = BoardServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BoardUpdateController execute");

        try {
            int boardNumber = Integer.parseInt(req.getParameter("boardNumber"));
            String contents = req.getParameter("contents");

            // 게시물 수정
            BoardDto board = new BoardDto();
            board.setNumber(boardNumber);
            board.setContents(contents);

            // 수정 처리
            boolean isUpdated = service.boardUpdate(board, contents, boardNumber);

            if (isUpdated) {
                // 수정이 성공하면 마이페이지로 리다이렉트
                resp.sendRedirect(req.getContextPath() + "/member/mypage.do");
            } else {
                // 수정 실패 시 에러 페이지 또는 다른 처리 방법을 선택하여 구현
                // 예: 에러 메시지를 출력하거나 다시 수정 폼으로 이동
                resp.getWriter().write("게시물 수정에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 에러 페이지 또는 다른 처리 방법을 선택하여 구현
            // 예: 에러 메시지를 출력하거나 다시 수정 폼으로 이동
            resp.getWriter().write("게시물 수정 중 오류가 발생했습니다.");
        }
    }
}
