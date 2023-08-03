package Controller;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message.do")
public class messageController extends HttpServlet implements Serializable{
	
	  // 직렬화를 위한 serialVersionUID 선언
    private static final long serialVersionUID = 1L;
	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // JSP 파일 경로 설정
	        String jspPath = "/WEB-INF/view/sendMessage.jsp";

	        // JSP 파일을 포함시킴
	        getServletContext().getRequestDispatcher(jspPath).forward(request, response);
	    }
	

}
