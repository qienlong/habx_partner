package cn.com.sinosafe.common.util;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * RSA加解密工具类 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年7月18日<br>
 */
public class RSAUtils {
	
	private Logger log = LoggerFactory.getLogger(RSAUtils.class);

	/**
     * MD5withRSA 签名方式
     */
    private final String MD5_WITH_RSA = "MD5withRSA";
    /**
     * RSA
     */
    private final String RSA = "RSA";
    /**
     * 字符 “&”
     */
    private final String AND = "&";
    /**
     * 字符 “=”
     */
    private final String EQUAL = "=";
    /**
     * 字符 “”
     */
    private final String BLANK = "";
    /**
     * 文件
     */
    private final String FILE = "file";

    private final String PROVIDER = "BC";
    
    private PublicKey            publicKey;                                       // 对方公钥
    private PrivateKey           privateKey;                                      // 己方私钥
    
    public RSAUtils() {
    	
    }
    
    /**
     * 根据公私钥字符串构造加解密对象
     * 
     * @param publicKeyStr
     * @param privateKeyStr
     * @throws Exception 
     */
    public RSAUtils(String publicKeyStr, String privateKeyStr) {
        if (StringUtils.isNotBlank(publicKeyStr)) {
            this.publicKey = getPublicKey(publicKeyStr);
        }
        if (StringUtils.isNotBlank(privateKeyStr)) {
            this.privateKey = getPrivateKeyFromPKCS8(privateKeyStr);
        }
    }

    /**
     * MD5_WITH_RSA数字签名验证
     *
     * @param content 验签内容
     * @param sign 签名
     * @param publicKeyStr 公钥字符串
     * @return 验证结果
     */
    public boolean verify(String content, String sign) {
        try {
            if (StringUtils.isEmpty(content)) {
                log.error("验签失败，content为空");
                return false;
            }
            if (StringUtils.isEmpty(sign) ){
                log.error("验签失败，sign签名为空");
            }
            Signature signature = Signature.getInstance(MD5_WITH_RSA);
            signature.initVerify(publicKey);
            signature.update(content.getBytes());
            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            log.error("exception message is:{}", e.getMessage());
            return false;
        }
    }

    /**
     * RSA 签名
     *
     * @param content 待签名内容
     * @param privateKeyStr 私钥字符串
     * @return RSA签名字符串
     */
    public String sign(String content) {
        try {
            if (StringUtils.isEmpty(content)) {
                return null;
            }
            Signature signature = Signature.getInstance(MD5_WITH_RSA);
            signature.initSign(privateKey);
            signature.update(content.getBytes());
            byte[] signed = signature.sign();
            return Base64.encodeBase64String(signed);
        } catch (Exception e) {
            log.error("exception message is:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 获取公钥
     *
     * @param publicKeyStr 公钥
     * @return 公钥类
     */
    private PublicKey getPublicKey(String publicKeyStr) {
    	PublicKey key = null;
        try {
			if (StringUtils.isEmpty(publicKeyStr)) {
			    return null;
			}
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			byte[] encodedKey = Base64.decodeBase64(publicKeyStr);
			key = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.error("RSAUtils.getPublicKey 公钥{}加载失败", publicKeyStr, e);
            throw new RuntimeException(String.format("公钥[%s]加载失败", publicKeyStr), e);
        }
        return key;
    }

    /**
     * 获取PKCS8格式私钥
     *
     * @param privateKey 私钥
     * @return 私钥类
     */
    private PrivateKey getPrivateKeyFromPKCS8(String privateKeyStr) {
    	PrivateKey key = null;
        try {
			byte[] encodedKey = Base64.decodeBase64(privateKeyStr);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
			key = KeyFactory.getInstance(RSA).generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.error("RSAUtils.getPrivateKeyFromPKCS8 私钥{}加载失败", privateKeyStr, e);
            throw new RuntimeException(String.format("私钥[%s]加载失败", privateKeyStr), e);
        }
        return key;
    }

    /**
     * 从请求参数中获取待签名字符串
     *
     * @param params 请求参数
     * @return 待签名字符串
     */
    public String getSignCheckContent(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            log.warn("params is null or empty.");
            return BLANK;
        }

        List<String> keys = new ArrayList<>(params.keySet());
        if (StringUtils.isEmpty(keys)) {
            log.warn("params keySet list is empty.");
            return BLANK;
        }
        StringBuilder content = new StringBuilder();
        Collections.sort(keys);
        for (String key : keys) {
            if (key.startsWith(FILE)) {
                log.warn("key contains file, skip.");
                continue;
            }
            String value = params.get(key);
            if (value == null) {
                log.info("getSignCheckContent#value is null, skip. key:" + key);
                continue;
            }
            content.append(AND).append(key).append(EQUAL).append(value);
        }
        String result = content.toString();
        int endIndex = result.length();
        return result.substring(1, endIndex);
    }

    /**
     * RSA 公钥加密
     * @param content
     * @param publicKeyStr
     * @return
     */
    public String encrypt(String content) {
        try {
            if (StringUtils.isEmpty(content)) {
                return null;
            }
            if (publicKey == null) {
                return null;
            }
            // 最大加密长度
            int maxEncryptSize = ((RSAPublicKey) publicKey).getModulus().bitLength() / 8 - 11;
            byte[] contentBytes = content.getBytes();

            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(RSA, PROVIDER);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] bytes = doFinalByMaxSize(cipher, contentBytes, maxEncryptSize);
            return Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            log.error("exception message is:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 分段加解密
     */
    private byte[] doFinalByMaxSize(Cipher cipher, byte[] contentBytes, int maxByteSize) throws Exception {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            int inputLength = contentBytes.length;
            int offSet = 0;
            byte[] tmp;
            while (inputLength - offSet > 0) {
                if (inputLength - offSet > maxByteSize) {
                    tmp = cipher.doFinal(contentBytes, offSet, maxByteSize);
                } else {
                    tmp = cipher.doFinal(contentBytes, offSet, inputLength - offSet);
                }
                outputStream.write(tmp, 0, tmp.length);
                offSet += maxByteSize;
            }
            return outputStream.toByteArray();
        }
    }

    /**
     * 私钥解密
     * @param content
     * @return
     */
    public String decrypt(String content) {
        try {
            if (StringUtils.isEmpty(content)) {
                return null;
            }
            if (privateKey == null) {
                return null;
            }
            int maxDecryptSize = ((RSAPrivateKey) privateKey).getModulus().bitLength() / 8;
            byte[] contentBytes = Base64.decodeBase64(content);

            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(RSA, PROVIDER);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] original = doFinalByMaxSize(cipher, contentBytes, maxDecryptSize);
            return new String(original);
        } catch (Exception e) {
            log.error("exception message is:{}", e.getMessage());
            return null;
        }
    }


}
