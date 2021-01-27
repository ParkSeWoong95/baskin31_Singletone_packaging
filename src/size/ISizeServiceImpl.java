package size;

import java.util.List;
import java.util.Map;

public class ISizeServiceImpl implements ISizeService {

	private static ISizeServiceImpl service;
	private ISizeDao dao;
	
	private ISizeServiceImpl(){
		dao = ISizeDaoImpl.getInstance();
	}
	
	public static ISizeService getInstance(){
		if(service == null){
			service = new ISizeServiceImpl();
		}
		return service;
	}

	@Override
	public List<SizeVO> selectAllSize() {
		return dao.selectAllsize();
	}

	@Override
	public SizeVO selectSize(int size_seq) {
		return dao.selectSize(size_seq);
	}

	@Override
	public boolean insertSize(SizeVO sizeVO) {
		return dao.insertSize(sizeVO);
	}

	@Override
	public int updateSize(Map<String, Object> sizeInfo) {
		return dao.updateSize(sizeInfo);
	}

	@Override
	public int deleteSize(int size_seq) {
		return dao.deleteSize(size_seq);
	}
}
