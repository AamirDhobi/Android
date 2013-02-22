package com.msdpe.feedback;

import java.net.MalformedURLException;

import android.content.Context;
import android.util.Log;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

public class FeedbackService {
	private MobileServiceClient mClient;
	private MobileServiceTable<Feedback> mFeedbackTable;
	private Context mContext;
	private String TAG = "TicTacToeService";
	
	public FeedbackService(Context context) {
		mContext = context;
		
		try {
			mClient = new MobileServiceClient("https://<YourMobileServiceUrl>.azure-mobile.net/", "<YourApplicationKey>", mContext);
			mFeedbackTable = mClient.getTable(Feedback.class);
		} catch (MalformedURLException e) {
			Log.e(TAG, "There was an error creating the Mobile Service. Verify the URL");
		}
	}
	
	public void insertFeedback(Feedback feedback, TableOperationCallback<Feedback> callback) {
		mFeedbackTable.insert(feedback, callback);
	}
}
