package logic;

import java.util.List;

import dao.LoginUserDAO;
import model.User;

/*
 * ログインに関する処理を行うモデル
 */
public class LoginLogic {
	public boolean execute(User user, List<User> userList) {
		
		LoginUserDAO dao = new LoginUserDAO();
		
		for(int i = 0; i < userList.size(); i++) {
			//管理者IDとパスワードがあっているか判定する
			if(userList.get(i).getPass().equals(user.getPass())
					&& userList.get(i).getLoginId().equals(user.getLoginId())) {	
				return true;
			}
			
		}
		return false;
	}
}
