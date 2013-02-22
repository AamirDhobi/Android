package com.msdpe.feedback;

import android.app.Application;

public class FeedbackApplication extends Application {
	private FeedbackService mFeedbackService;
	
	public FeedbackApplication() {		
	}
	
	public FeedbackService getFeedbackService() {
		if (mFeedbackService == null) {
			mFeedbackService = new FeedbackService(this);
		}
		return mFeedbackService;
	}
}
