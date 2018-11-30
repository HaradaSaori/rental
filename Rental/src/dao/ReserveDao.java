package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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

	public ReserveBeans reserveData(int id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

    //SELECT文
	String sql = "SELECT cast_id,login_id,cast_name FROM cast_tanuki WHERE cast_id = ?";

	// SELECTを実行し、結果表（ResultSet）を取得
	PreparedStatement pStmt = conn.prepareStatement(sql);
	pStmt.setInt(1, id);
	ResultSet rs = pStmt.executeQuery();

	ReserveBeans reserve  = null;

    while (rs.next()) {
    	String loginId = rs.getString("login_id");
        String castName = rs.getString("cast_name");

        reserve = new ReserveBeans(id,loginId, castName);

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

	public ReserveBeans reserveDatad(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

    //SELECT文
	String sql = "SELECT cast_id,cast_name FROM cast_tanuki WHERE login_id = ?";

	// SELECTを実行し、結果表（ResultSet）を取得
	PreparedStatement pStmt = conn.prepareStatement(sql);
	pStmt.setString(1, id);
	ResultSet rs = pStmt.executeQuery();

	ReserveBeans reserve  = null;

    while (rs.next()) {
    	String loginId = rs.getString("cast_id");
        String castName = rs.getString("cast_name");


        reserve = new ReserveBeans(loginId, castName);

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

    public List<ReserveBeans> findReserve(String id) {
        Connection conn = null;
        List<ReserveBeans> reserveList = new ArrayList<ReserveBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT r_date,(CASE dayofweek(r_date) WHEN 1 THEN '日' WHEN 2 THEN '月' WHEN 3 THEN '火' WHEN 4 THEN '水' WHEN 5 THEN '木' WHEN 6 THEN '金' WHEN 7 THEN '土' END) AS week,cast_tanuki.cast_id, cast_tanuki.cast_name FROM reserve  join cast_tanuki on reserve.cast_id = cast_tanuki.login_id WHERE r_date BETWEEN CURDATE() AND CURDATE() +interval 2 week - interval 1 SECOND AND r_date > now() AND cast_tanuki.cast_id =? ORDER BY r_date";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
    		pStmt.setString(1, id);
    		ResultSet rs = pStmt.executeQuery();

    		ReserveBeans reserve  = null;

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                String castName = rs.getString("cast_tanuki.cast_name");
                Date rDate = rs.getDate("r_date");
                String week = rs.getString("week");
                reserve = new ReserveBeans(id, castName,rDate,week);

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

    public List<java.sql.Date> cal() {

    	ArrayList<java.sql.Date> list = new ArrayList<>();

		for(int i = 0;i < 14;i++){
		    Calendar cal = Calendar.getInstance();
		    cal.set(Calendar.HOUR_OF_DAY, 0);
		    cal.set(Calendar.MINUTE, 0);
		    cal.set(Calendar.SECOND, 0);
		    cal.set(Calendar.MILLISECOND, 0);




		    cal.add(Calendar.DAY_OF_MONTH, i);

		    java.sql.Date sqlDate;
		    java.util.Date date = cal.getTime();
		    sqlDate = new java.sql.Date(date.getTime());


		    list.add(sqlDate);
		}

		return list;

    }
}