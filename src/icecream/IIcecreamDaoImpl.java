package icecream;

import java.util.List;
import java.util.Map;

import db.DBClass;

public class IIcecreamDaoImpl implements IIcecreamDao{
	private static IIcecreamDao dao;
	private DBClass db;
	
	private IIcecreamDaoImpl(){
		db = DBClass.getInstance();
	}
	public static IIcecreamDao getInstance(){
		if(dao == null){
			dao = new IIcecreamDaoImpl();
		}
		return dao;
	}
	@Override
	public List<IcecreamVO> selectAllIcecream() {
		return db.selectAllIcecream();
	}
	@Override
	public IcecreamVO selectIcecream(int icecream_seq) {
		return db.selectIcecream(icecream_seq);
	}
	@Override
	public boolean insertIcecream(IcecreamVO icecream) {
		return db.insertIcecream(icecream);
	}
	@Override
	public int updateIcecream(Map<String, Object> icecreamUpdateInfo) {
		return db.updateIcecream(icecreamUpdateInfo);
	}
	@Override
	public int deleteIcecream(int icecream_seq) {
		return db.deleteIcecream(icecream_seq);
	}
}
