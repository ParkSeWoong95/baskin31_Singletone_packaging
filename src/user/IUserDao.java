package user;

import java.util.List;
import java.util.Map;

public interface IUserDao {

	boolean insertUser(UserVO user);

	boolean userIdUniqueCheck(String id);

	UserVO selectUser(String user_id);

	int addPoint(Map<String, Object> userObj);

	int updateUser(Map<String, Object> userInfo);

	int deleteUser(String user_id);

	boolean userLogin(Map<String, String> loginInfo);

	List<UserVO> selectAllUser();
	
	

}
