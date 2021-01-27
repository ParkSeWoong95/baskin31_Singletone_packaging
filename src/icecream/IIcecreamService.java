package icecream;

import java.util.List;
import java.util.Map;

public interface IIcecreamService {
	/**
	 * 아이스크림 목록 전부 가져오기 - 관리자 / 유저 메서드
	 * 
	 * @return List<IcecreamVO>
	 * @author 이학재
	 */
	List<IcecreamVO> selectAllIcecream();
	
	/**
	 * 아이스크림 하나 가져오기 - 관리자 / 유저 메서드
	 * 
	 * @param icecream_seq
	 * @return IcecreamVO
	 * @author 박세웅
	 */
	IcecreamVO selectIcecream(int icecream_seq);
	
	/**
	 * 새로운 아이스크림 정보 추가 - 관리자 메서드
	 * 
	 * @param icecream
	 * @return 성공하면 true, 실패하면 false 반환
	 * @author 박세웅
	 */
	boolean insertIcecream(IcecreamVO icecream);
	
	/**
	 * 아이스크림 정보 갱신 - 관리자 메서드
	 * 
	 * @param icecreamUpdateInfo
	 *            <"icecream_seq", icecream_seq>, <"stock", stock> 키와 값의 쌍
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 박세웅
	 */
	int updateIcecream(Map<String, Object> icecreamUpdateInfo);
	
	/**
	 * 아이스크림 정보 삭제 - 관리자 메서드
	 * 
	 * @param icecream_seq
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 박세웅
	 */
	int deleteIcecream(int icecream_seq);
}
