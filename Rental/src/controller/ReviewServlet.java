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
import dao.ReviewDao;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
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
			response.sendRedirect( "IndexServlet" );
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

		// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
				dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       // リクエストパラメータの文字コードを指定
	     request.setCharacterEncoding("UTF-8");

			// リクエストパラメータの入力項目を取得
			String castId = request.getParameter("castId");
			String userId = request.getParameter("userId");
			String revC = request.getParameter("revC");



			ReviewDao reviewDao = new ReviewDao();


			try {
				reviewDao.reviewCom(castId,userId,revC);
			} catch (SQLException e) {
				request.setAttribute("errMsg", "入力された内容は正しくありません");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
				dispatcher.forward(request, response);
				return;
			}
			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("CastListServlet");

	}

}
