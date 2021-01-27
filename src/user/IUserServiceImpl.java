package user;

import java.util.List;
import java.util.Map;

public class IUserServiceImpl implements IUserService{
	
	private static IUserServiceImpl service;
	private IUserDao dao;
	
	private IUserServiceImpl(){
		dao = IUserDaoImpl.getInstance();
	}

	public static IUserService getInstance() {
		if(service == null){
			service = new IUserServiceImpl();
		}
		return service;
	}

	@Override
	public boolean insertUser(UserVO user) {
		
		return dao.insertUser(user);
	}

	@Override
	public boolean checkId(String id) {
		return dao.userIdUniqueCheck(id);
	}

	@Override
	public UserVO selectUser(String user_id) {
		return dao.selectUser(user_id);
	}

	@Override
	public int addPoint(Map<String, Object> userObj) {
		return  dao.addPoint(userObj);
	}

	@Override
	public int updateUser(Map<String, Object> userInfo) {
		return dao.updateUser(userInfo);
	}

	@Override
	public int deleteUser(String user_id) {
		
		return dao.deleteUser(user_id);
	}
	
	
	@Override
	public boolean userLogin(Map<String, String> loginInfo) {
		return dao.userLogin(loginInfo);
	}

	@Override
	public List<UserVO> selectAllUser() {
		return dao.selectAllUser();
	}
}
