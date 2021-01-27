package size;

import java.util.List;
import java.util.Map;

import db.DBClass;

public class ISizeDaoImpl implements ISizeDao {
	
	private static ISizeDao dao;
	private DBClass db;
	
	private ISizeDaoImpl(){
		db = DBClass.getInstance();
	}
	
	public static ISizeDao getInstance(){
		if(dao == null){
			dao = new ISizeDaoImpl();
		}
		return dao;
	}

	@Override
	public List<SizeVO> selectAllsize() {
		return db.selectAllsize();
	}

	@Override
	public SizeVO selectSize(int size_seq) {
		return db.selectSize(size_seq);
	}

	@Override
	public boolean insertSize(SizeVO sizeVO) {
		return db.insertSize(sizeVO);
	}

	@Override
	public int updateSize(Map<String, Object> sizeInfo) {
		return db.updateSize(sizeInfo);
	}

	@Override
	public int deleteSize(int size_seq) {
		return db.deleteSize(size_seq);
	}
}
