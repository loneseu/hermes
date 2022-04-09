package cn.edu.seu.lone.auth.controller;

import cn.edu.seu.lone.common.utils.constants.GlobalConstants;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.CacheManager;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/token")
@Log4j2
@AllArgsConstructor
public class AuthTokenController {

    private final TokenStore tokenStore;

    private final CacheManager cacheManager;

    private static final String OAUTH_ACCESS = GlobalConstants.OAUTH_PREFIX_KEY;
}
