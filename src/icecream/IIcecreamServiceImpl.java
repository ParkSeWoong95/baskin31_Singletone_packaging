package icecream;

import java.util.List;
import java.util.Map;

public class IIcecreamServiceImpl implements IIcecreamService{
	private static IIcecreamServiceImpl service;
	private IIcecreamDao dao;
	
	private IIcecreamServiceImpl(){
		dao = IIcecreamDaoImpl.getInstance();
	}
	
	public static IIcecreamService getInstance(){
		if(service == null){
			service = new IIcecreamServiceImpl();
		}
		return service;
	}

	@Override
	public List<IcecreamVO> selectAllIcecream() {
		return dao.selectAllIcecream();
	}

	@Override
	public IcecreamVO selectIcecream(int icecream_seq) {
		return dao.selectIcecream(icecream_seq);
	}

	@Override
	public boolean insertIcecream(IcecreamVO icecream) {
		return dao.insertIcecream(icecream);
	}

	@Override
	public int updateIcecream(Map<String, Object> icecreamUpdateInfo) {
		return dao.updateIcecream(icecreamUpdateInfo);
	}

	@Override
	public int deleteIcecream(int icecream_seq) {
		return dao.deleteIcecream(icecream_seq);
	}
}
