package test.semeval2010;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kse.dao.impl.MongoDaoImpl;
import com.kse.util.FileOperatorUtil;
import com.kse.util.GsonFactory;

import base.BaseTest;
import ch.qos.logback.classic.db.names.DBNameResolver;

public class InsertData extends BaseTest {
	
	@Autowired
	MongoDaoImpl mongoDaoImpl;
	
	private String DBNAME = "SemEval2010-1";
	
	@Test
	public void testLoadData(){
		
		String filePath = "E:\\Instrument-Agency_Entity-Origin.txt";
		List<String> docs = FileOperatorUtil.readByLine(filePath);
		Gson gson = GsonFactory.getGsonClient();
		for(String doc : docs){
			Map map = gson.fromJson(doc, Map.class);
			mongoDaoImpl.insert(map, DBNAME);
		}
		System.out.println("done");
	}
}
