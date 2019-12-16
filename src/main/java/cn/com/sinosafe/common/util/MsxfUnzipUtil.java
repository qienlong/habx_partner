package cn.com.sinosafe.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 * 
 * 马上消费压缩包工具类 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年10月21日<br>
 */
public class MsxfUnzipUtil {
	
	private static final String ALGORITHM = "DESede";

    private static final String PASSWORD_CRYPT_KEY = "poiuytbVMO2XJkroULzYMMvM";

    private static final String ENCODE = "UTF8";

    private static final String HOLDER_FILE_NAME = "null.data";

    /**
     * 解压文件
     * @param zipPath
     * @param outPath
     * @param encryKey
     * @throws Exception
     */
    public static void unzip(String zipPath, String outPath, String encryKey) {
        assert zipPath != null && outPath != null && encryKey != null;
        try {
            // 生成解压密钥
            String decryKey = decryptModeString(encryKey.getBytes(ENCODE));

            // 设置流以解密模式输出
            ZipInputStream zipIn = buildZipInputStream(decryKey, zipPath);

            // 解压文件
            ZipEntry entry;
            while ((entry = (zipIn.getNextEntry())) != null) {
                File outFile = new File(outPath + entry.getName());
                if (!outFile.getParentFile().exists()) {
                    outFile.getParentFile().mkdirs();
                }
                if (!entry.getName().endsWith(HOLDER_FILE_NAME)) {
                    FileOutputStream fos = new FileOutputStream(outFile);
                    IOUtils.copy(zipIn, fos);
                    fos.close();
                }
            }
            zipIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String decryptModeString(byte[] src) throws Exception {
        return new String(decryptMode(Base64.decodeBase64(src), PASSWORD_CRYPT_KEY));
    }

    private static byte[] decryptMode(byte[] src, String key) throws Exception {
        SecretKey deskey = new SecretKeySpec(build3DesKey(key), ALGORITHM);
        Cipher c1 = Cipher.getInstance(ALGORITHM);
        c1.init(Cipher.DECRYPT_MODE, deskey);
        return c1.doFinal(src);
    }

    private static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        byte[] key = new byte[24];
        byte[] temp = keyStr.getBytes(ENCODE);
        if (key.length > temp.length) {
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            System.arraycopy(temp, 0, key, 0, key.length);
        }

        return key;
    }

    private static ZipInputStream buildZipInputStream(String decryKey, String inputPath) throws Exception {
        SecretKey sk = new SecretKeySpec(decryKey.getBytes(), ALGORITHM);
        Cipher c1 = Cipher.getInstance(ALGORITHM);
        c1.init(Cipher.DECRYPT_MODE, sk);
        return new ZipInputStream(new CipherInputStream(new FileInputStream(inputPath), c1));
    }

//    public static void main(String[] args) {
//            unzip("E:\\20200213-filelist.zip",
//                    "E:\\",
//                    "1p/BuWnB12MIlO5B7nAZLXsF6z4xKS0S7YZPLh7NEmU=");
//    }

}
