package org.gwtproject.gwt.worker.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gwtproject.gwt.worker.shared.WorkerNavigator;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class WorkerNavigatorJsoImpl extends JavaScriptObject implements
		WorkerNavigator {

	public WorkerNavigatorJsoImpl() {
	}
	
	@Override
	public final native String getAppCodeName() /*-{
		return this.appCodeName;
	}-*/;

	@Override
	public final native String getAppName() /*-{
		return this.appName;
	}-*/;

	@Override
	public final native String getAppVersion() /*-{
		return this.appVersion;
	}-*/;

	@Override
	public final native String getPlatform() /*-{
		return this.platform;
	}-*/;

	@Override
	public final native String getProduct() /*-{
		return this.product;
	}-*/;

	@Override
	public final native boolean isTaintEnabled() /*-{
		return this.taintEnabled;
	}-*/;

	@Override
	public final native String getUserAgent() /*-{
		return this.userAgent;
	}-*/;

	@Override
	public final native String getVendorSub() /*-{
		return this.vendorSub;
	}-*/;

	@Override
	public final native String getLanguage() /*-{
		return this.language;
	}-*/;

	@Override
	public final List<String> getLanguages() {
		JsArrayString langs = getLanguages0();
		if(langs == null || langs.length() == 0) {
			return Collections.emptyList();
		}
		
		List<String> ls = new ArrayList<>();
		for(int i = 0; i < langs.length(); i++) {
			String l = langs.get(i);
			ls.add(l);
		}
		
		return ls;
	}
	
	private final native JsArrayString getLanguages0()/*-{
		return this.languages;
	}-*/;

	@Override
	public final native boolean isOnline() /*-{
		return this.onLine;
	}-*/;

}
