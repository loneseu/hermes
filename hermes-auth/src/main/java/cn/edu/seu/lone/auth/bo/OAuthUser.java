package cn.edu.seu.lone.auth.bo;

import cn.edu.seu.lone.entity.TradeUser;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class OAuthUser extends User {

    private static final long serialVersionUUID = -1L;
    /**
     * 业务用户信息
     */
    private final TradeUser tradeUser;

    public OAuthUser(TradeUser tradeUser) {
        // OAUTH2 认证用户信息构造处理
        super(tradeUser.getUserNo(), tradeUser.getPassword(), tradeUser.getStatus() == 1,
                true, true, tradeUser.getStatus() == 1,
                Collections.emptyList());
        this.tradeUser = tradeUser;
    }

    public TradeUser getTradeUser() {
        return tradeUser;
    }
}
