package size;

import java.util.List;
import java.util.Map;

public interface ISizeService {
	/**
	 * 사이즈 정보 전체 가져오기 - 관리자 / 유저 메서드
	 * 
	 * @return List<SizeVO>
	 * @author 이학재
	 */
	List<SizeVO> selectAllSize();
	
	/**
	 * 사이즈 정보 가져오기 - 관리자 / 유저 메서드
	 * 
	 * @param size_seq
	 * @return SizeVO
	 * @author 이학재
	 */
	SizeVO selectSize(int size_seq);
	
	/**
	 * 사이즈 정보 추가 - 관리자 메서드
	 * 
	 * @param sizeVO
	 * @return 성공 시 true, 실패 시 false 반환
	 * @author 이학재
	 */
	boolean insertSize(SizeVO sizeVO);
	
	/**
	 * 사이즈 정보 업데이트 - 관리자 메서드
	 * 
	 * @param sizeInfo
	 *            <"size_seq", size_seq> <"size_name", size_name"> <"size_gram",
	 *            size_gram> <"size_flavorKinds", size_flavorKinds>
	 *            <"size_price", size_price>
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 이학재
	 */
	int updateSize(Map<String, Object> sizeInfo);
	
	/**
	 * 사이즈 정보 삭제 - 관리자 메서드
	 * 
	 * @param size_seq
	 * @return 실패 시 0, 성공 시 양수 반환
	 * @author 이학재
	 */
	int deleteSize(int size_seq);
}
