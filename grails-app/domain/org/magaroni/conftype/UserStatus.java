package org.magaroni.conftype;

/**
 * Created by qiaorongrong on 12/7/15.
 */
public enum UserStatus {

	VALID ("valid user"),
	INVALID ("invalid user");

	String description;

	UserStatus(String description) {
		this.description = description;
	}
}
