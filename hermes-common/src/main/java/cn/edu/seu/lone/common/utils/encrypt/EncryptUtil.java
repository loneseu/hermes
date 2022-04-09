package cn.edu.seu.lone.common.utils.encrypt;


import cn.edu.seu.lone.common.utils.exception.ComponentException;
import cn.edu.seu.lone.common.utils.exception.enums.ApplicationErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class EncryptUtil {

    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static String encryptSigned(String signed) throws ComponentException {

        try {
            byte[] md5SignStr = MD5EncryptReturnHexDigitsByteArray(signed);
            return Base64Encrypt(md5SignStr);
        }catch(Exception e) {
            throw new ComponentException(ApplicationErrorCodeEnum.SYS_ERROR_ENCRYPT_SINGED,
                    "BASE64或MD5加密签名错误！signed=" + signed + ", error=" + e.getMessage());
        }
    }

    /**
     *
     * @param str
     * @return
     */
    public static byte[] MD5EncryptReturnHexDigitsByteArray(String str) {
        try {
            byte[] res = str.getBytes(StandardCharsets.UTF_8);
            MessageDigest mdTemp = MessageDigest.getInstance("MD5".toUpperCase());
            mdTemp.update(res);
            return mdTemp.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static String Base64Encrypt(byte[] key) throws ComponentException {
        String encryptData = null;
        try {
            encryptData = Arrays.toString(Base64.getDecoder().decode(key));
        } catch (Exception e) {
            throw new ComponentException(ApplicationErrorCodeEnum.SYS_ERROR_ENCRYPT_SINGED,
                    "Base64编码错误！key=" + new String(key) + ", error=" + e.getMessage());
        }
        return encryptData;
    }

}
