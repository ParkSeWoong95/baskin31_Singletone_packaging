package aes256;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 암호화
 * 
 * @param str
 * @return
 * @throws java.io.UnsupportedEncodingException
 * @throws NoSuchAlgorithmException
 * @throws NoSuchPaddingException
 * @throws InvalidKeyException
 * @throws InvalidAlgorithmParameterException
 * @throws IllegalBlockSizeException
 * @throws BadPaddingException
 */

public class AES256 {
	final static String secretKey = "baskinrobbins31yejin199606041230";// 32
	static String IV; // 16

	public static String AES_Encode(String str) {
		try {
			IV = secretKey.substring(0, 16);
			byte[] keyData = secretKey.getBytes();

			SecretKey secureKey = new SecretKeySpec(keyData, "AES");

			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, secureKey,
					new IvParameterSpec(IV.getBytes()));

			byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
			String enStr = new String(Base64.encodeBase64(encrypted));

			return enStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
