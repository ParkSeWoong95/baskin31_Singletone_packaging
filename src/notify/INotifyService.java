package notify;

import java.util.List;
import java.util.Map;

public interface INotifyService {
	/**
	 * 공지 입력 - 관리자 메서드
	 * 
	 * @param notify
	 * @return 성공 시 true, 실패 시 false 반환
	 * @author 박세웅
	 */
	boolean insertNotify(NotifyVO notify);
	
	/**
	 * 모든 공지 가져오기 - 관리자 / 유저 메서드
	 * 
	 * @return List<NotifyVO>
	 * @author 박세웅
	 */
	List<NotifyVO> selectAllNotify();

	/**
	 * 선택한 공지 가져오기 - 관리자 / 유저 메서드
	 * 
	 * @param notify_seq
	 * @return NotifyVO
	 * @author 박세웅
	 */
	NotifyVO selectNotify(int notify_seq);

	/**
	 * 공지 정보 업데이트 - 관리자 메서드
	 * 
	 * @param notifyObj
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 박세웅
	 */
	int updateNotify(Map<String, Object> notifyObj);

	/**
	 * 공지 삭제 - 관리자 메서드
	 * 
	 * @param notify_seq
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 박세웅
	 */
	int deleteNotify(int notify_seq);
}
