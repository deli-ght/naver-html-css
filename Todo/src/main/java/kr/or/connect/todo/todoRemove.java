package kr.or.connect.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;

/**
 * Servlet implementation class todoRemove
 */
@WebServlet("/todoRemove")
public class todoRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TodoDao dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public todoRemove() {
        super();
        dao = new TodoDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dao.removeAll();
		
		response.sendRedirect("MainServlet");
	}



}
