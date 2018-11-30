package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReviewBeans;
import dao.ReviewDao;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet("/ReviewDeleteServlet")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteServlet() {
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
	       ReviewDao reviewDao = new ReviewDao();
		   ReviewBeans reviewdata = reviewDao.reviewData(Integer.parseInt(id));

		   // ユーザ情報をリクエストスコープにセットしてjspにフォワード
		   request.setAttribute("reviewdata",reviewdata);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reviewdelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String revId = request.getParameter("revId");

		ReviewDao reviewDao = new ReviewDao();
		reviewDao.Revdelete(Integer.parseInt(revId));

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("CastListServlet");
	}

}
