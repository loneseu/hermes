package cn.edu.seu.lone.entity.repository;

import cn.edu.seu.lone.entity.TradeAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeAccountRepository extends JpaRepository<TradeAccount, Long> {

    /**
     * 创建
     * @param tradeAccount
     * @return
     */
    TradeAccount saveAndFlush(TradeAccount tradeAccount);

    /**
     * 根据账号编号获取交易用户对象
     * @param accountNo
     * @return
     */
    TradeAccount getByAccountNo(String accountNo);
}
