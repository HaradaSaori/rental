package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordCon = request.getParameter("passwordCon");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");


		if(!(password.equals(passwordCon) )){
			request.setAttribute("errMsg", "パスワードが一致していません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if(loginId.isEmpty() || password.isEmpty() || passwordCon.isEmpty() || userName.isEmpty() || phone.isEmpty())
        {
			request.setAttribute("errMsg", "必須項目を入力してください");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
			dispatcher.forward(request, response);
			return;
        }


		UserDao userDao = new UserDao();


		try {
			userDao.newUserDate(loginId,password,userName,phone);
		} catch (SQLException e) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");


	}


}
