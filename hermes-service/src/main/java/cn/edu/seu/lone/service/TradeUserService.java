package cn.edu.seu.lone.service;

import cn.edu.seu.lone.common.utils.exception.BusinessException;
import cn.edu.seu.lone.common.utils.exception.ComponentException;
import cn.edu.seu.lone.common.web.vo.TradeUserVo;
import cn.edu.seu.lone.entity.TradeUser;

public interface TradeUserService {

    TradeUser register(TradeUserVo tradeUserVo) throws BusinessException, ComponentException;
}
