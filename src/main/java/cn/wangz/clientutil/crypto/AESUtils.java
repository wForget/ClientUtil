package cn.wangz.clientutil.crypto;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by hadoop on 2019/3/15.
 */
public class AESUtils {

    /**
     * AES加密
     *
     * @param content 明文
     * @param key 加密key
     * @return 密文
     */
    public static byte[] encrypt(byte[] content, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
            return cipher.doFinal(content);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * AES解密
     *
     * @param ciphertext 密文
     * @param key 解密key
     * @return 明文
     */
    public static byte[] decrypt(byte[] ciphertext, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
            return cipher.doFinal(ciphertext);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] getKey(String random) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128);
        keyGenerator.init(128, new SecureRandom(random.getBytes())); // 使用这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    public static void main(String[] args) throws Exception {
        byte[] key = getKey("wforget");
        System.out.println("key: " + new String(Base64.encodeBase64(key)));
        String source = "{\"test\":\"test\"}";
        String ensource = new String(Base64.encodeBase64(encrypt(source.getBytes(), key)));
        System.out.println("ensource: " + ensource);
        String desource = new String(decrypt(Base64.decodeBase64(ensource.getBytes()), key));
        System.out.println("decrypt: " + desource);
    }

}
