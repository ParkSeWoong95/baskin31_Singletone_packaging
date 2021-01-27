package admin;

import java.util.Map;

public interface IAdminService {
	/**
	 * 관리자 계정 로그인
	 *
	 * @param loginInfo
	 * @return 로그인 성공 시 true, 실패 시 false 반환
	 */
	boolean adminLogin(Map<String, String> loginInfo);
}
