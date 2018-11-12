package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.UserBeans;

/**
 * ユーザテーブル用のDao
 *
 *
 */
public class UserDao {

	   /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public UserBeans findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("user_name");
            return new UserBeans(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<UserBeans> findAll() {
        Connection conn = null;
        List<UserBeans> userList = new ArrayList<UserBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String loginId = rs.getString("login_id");
                String userName = rs.getString("user_name");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                UserBeans user = new UserBeans(userId, loginId, userName, phone, password);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	public UserBeans userData(String id) {
	        Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	    //SELECT文
		String sql = "SELECT login_id, user_name, phone FROM user WHERE user_id = ?";

		// SELECTを実行し、結果表（ResultSet）を取得
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, id);
		ResultSet rs = pStmt.executeQuery();

		UserBeans user  = null;

	    while (rs.next()) {
	        String loginId = rs.getString("login_id");
	        String userName = rs.getString("user_name");
	        String phone = rs.getString("phone");
	        user = new UserBeans(Integer.parseInt(id),loginId, userName, phone);

	    }


	    pStmt.close();

	    return user;
	        } catch (SQLException e) {
	            e.printStackTrace();

	        } finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();

	                }
	            }
	        }
	        return null;
	    }

}