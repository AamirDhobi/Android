package com.msdpe.feedback;

public class Feedback {
	@com.google.gson.annotations.SerializedName("rating")
	private int mRating;
	
	@com.google.gson.annotations.SerializedName("email")
	private String mEmail;
	
	@com.google.gson.annotations.SerializedName("comments")
	private String mComments;

	@com.google.gson.annotations.SerializedName("id")
	private int mId;

	public Feedback() {

	}
	
	public Feedback(int rating, String email, String comments) {
		mRating = rating;
		mEmail = email;
		mComments = comments;
	}
	
	public int getRating() { return mRating; }
	public void setRating(int rating) { mRating = rating; }
	
	public String getEmail() { return mEmail; }
	public void setEmail(String email) { mEmail = email; }
	
	public String getComments() { return mComments; }
	public void setComments(String comments) { mComments = comments; }

	public int getId() {
		return mId;
	}

	public final void setId(int id) {
		mId = id;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Feedback && ((Feedback) o).mId == mId;
	}
}
