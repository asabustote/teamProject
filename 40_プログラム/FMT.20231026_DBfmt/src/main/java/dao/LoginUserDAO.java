package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class LoginUserDAO {
	private final String URL = "jdbc:postgresql://localhost:5432/fmt";
    private final String USER = "postgres";
    private final String PASSWORD = "test";

	// コンストラクタ
	public LoginUserDAO() {
		/* JDBCドライバの準備 */
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<User>findAll() {
		List<User> userList = new ArrayList<>();

		/* 1) SQL文の準備 */
		String sql = "SELECT login_user_id, password FROM login_user ORDER BY login_user_id ; ";

		/* 2) PostgreSQLへの接続 */
 		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
 			PreparedStatement pStmt = con.prepareStatement(sql);) {

		    /* SELECT文の実行 */
			ResultSet rs = pStmt.executeQuery();

			/* 結果をリストに移し替える */
			while (rs.next()) {
				String loginUserId = rs.getString("login_user_id");
				String password = rs.getString("password");

				User userDAO = new User(loginUserId, password);
				userList.add(userDAO);
			}
		} catch (Exception e) {
			System.out.println(sql);
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}

		return userList;
	}
}
