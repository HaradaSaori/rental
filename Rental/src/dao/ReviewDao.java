package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ReviewBeans;

/**
 * レビューテーブル用のDao
 *
 *
 */
public class ReviewDao {


	public List<ReviewBeans> review() {
	    Connection conn = null;
	    List<ReviewBeans> reviewList = new ArrayList<ReviewBeans>();

	    try {
	        // データベースへ接続
	        conn = DBManager.getConnection();

	        // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = "SELECT * FROM review INNER JOIN cast_tanuki ON review.cast_id = cast_tanuki.login_id INNER JOIN user ON review.user_id = user.login_id";

	         // SELECTを実行し、結果表を取得
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // 結果表に格納されたレコードの内容を
	        // Userインスタンスに設定し、ArrayListインスタンスに追加
	        while (rs.next()) {
	            int revId = rs.getInt("rev_id");
	            String userId = rs.getString("user_id");
	            String userName = rs.getString("user_name");
	            String castId = rs.getString("cast_id");
	            String revC = rs.getString("rev_c");

	            ReviewBeans review = new ReviewBeans(revId,userId,userName,castId,revC);

	            reviewList.add(review);
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
	    return reviewList;
	}

	public void reviewCom(String castId,String userId,String revC) throws SQLException{
	    Connection conn = null;
	    try {
	        // データベースへ接続
	        conn = DBManager.getConnection();

	     // INSERT文を準備
	        String sql = "INSERT INTO review(cast_id,user_id,rev_c) VALUES(?,?,?)";

	     // INSERTを実行
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, castId);
	        pStmt.setString(2, userId);
	        pStmt.setString(3, revC);
	        pStmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
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
	}
	public void Revdelete(int revId) {
	    Connection conn = null;
	    try {
	        // データベースへ接続
	        conn = DBManager.getConnection();

	     // DELETE文を準備
	        String sql = "DELETE FROM review WHERE rev_id = ?";

	     // DELETEを実行
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, revId);
	        pStmt.executeUpdate();

	        pStmt.close();

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

	}

	public ReviewBeans reviewData(int revId) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

    //SELECT文
	String sql = "SELECT rev_c,cast_id,user_id FROM review WHERE rev_id = ?";

	// SELECTを実行し、結果表（ResultSet）を取得
	PreparedStatement pStmt = conn.prepareStatement(sql);
	pStmt.setInt(1, revId);
	ResultSet rs = pStmt.executeQuery();

	ReviewBeans rev  = null;

    while (rs.next()) {
    	String castId = rs.getString("cast_id");
        String userId = rs.getString("user_id");
        String revC = rs.getString("rev_c");
        rev = new ReviewBeans(castId,userId,revId,revC);

    }


    pStmt.close();

    return rev;
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