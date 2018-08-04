package com.brainmentors.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.brainmentors.app.dto.CommonGenericDTO;

public interface CacheLoader {
	
	public static HashMap<String, ArrayList<CommonGenericDTO>> loadCache() throws ClassNotFoundException, SQLException{
		HashMap<String , ArrayList<CommonGenericDTO>> cacheMap = new HashMap<>();
		ArrayList<CommonGenericDTO> gender = CommonDAO.getCommonGenericParameters("gender");
		cacheMap.put("gender", gender);
		ArrayList<CommonGenericDTO> city = CommonDAO.getCommonGenericParameters("city");
		cacheMap.put("city",city);
		return cacheMap;
	}
	
}
