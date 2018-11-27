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

import beans.ReserveBeans;
import beans.UserBeans;
import dao.ReserveDao;
import dao.UserDao;

/**
 * Servlet implementation class MyReserveServlet
 */
@WebServlet("/MyReserveServlet")
public class MyReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReserveServlet() {
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
	       UserDao userDao = new UserDao();
		   UserBeans userdata = userDao.userData(id);

		   // ユーザ情報をリクエストスコープにセットしてjspにフォワード
		   request.setAttribute("userdata",userdata);

			//idを引数にして、idに紐づくユーザ情報を出力する
	       ReserveDao reserveDao = new ReserveDao();
	       List<ReserveBeans> reserveList = reserveDao.findDate(id);

		   // ユーザ情報をリクエストスコープにセットしてjspにフォワード
		   request.setAttribute("reserveList",reserveList);

	       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myreserve.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myreserve.jsp");
			dispatcher.forward(request, response);
	}

}
