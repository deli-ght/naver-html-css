package kr.or.connect.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;

/**
 * Servlet implementation class todoAdd
 */
@WebServlet("/todoAdd")
public class todoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	TodoDao dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public todoAdd() {
        super();
        dao = new TodoDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		
		dao.insertTodo(title, name, sequence);

		response.sendRedirect("MainServlet");
	}

}
