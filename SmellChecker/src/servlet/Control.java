package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/Start.jsp");
		dispatch.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(request.getContextPath());
		System.out.println(request.getPathInfo());
		System.out.println(request.getServletPath());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRequestURL());
		System.out.println("-------------");

		String state = request.getParameter("btn");

		System.out.println("state=" + state);
		System.out.println(request.getParameter("ItemId"));
		if (state.equals("state1") ) {

			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/Question.jsp");
			dispatch.forward(request, response);

		}

		if (state.equals("state2")) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/Result.jsp");
			dispatch.forward(request, response);
		}


		doGet(request, response);
	}

}
