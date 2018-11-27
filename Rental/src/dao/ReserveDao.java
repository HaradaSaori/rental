package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReserveBeans;

/**
 * 予約テーブル用のDao
 *
 *
 */
public class ReserveDao {

	public void newReserve(String castId,String castName,String userId,String userName,String rDate,String place,String resCom) throws SQLException{
	    Connection conn = null;
	    try {
	        // データベースへ接続
	        conn = DBManager.getConnection();


	     // INSERT文を準備
	        String sql = "INSERT INTO reserve(cast_id,user_id,r_date,place,res_com) VALUES(?,?,?,?,?)";

	     // INSERTを実行
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, castId);
	        pStmt.setString(2, userId);
	        pStmt.setString(3, rDate);
	        pStmt.setString(4, place);
	        pStmt.setString(5, resCom);
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

	public ReserveBeans reserveData(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

    //SELECT文
	String sql = "SELECT reserve.cast_id,cast_name FROM reserve INNER JOIN cast_tanuki ON reserve.cast_id = cast_tanuki.login_id WHERE cast_tanuki.cast_id = ?";

	// SELECTを実行し、結果表（ResultSet）を取得
	PreparedStatement pStmt = conn.prepareStatement(sql);
	pStmt.setString(1, id);
	ResultSet rs = pStmt.executeQuery();

	ReserveBeans reserve  = null;

    while (rs.next()) {
    	String loginId = rs.getString("cast_id");
        String castName = rs.getString("cast_name");
        reserve = new ReserveBeans(Integer.parseInt(id),loginId, castName);

    }


    pStmt.close();

    return reserve;
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


    public List<ReserveBeans> find(String id) {
        Connection conn = null;
        List<ReserveBeans> reserveList = new ArrayList<ReserveBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT reserve.cast_id,cast_tanuki.cast_name,r_date,place,res_com FROM reserve INNER JOIN cast_tanuki ON reserve.cast_id=cast_tanuki.login_id WHERE r_date < now() AND reserve.user_id = ? ORDER BY r_date DESC";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
    		pStmt.setString(1, id);
    		ResultSet rs = pStmt.executeQuery();

    		ReserveBeans reserve  = null;

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                String castId = rs.getString("reserve.cast_id");
                String castName = rs.getString("cast_tanuki.cast_name");
                Date rDate = rs.getDate("r_date");
                String place = rs.getString("place");
                String resCom = rs.getString("res_com");
                reserve = new ReserveBeans(id, castId, castName,rDate,place,resCom);

                reserveList.add(reserve);
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
        return reserveList;
    }

    public List<ReserveBeans> findDate(String id) {
        Connection conn = null;
        List<ReserveBeans> reserveList = new ArrayList<ReserveBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT reserve.cast_id,cast_tanuki.cast_name,r_date,place,res_com FROM reserve INNER JOIN cast_tanuki ON reserve.cast_id=cast_tanuki.login_id WHERE r_date > now() AND reserve.user_id =? ORDER BY r_date";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
    		pStmt.setString(1, id);
    		ResultSet rs = pStmt.executeQuery();

    		ReserveBeans reserve  = null;

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                String castId = rs.getString("reserve.cast_id");
                String castName = rs.getString("cast_tanuki.cast_name");
                Date rDate = rs.getDate("r_date");
                String place = rs.getString("place");
                String resCom = rs.getString("res_com");
                reserve = new ReserveBeans(id,castId, castName,rDate,place,resCom);

                reserveList.add(reserve);
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
        return reserveList;
    }

}