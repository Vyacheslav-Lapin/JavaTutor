package com.luxoft.exceptions;

public class OverDraftLimitExceededException extends NoEnoughFundsException {

	public OverDraftLimitExceededException(final double amount) {
		super(amount);
	}

}
