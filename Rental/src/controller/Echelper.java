package controller;

import javax.servlet.http.HttpSession;

public class Echelper {
	// 検索結果
	static final String SEARCH_RESULT_PAGE = "/WEB-INF/jsp/itemsearchresult.jsp";
	// 商品ページ
	static final String ITEM_PAGE = "/WEB-INF/jsp/item.jsp";
	// TOPページ
	static final String TOP_PAGE = "/WEB-INF/jsp/index.jsp";
	// エラーページ
	static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";
	// 買い物かごページ
	static final String CART_PAGE = "/WEB-INF/jsp/cart.jsp";
	// 購入
	static final String BUY_PAGE = "/WEB-INF/jsp/buy.jsp";
	// 購入確認
	static final String BUY_CONFIRM_PAGE = "/WEB-INF/jsp/buyconfirm.jsp";
	// 購入完了
	static final String BUY_RESULT_PAGE = "/WEB-INF/jsp/buyresult.jsp";
	// ユーザー情報
	static final String USER_DATA_PAGE = "/WEB-INF/jsp/mypage.jsp";
	// ユーザー情報更新確認
	static final String USER_DATA_UPDATE_CONFIRM_PAGE = "/WEB-INF/jsp/userdataupdateconfirm.jsp";
	// ユーザー情報更新完了
	static final String USER_DATA_UPDATA_RESULT_PAGE = "/WEB-INF/jsp/userdataupdateresult.jsp";
	// ユーザー購入履歴
	static final String USER_BUY_HISTORY_DETAIL_PAGE = "/WEB-INF/jsp/userbuyhistorydetail.jsp";
	// ログイン
	static final String LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
	// ログアウト
	static final String LOGOUT_PAGE = "/WEB-INF/jsp/logout.jsp";
	// 新規登録
	static final String REGIST_PAGE = "/WEB-INF/jsp/regist.jsp";
	// 新規登録入力内容確認
	static final String REGIST_CONFIRM_PAGE = "/WEB-INF/jsp/registconfirm.jsp";
	// 新規登録完了
	static final String REGIST_RESULT_PAGE = "/WEB-INF/jsp/registresult.jsp";

	public static Echelper getInstance() {
		return new Echelper();
	}

	/**
	 * セッションから指定データを取得（削除も一緒に行う）
	 *
	 * @param session
	 * @param str
	 * @return
	 */
	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}
}