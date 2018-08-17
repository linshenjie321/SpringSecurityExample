package com.shen.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
	
	private Map<String, List<String>> userMap;
	
	Users(){
		userMap = new HashMap<>();
		userMap.put("admin", Entitlement.allEntitlements());
		userMap.put("homeUser", Entitlement.homeUser());
		userMap.put("regularUser", Entitlement.regularUser());
	}

	public Map<String, List<String>> getUserMap() {
		return userMap;
	}

}
