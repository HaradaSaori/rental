package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CastBeans;
import beans.ReserveBeans;
import beans.ReviewBeans;
import dao.CastDao;
import dao.ReserveDao;
import dao.ReviewDao;

/**
 * Servlet implementation class CastDetailServlet
 */
@WebServlet("/CastDetailServlet")
public class CastDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CastDetailServlet() {
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

		 //idを引数にして、idに紐づくユーザ情報を出力する
	       ReserveDao reserveDao = new ReserveDao();
		   List<ReserveBeans> reserveList = reserveDao.findReserve(id);

		   // ユーザ情報をリクエストスコープにセットしてjspにフォワード
		   request.setAttribute("reserveList",reserveList);

			// 一覧情報を取得
			ReviewDao reviewDao = new ReviewDao();
			List<ReviewBeans> reviewList = reviewDao.review();

			// リクエストスコープに一覧情報をセット
			request.setAttribute("reviewList", reviewList);

			reserveDao = new ReserveDao();
			List<java.sql.Date> calList = reserveDao.cal();

			// リクエストスコープに一覧情報をセット
			request.setAttribute("calList", calList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/castdetail.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginId");
		String castId = request.getParameter("castId");

		ReviewDao reviewDao = new ReviewDao();
		reviewDao.Revdelete(loginId,castId);

		// ユーザ一覧のサーブレットにリダイレクト
				response.sendRedirect("CastListServlet");
	}

}
