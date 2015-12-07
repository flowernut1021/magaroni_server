package org.magaroni.conftype;

/**
 * Created by qiaorongrong on 12/8/15.
 */
public enum OrderStatus {

	INIT("create order"),
	PROGRESS("not pay yet"),
	CANCEL("cancel"),
	OVERDUE("over_due"),
	DONE("payed");

	String desc;

	OrderStatus(String desc) {
		this.desc = desc;
	}
}
