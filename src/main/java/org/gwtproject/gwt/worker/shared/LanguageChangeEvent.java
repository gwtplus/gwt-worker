package org.gwtproject.gwt.worker.shared;

public interface LanguageChangeEvent {

	interface Handler {
		void onLanguageChange(LanguageChangeEvent event);
	}
}
