package com.msdpe.feedback;

import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class FeedbackActivity extends Activity {
	
	private final String TAG = "FeedbackActivity";
	private EditText mTxtComments;
	private EditText mTxtEmailAddress;
	private RatingBar mRatingBar;
	private Button mBtnSubmit;
	private TextView mLblCharactersLeft;
	private int mMaxChars;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);

		mLblCharactersLeft = (TextView) findViewById(R.id.lblCharactersLeft);		
		mTxtComments = (EditText) findViewById(R.id.txtComments);
		mTxtEmailAddress = (EditText) findViewById(R.id.txtEmailAddress);
		mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
		
		mTxtComments.addTextChangedListener(new CommentWatcher());
		//Set max character limit
		InputFilter[] FilterArray = new InputFilter[1];
		mMaxChars = getResources().getInteger(R.integer.comments_max_length);
		FilterArray[0] = new InputFilter.LengthFilter(mMaxChars);
		mTxtComments.setFilters(FilterArray);
		mLblCharactersLeft.setText(mMaxChars + " characters left");
		
		mBtnSubmit = (Button) findViewById(R.id.btnSubmit);
		mBtnSubmit.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				submitFeedback();				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_feedback, menu);
		return true;
	}
	
	private void submitFeedback() {
		FeedbackApplication myApp = (FeedbackApplication) getApplication();
		FeedbackService feedbackService = myApp.getFeedbackService();
		final Activity activity = this;
		
		Feedback feedback = new Feedback((int) mRatingBar.getRating(), mTxtEmailAddress.getText().toString(), mTxtComments.getText().toString());		
		feedbackService.insertFeedback(feedback, new TableOperationCallback<Feedback>() {			
			@Override
			public void onCompleted(Feedback entity, Exception exception,
					ServiceFilterResponse response) {				
				if (exception != null) {
					Log.e(TAG, exception.getMessage());
					exception.printStackTrace();
					AlertDialog.Builder builder = new AlertDialog.Builder(activity);
					builder.setMessage(exception.getMessage());
					builder.setTitle("Error");
					builder.create().show();
					return;
				}
				
				//Successfully submitted, finish the activity
				finish();
			}
		});
	}

	private class CommentWatcher implements TextWatcher {		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			int charsLeft = mMaxChars - start - count;
			if (charsLeft >= 0) {
				mLblCharactersLeft.setText(charsLeft + " characters left");
			}
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) { }
		
		@Override
		public void afterTextChanged(Editable s) { }
	}
	
}
