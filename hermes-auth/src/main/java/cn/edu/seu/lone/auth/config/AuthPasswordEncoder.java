package cn.edu.seu.lone.auth.config;

import cn.edu.seu.lone.common.utils.encrypt.EncryptUtil;
import cn.edu.seu.lone.common.utils.exception.ComponentException;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AuthPasswordEncoder implements PasswordEncoder {

    /**
     * 密码编码处理
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    /**
     * 密码校验判断处理
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if(rawPassword != null && rawPassword.length() > 0){
            try {
                // 这里通过MD5及B64加密
                String password = EncryptUtil.encryptSigned(rawPassword.toString());
                boolean isMatch= encodedPassword.equals(password);
                if(!isMatch) {
                    log.warn("password 不一致！");
                }
                return isMatch;
            } catch (ComponentException e) {
                log.error(e.getMessage(), e);
            }
        }
        return false;
    }
}
