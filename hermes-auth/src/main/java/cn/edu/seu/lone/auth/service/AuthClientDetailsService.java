package cn.edu.seu.lone.auth.service;

import cn.edu.seu.lone.common.utils.constants.GlobalConstants;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import org.springframework.cache.annotation.Cacheable;
import javax.sql.DataSource;

public class AuthClientDetailsService extends JdbcClientDetailsService {

    public AuthClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    /**
     *
     * 重写父类方法, 对客户端信息的获取, 加入缓存处理
     * @param clientId
     * @return
     * @throws InvalidClientException
     */

    @Override
    @Cacheable(value = GlobalConstants.OAUTH_KEY_CLIENT_DETAILS, key="#clientId", unless = "#result == null ")
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        return super.loadClientByClientId(clientId);
    }
}
