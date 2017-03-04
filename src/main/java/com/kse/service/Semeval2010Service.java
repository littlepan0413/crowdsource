package com.kse.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.kse.dao.impl.MongoDaoImpl;

public class Semeval2010Service {
	
	MongoDaoImpl mongoDaoImpl;
	
	@Autowired
	public void setMongoDaoImpl(MongoDaoImpl mongoDaoImpl) {
		this.mongoDaoImpl = mongoDaoImpl;
	}

	private String DBNAME_1 = "SemEval2010-1";
	
	/**
	 * 获得一个文档
	 * @param maxNum 当前最大众包数
	 */
	public Map getOneDoc(int maxNum){
		List<Map> result = null;
		for(int i=0; i<=maxNum; i++){
			result = mongoDaoImpl.find(DBNAME_1, i);
			if(result!=null && result.size()>0){
				break;
			}
		}
		//随机一个数
		if(result.size()>0){
			int index = new Random().nextInt(result.size());
			return result.get(index);
		}else{
			return null;
		}
	}
	
}
