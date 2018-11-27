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

import beans.ReserveBeans;
import dao.ReserveDao;

/**
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveServlet() {
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
			       ReserveDao reserveDao = new ReserveDao();
				   ReserveBeans reservedata = reserveDao.reserveData(id);

				   // ユーザ情報をリクエストスコープにセットしてjspにフォワード
				   request.setAttribute("reservedata",reservedata);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
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
		String castName = request.getParameter("castName");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String rDate = request.getParameter("rDate");
		String place = request.getParameter("place");
		String resCom = request.getParameter("resCom");

		ReserveDao reserveDao = new ReserveDao();

		if(rDate.isEmpty() || place.isEmpty() || resCom.isEmpty())
{
			request.setAttribute("errMsg", "必須項目を入力してください");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
			dispatcher.forward(request, response);
			return;
}


		try {
			reserveDao.newReserve(castId,castName,userId,userName,rDate,place,resCom);
		} catch (SQLException e) {
			request.setAttribute("errMsg", "その日付はすでに予約されています");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//リダイレクト
		response.sendRedirect("ReserveResultServlet");

	}


}
