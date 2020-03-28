package com.freya.nc.encrypt;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author linjinbo
 * @create 2019-08-06
 * @Descriptioin
 * @since
 */
public class AES implements Crypto<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(AES.class);

    private static final String ALGORITHM_AES = "AES";

    private static final String CHARSET_UTF8 = "utf-8";

    private static final Base64.Encoder BASE64_ENCODER = Base64.getEncoder();

    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();

    @Override
    public String encrypt(Key key, String data) {
        try {
            if (key == null || StringUtils.isEmpty(data)) {
                return null;
            }
            InputStream is = new ByteArrayInputStream(data.getBytes(CHARSET_UTF8));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            encrypt(key, is, os);
            byte[] resBytes = os.toByteArray();
            String res = BASE64_ENCODER.encodeToString(resBytes);
            if (logger.isDebugEnabled()) {
                logger.debug("ASE encrypt success, key is {}, input is {}, result is {}", key, data, res);
            }
            return res;
        } catch (Exception e) {
            logger.error("ASE encrypt failed, caused by {}", e);
        }
        return null;
    }

    @Override
    public String decrypt(Key key, String encryptedData) {
        try {
            if (key == null || StringUtils.isEmpty(encryptedData)) {
                return null;
            }
            InputStream is = new ByteArrayInputStream(BASE64_DECODER.decode(encryptedData));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            decrypt(key, is, os);
            byte[] resBytes = os.toByteArray();
            String res = new String(resBytes);
            if (logger.isDebugEnabled()) {
                logger.debug("ASE decrypt success, key is {}, input is {}, result is {}", key, encryptedData, res);
            }
            return res;
        } catch (Exception e) {
            logger.error("ASE decrypt failed, caused by {}", e);
        }
        return null;
    }

    /**
     * 加密
     *
     * @param in
     * @param out
     * @throws InvalidKeyException
     * @throws ShortBufferException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws IOException
     */
    private void encrypt(Key key, InputStream in, OutputStream out) throws InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        this.crypt(key, in, out, Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     *
     * @param in
     * @param out
     * @throws InvalidKeyException
     * @throws ShortBufferException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws IOException
     */
    private void decrypt(Key key, InputStream in, OutputStream out) throws InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        this.crypt(key, in, out, Cipher.DECRYPT_MODE);
    }

    /**
     * 实际的加密解密过程
     *
     * @param in
     * @param out
     * @param mode
     * @throws IOException
     * @throws ShortBufferException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    private void crypt(Key key, InputStream in, OutputStream out, int mode) throws IOException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
        cipher.init(mode, key);

        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more) {
            inLength = in.read(inBytes);
            if (inLength == blockSize) {
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            } else {
                more = false;
            }
        }
        if (inLength > 0)
            outBytes = cipher.doFinal(inBytes, 0, inLength);
        else
            outBytes = cipher.doFinal();
        out.write(outBytes);
        out.flush();
    }

    /**
     * yuanchengpin
     * 根据秘钥获取KEY
     * @param secret
     * @return Key
     * @Date 2019-08-08 10:50
     */
    public static Key getSecretKey(String secret){
        SecretKey key  = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom(secret.getBytes("utf-8"));
            keyGenerator.init(256,secureRandom);
            key = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static void main(String[] args) {
        //约定好的秘钥
        String secretKey = "==ASED@#$5YUTPLJNT&*%==";
        String content = "BeiJing Finacial Holdings Group";
        AES aes = new AES();
        Key key = AES.getSecretKey(secretKey);
        String contentEncrypt = aes.encrypt(key,content);
        System.out.println("内容加密结果："+contentEncrypt);
        String conentDecrypt = aes.decrypt(key,"5bOp1S3la4BdsVNx07J8qFBHBGMOwmkG2r844lHAlac=");
        System.out.println("内容解密结果:"+conentDecrypt);

    }
    /**
     * Out
     * 内容加密结果：5bOp1S3la4BdsVNx07J8qFBHBGMOwmkG2r844lHAlac=
     * 内容解密结果：BeiJing Finacial Holdings Group
     */
}
