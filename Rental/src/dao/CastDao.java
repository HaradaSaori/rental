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
	            String castName = rs.getString("cast_name");
	            int age = rs.getInt("age");
	            String gender = rs.getString("gender");
	            String bake = rs.getString("bake");
	            String comment = rs.getString("comment");
	            int price = rs.getInt("price");
	            CastBeans cast = new CastBeans(id, castName, age, gender,bake,comment,price);

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
	String sql = "SELECT cast_name, gender, age,bake,comment,price FROM cast_tanuki WHERE cast_id = ?";

	// SELECTを実行し、結果表（ResultSet）を取得
	PreparedStatement pStmt = conn.prepareStatement(sql);
	pStmt.setString(1, id);
	ResultSet rs = pStmt.executeQuery();

	CastBeans cast  = null;

    while (rs.next()) {
        String castName = rs.getString("cast_name");
        int age = rs.getInt("age");
        String gender = rs.getString("gender");
        String bake = rs.getString("bake");
        String comment = rs.getString("comment");
        int price = rs.getInt("price");
        cast = new CastBeans(Integer.parseInt(id), castName,age,gender,bake,comment,price);

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


}