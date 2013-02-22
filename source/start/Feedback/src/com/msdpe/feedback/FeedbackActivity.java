package com.msdpe.feedback;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class FeedbackActivity extends Activity {
	
	private final String TAG = "FeedbackActivity";
	private EditText mTxtComments;
	private TextView mLblCharactersLeft;
	private int mMaxChars;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);

		mLblCharactersLeft = (TextView) findViewById(R.id.lblCharactersLeft);
		mTxtComments = (EditText) findViewById(R.id.txtComments);
		mTxtComments.addTextChangedListener(new CommentWatcher());
		//Set max character limit
		InputFilter[] FilterArray = new InputFilter[1];
		mMaxChars = getResources().getInteger(R.integer.comments_max_length);
		FilterArray[0] = new InputFilter.LengthFilter(mMaxChars);
		mTxtComments.setFilters(FilterArray);
		mLblCharactersLeft.setText(mMaxChars + " characters left");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_feedback, menu);
		return true;
	}
	
	private void submitFeedback() {
		
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
