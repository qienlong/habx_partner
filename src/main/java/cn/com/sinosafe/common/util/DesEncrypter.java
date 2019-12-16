package cn.com.sinosafe.common.util;


import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.binary.Base64;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Description : 加密类 <br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2016年10月27日<br>
 */
public class DesEncrypter {
	Cipher ecipher;
	Cipher dcipher;
	byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
			(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };

	/**
	 * 构造方法
	 * 
	 * @param passPhrase
	 *            将用户的apikey作为密钥传入
	 * @throws Exception
	 */
	public DesEncrypter(String passPhrase) throws Exception {
		int iterationCount = 2;
		KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray());
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
		ecipher = Cipher.getInstance(key.getAlgorithm());
		dcipher = Cipher.getInstance(key.getAlgorithm());
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,iterationCount);
		ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
	}

	/**
	 * 加密
	 * 
	 * @param str
	 *            要加密的字符串
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String str) throws Exception {
		//str = new String(str.getBytes(), "UTF-8");
		return Base64.encodeBase64String(ecipher.doFinal(str.getBytes("UTF-8")));
	}

	/**
	 * 解密
	 * 
	 * @param str
	 *            要解密的字符串
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String str) throws Exception {
		return new String(dcipher.doFinal(Base64.decodeBase64(str)), "UTF-8");
	}

	/*public static void main(String[] args) throws Exception {
		String key = "SanXiangBankjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqrJDzzbIEbNwFBZCuCGOYImlzX9RsNKrpsZDKBFvgw";
		DesEncrypter desEncrypter = new DesEncrypter(key);
		// str为加密前的参数字符串
		String str = "idCardName=马战&idCardCode=130622198104023650";
		System.out.println(desEncrypter.encrypt(str));
        String s="xK4oqKftAt6hJ2QGqKJOvdg+U+ZNStNcN7u6y5IGEyna9gCUNjZyYV/xXCC0jMxf";		
		System.out.println(desEncrypter.decrypt(s));
	}*/
}