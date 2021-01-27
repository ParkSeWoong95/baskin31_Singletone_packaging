package size;

import java.util.List;
import java.util.Map;

public interface ISizeDao {

	List<SizeVO> selectAllsize();

	SizeVO selectSize(int size_seq);

	boolean insertSize(SizeVO sizeVO);

	int updateSize(Map<String, Object> sizeInfo);

	int deleteSize(int size_seq);

}
