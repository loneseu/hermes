package cn.edu.seu.lone.auth.service;

import cn.edu.seu.lone.auth.bo.OAuthUser;
import cn.edu.seu.lone.common.utils.constants.GlobalConstants;
import cn.edu.seu.lone.entity.TradeUser;
import cn.edu.seu.lone.entity.repository.TradeUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final TradeUserRepository tradeUserRepository;

    private final CacheManager cacheManager;

    @Override
    public UserDetails loadUserByUsername(String userNo) throws UsernameNotFoundException {
        // 1.查询缓存
        Cache cache = cacheManager.getCache(GlobalConstants.OAUTH_KEY_TRADE_USER_DETAILS);
        if (Objects.nonNull(cache) && Objects.nonNull(cache.get(userNo))) {
            return (UserDetails) Objects.requireNonNull(cache.get(userNo)).get();
        }

        // 2.缓存未找到，查询数据库
        TradeUser tradeUser = tradeUserRepository.findTradeUserByUserNo(userNo);
        if (Objects.isNull(tradeUser)) {
            throw new UsernameNotFoundException(userNo + " not valid!");
        }

        // 3. 对用户信息进行封装
        UserDetails userDetails = new OAuthUser(tradeUser);

        // 4. 将封装的信息放入缓存中
        assert cache != null;
        cache.put(userNo, userDetails);

        return userDetails;
    }
}
