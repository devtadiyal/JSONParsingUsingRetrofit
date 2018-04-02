package com.androiddeft.jsonretrofit.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Request1  {
    
	@SerializedName("phone")
	@Expose
	public long phone;

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getSocialID() {
		return socialID;
	}

	public void setSocialID(int socialID) {
		this.socialID = socialID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@SerializedName("socialID")
	@Expose
	public int socialID;
    
	@SerializedName("firstName")
	@Expose
	public String firstName;
    
	@SerializedName("lastName")
	@Expose
	public String lastName;
    
	@SerializedName("password")
	@Expose
	public String password;
    
	@SerializedName("email")
	@Expose
	public String email;
    
    public Request1() {}
}