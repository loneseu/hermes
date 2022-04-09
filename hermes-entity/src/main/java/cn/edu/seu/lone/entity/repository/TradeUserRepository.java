package cn.edu.seu.lone.entity.repository;

import cn.edu.seu.lone.entity.TradeUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface TradeUserRepository extends Repository<TradeUser, Long> {

    TradeUser findUserByName(String name);

    @Query(value = "select count(1) from tb_trade_user where user_no = ?1 or email = ?2 or phone = ?3", nativeQuery = true)
    Integer checkRegister(String userNo, String email, String phone);

    TradeUser getById(Long id);

    TradeUser save(TradeUser tradeUser);
}
