package com.brainmentors.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.brainmentors.app.dto.CommonGenericDTO;

public final class CacheLoader implements CommonConstants {
	private CacheLoader(){
		
	}
	private static HashMap<String , ArrayList<CommonGenericDTO>> cacheMap = new HashMap<>();
	public static void cleanCache(){
		cacheMap = null;
		System.gc();
	}
	public static ArrayList<CommonGenericDTO> getCache(String key){
		if(cacheMap.get(key)!=null){
			return cacheMap.get(key);
		}
		return null;
	}
	public static HashMap<String, ArrayList<CommonGenericDTO>> loadCache() throws ClassNotFoundException, SQLException{
		
		ArrayList<CommonGenericDTO> gender = CommonDAO.getCommonGenericParameters("gender");
		cacheMap.put(CACHE_GENDER, gender);
		ArrayList<CommonGenericDTO> city = CommonDAO.getCommonGenericParameters("city");
		cacheMap.put(CACHE_CITY,city);
		return cacheMap;
	}
	
}
