package user;

import java.util.List;
import java.util.Map;


public interface IUserService {
	/**
	 * 회원가입 - 유저 정보 DB에 입력
	 * 
	 * @param userVO
	 * @return 성공 시 true, 실패 시 false 반환
	 * @author 이학재
	 */
	boolean insertUser(UserVO userVO);
	
	/**
	 * id 중복 여부와 조건을 충분히 만족하는지 확인
	 * 
	 * @param id
	 * @return 만족하면 true, 불만족하면 false 반환
	 */
	boolean checkId(String id);
	
	/**
	 * 선택한 유저 정보 가져오기 - 관리자 메서드
	 * 
	 * @param user_id
	 * @return UserVO
	 * @author 정예진
	 */
	UserVO selectUser(String user_id);

	/**
	 * 포인트 충전 메서드 - 유저 메서드
	 * 
	 * @param userObj
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 박세웅
	 */
	int addPoint(Map<String, Object> userObj);

	/**
	 * 유저 정보 업데이트 메서드
	 * 
	 * @param userInfo
	 *            <"user_id", user_id> <"user_pw", user_pw> <"user_name",
	 *            user_name>
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 박세웅
	 */
	int updateUser(Map<String, Object> userInfo);

	/**
	 * 유저 정보 삭제 메서드
	 * 
	 * @param user_id
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 박세웅
	 */
	int deleteUser(String user_id);
	
	/**
	 * 회원 계정 로그인
	 * 
	 * @param loginInfo
	 *            <"user_id", user_id>, <"user_pw", user_pw> 키/값을 전송하여 로그인 성공여부
	 *            반환받음
	 * @return 로그인 성공 시 true, 실패 시 false 반환
	 * @author 박세웅
	 */
	public boolean userLogin(Map<String, String> loginInfo);

	public List<UserVO> selectAllUser();
}
