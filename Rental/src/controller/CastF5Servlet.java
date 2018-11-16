package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CastBeans;
import dao.CastDao;

/**
 * Servlet implementation class CastF5Servlet
 */
@WebServlet("/CastF5Servlet")
public class CastF5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CastF5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインセッションがない場合、ログイン画面にリダイレクトさせる
		HttpSession session = request.getSession();
		if (null == session.getAttribute("userInfo")){
			// ログイン画面へ遷移(リダイレクト).
			response.sendRedirect( "LoginServlet" );
			return;
			}

		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");

		// 確認用：idをコンソールに出力
	       System.out.println(id);


		//idを引数にして、idに紐づくユーザ情報を出力する
	       CastDao castDao = new CastDao();
		   CastBeans castdata = castDao.castData(id);

		   // ユーザ情報をリクエストスコープにセットしてjspにフォワード
		   request.setAttribute("castdata",castdata);



			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/castf5.jsp");
			dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       // リクエストパラメータの文字コードを指定
  request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String castName = request.getParameter("castName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String bake = request.getParameter("bake");
		String comment = request.getParameter("comment");
		int price = Integer.parseInt(request.getParameter("price"));
		String loginId = request.getParameter("loginId");


		if(castName.isEmpty() || age == 0 || gender.isEmpty() || bake.isEmpty() || comment.isEmpty() || price == 0)
  {
			request.setAttribute("errMsg", "必須項目を入力してください");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/castf5.jsp");
			dispatcher.forward(request, response);
			return;
  }


		CastDao castDao = new CastDao();


		try {
			castDao.CastF5(castName,age,gender,bake,comment,price,loginId);
		} catch (SQLException e) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/castf5.jsp");
			dispatcher.forward(request, response);
			return;
		}
		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("CastListServlet");

	}

}
