package kr.or.connect.todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;

/**
 * Servlet implementation class javaType
 */
@WebServlet("/javaType")
public class javaType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	TodoDao dao = null;

	public javaType() {
		super();
		dao = new TodoDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("type");

		if (type.equals("TODO"))
			type = "DOING";
		else if (type.equals("DOING"))
			type = "DONE";

		dao.updateTodo(id, type);
		
		PrintWriter out = resp.getWriter();
		out.print("success");
		out.close();
	}

}
