package test.semeval2010;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kse.dao.impl.MongoDaoImpl;

import base.BaseTest;

public class LoadData extends BaseTest{

	@Autowired
	MongoDaoImpl mongoDaoImpl;
	
	private String DBNAME = "SemEval2010-1";
	
	@Test
	public void loadData(){
		System.out.print(mongoDaoImpl.find(DBNAME, 0));
	}
}
