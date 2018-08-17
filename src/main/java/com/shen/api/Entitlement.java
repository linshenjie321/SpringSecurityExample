package com.shen.api;

import java.util.ArrayList;
import java.util.List;

public class Entitlement {
	
	public static final String HOME_TAB = "HOMETAB";
	public static final String SUPPORT_TAB = "SUPPORTTAB";
	public static final String PAYMENT_CENTER_TAB = "PAYMENTCENTERTAB";
	public static final String PAYMENT_HIGHWAY_TAB = "PAYMENTHIGHWAYTAB";
	public static final String PRODUCT_CATALOG_TAB = "PRODUCTCATALOGUETAB";
	public static final String CONTENT_MANAGEMENT_TAB = "CONTENTMANAGEMENTTAB";
	public static final String SCO_ADMIN_TAB = "SCOADMINTAB";
	
	public static List<String> allEntitlements(){
		List<String> entitlements = new ArrayList<>();
		entitlements.add(HOME_TAB);
		entitlements.add(SUPPORT_TAB);
		entitlements.add(PAYMENT_CENTER_TAB);
		entitlements.add(PAYMENT_HIGHWAY_TAB);
		entitlements.add(PRODUCT_CATALOG_TAB);
		entitlements.add(CONTENT_MANAGEMENT_TAB);
		entitlements.add(SCO_ADMIN_TAB);
		return entitlements;
	}
	
	public static List<String> homeUser(){
		List<String> entitlements = new ArrayList<>();
		entitlements.add(HOME_TAB);
		return entitlements;
	}
	
	public static List<String> regularUser(){
		List<String> entitlements = new ArrayList<>();
		entitlements.add(HOME_TAB);
		entitlements.add(PAYMENT_CENTER_TAB);
		entitlements.add(PAYMENT_HIGHWAY_TAB);
		entitlements.add(SCO_ADMIN_TAB);
		return entitlements;
	}

}
