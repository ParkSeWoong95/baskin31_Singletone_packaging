package user;

import java.util.List;
import java.util.Map;

import db.DBClass;

public class IUserDaoImpl implements IUserDao{

	private static IUserDao dao;
	private DBClass db;
	
	private IUserDaoImpl(){
		db = DBClass.getInstance();
	}
	
	public static IUserDao getInstance() {
		if(dao == null){
			dao = new IUserDaoImpl();
		}
		return dao;
	}

	@Override
	public boolean insertUser(UserVO user) {

		return db.insertUser(user);
	}

	@Override
	public boolean userIdUniqueCheck(String id) {
		
		return db.userIdUniqueCheck(id);
	}

	@Override
	public UserVO selectUser(String user_id) {
		return db.selectUser(user_id);
	}

	@Override
	public int addPoint(Map<String, Object> userObj) {
		
		return db.addPoint(userObj);
	}

	@Override
	public int updateUser(Map<String, Object> userInfo) {
		
		return db.updateUser(userInfo);
	}

	@Override
	public int deleteUser(String user_id) {
		
		return db.deleteUser(user_id);
	}

	@Override
	public boolean userLogin(Map<String, String> loginInfo) {
		return db.userLogin(loginInfo);
	}

	@Override
	public List<UserVO> selectAllUser() {
		
		return db.selectAllUser();
	}
	
	
	
	

}
