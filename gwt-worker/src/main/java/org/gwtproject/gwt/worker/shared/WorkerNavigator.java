package org.gwtproject.gwt.worker.shared;

import java.util.List;

public interface WorkerNavigator {
	
	//NavigatorID
	
	String getAppCodeName(); // Mozilla

	String getAppName();

	String getAppVersion();

	String getPlatform();

	String getProduct(); // Gecko

	String isTaintEnabled(); // false

	String getUserAgent();

	String getVendorSub();
	
	//NavigatorLanguage
	
	String getLanguage();
	
	List<String> getLanguages();
	
	//NavigatorOnLine
	
	boolean isOnline();
}
