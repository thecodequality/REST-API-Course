package files;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomValues {

		/**
		 * Used to generate random string of specified length
		 * @param length
		 * @return random string of specified length
		 */
		public static String generateRandomString(int length) {
			return RandomStringUtils.randomAlphanumeric(length);
		}
		
		/**
		 * Used to generate random number of specified length
		 * @param length
		 * @return random number of specified length
		 */
		public static String generateRandomNumber(int length) {
			return RandomStringUtils.randomNumeric(length);
		}



}
