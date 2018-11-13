package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.CastBeans;

/**
 * キャストテーブル用のDao
 *
 *
 */
public class CastDao {

	public List<CastBeans> all() {
	    Connection conn = null;
	    List<CastBeans> castList = new ArrayList<CastBeans>();

	    try {
	        // データベースへ接続
	        conn = DBManager.getConnection();

	        // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = "SELECT * FROM cast_tanuki";

	         // SELECTを実行し、結果表を取得
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // 結果表に格納されたレコードの内容を
	        // Userインスタンスに設定し、ArrayListインスタンスに追加
	        while (rs.next()) {
	            int id = rs.getInt("cast_id");
	            String loginId = rs.getString("login_id");
	            String castName = rs.getString("cast_name");
	            int age = rs.getInt("age");
	            String gender = rs.getString("gender");
	            String bake = rs.getString("bake");
	            String comment = rs.getString("comment");
	            int price = rs.getInt("price");
	            CastBeans cast = new CastBeans(id, loginId,castName, age, gender,bake,comment,price);

	            castList.add(cast);
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
	    return castList;
	}

	public CastBeans castData(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

    //SELECT文
	String sql = "SELECT login_id,cast_name, gender, age,bake,comment,price FROM cast_tanuki WHERE cast_id = ?";

	// SELECTを実行し、結果表（ResultSet）を取得
	PreparedStatement pStmt = conn.prepareStatement(sql);
	pStmt.setString(1, id);
	ResultSet rs = pStmt.executeQuery();

	CastBeans cast  = null;

    while (rs.next()) {
    	String loginId = rs.getString("login_id");
        String castName = rs.getString("cast_name");
        int age = rs.getInt("age");
        String gender = rs.getString("gender");
        String bake = rs.getString("bake");
        String comment = rs.getString("comment");
        int price = rs.getInt("price");
        cast = new CastBeans(Integer.parseInt(id),loginId, castName,age,gender,bake,comment,price);

    }


    pStmt.close();

    return cast;
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


public void newCastDate(String loginId, String castName, int age,String gender,String bake,String comment,int price) throws SQLException{
    Connection conn = null;
    try {
        // データベースへ接続
        conn = DBManager.getConnection();

     // INSERT文を準備
        String sql = "INSERT INTO cast_tanuki(login_id,cast_name,age,gender,bake,comment,price) VALUES(?,?,?,?,?,?,?)";

     // INSERTを実行
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, loginId);
        pStmt.setString(2, castName);
        pStmt.setInt(3, age);
        pStmt.setString(4, gender);
        pStmt.setString(5, bake);
        pStmt.setString(6, comment);
        pStmt.setInt(7, price);
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


public void CastF5(String castName, int age, String gender, String bake,String comment,int price,String loginId)throws SQLException {
    Connection conn = null;
    try {
        // データベースへ接続
        conn = DBManager.getConnection();

     // UPDATE文を準備
        String sql = "UPDATE cast_tanuki SET cast_name = ?,age = ?,gender = ?,bake = ?,comment = ?, price = ? WHERE login_id = ?";

     // UPDATEを実行
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, castName);
        pStmt.setInt(2, age);
        pStmt.setString(3, gender);
        pStmt.setString(4, bake);
        pStmt.setString(5, comment);
        pStmt.setInt(6, price);
        pStmt.setString(7, loginId);
        pStmt.executeUpdate();

        pStmt.close();

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


	public void Castdelete(String loginId) {
	    Connection conn = null;
	    try {
	        // データベースへ接続
	        conn = DBManager.getConnection();

	     // DELETE文を準備
	        String sql = "DELETE FROM cast_tanuki WHERE login_id = ?";

	     // DELETEを実行
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, loginId);
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

}