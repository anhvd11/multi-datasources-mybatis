package com.test.anhvdweb.utils;

/**
 * Application constants.
 */
public final class Constants {
	// Regex for acceptable logins
	public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

	public class MOBI_FILE {
		public class CONTENT {
			public static final String HEADER = "Transaction ID,Transaction Date,Amount,Card Number,Card Holder Name,Issuer,Currency Code,Merchant Transaction ID|Merchant ID|Checksum";
			public static final String PRIVATE_KEY = "123456";
			public static final String PIPE_SYMBOL = "|";
		}
	}

	public class DIRECTORY {
		public static final String EXPORT_PATH = "F:\\DEV_TEST\\exportFile\\";
		public static final String IMPORT_PATH = "F:\\DEV_TEST\\importFile\\";
	}

	private Constants() {
	}
}
