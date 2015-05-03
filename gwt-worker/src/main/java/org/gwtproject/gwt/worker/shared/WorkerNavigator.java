package org.gwtproject.gwt.worker.shared;

import java.util.List;

import org.gwtproject.gwt.worker.client.WorkerNavigatorJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;

@SingleJsoImpl(WorkerNavigatorJsoImpl.class)
public interface WorkerNavigator {

	// NavigatorID

	String getAppCodeName(); // Mozilla

	String getAppName();

	String getAppVersion();

	String getPlatform();

	String getProduct(); // Gecko

	boolean isTaintEnabled(); // false

	String getUserAgent();

	String getVendorSub();

	// NavigatorLanguage

	String getLanguage();

	List<String> getLanguages();

	// NavigatorOnLine

	boolean isOnline();
}
