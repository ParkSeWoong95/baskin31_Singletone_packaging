package icecream;

import java.util.List;
import java.util.Map;

public interface IIcecreamDao {

	List<IcecreamVO> selectAllIcecream();

	IcecreamVO selectIcecream(int icecream_seq);

	boolean insertIcecream(IcecreamVO icecream);

	int updateIcecream(Map<String, Object> icecreamUpdateInfo);

	int deleteIcecream(int icecream_seq);

}
