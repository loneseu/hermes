package cn.edu.seu.lone.hermes.user.controller;

import cn.edu.seu.lone.common.utils.exception.BusinessException;
import cn.edu.seu.lone.common.utils.exception.ComponentException;
import cn.edu.seu.lone.common.web.vo.ApiRespResult;
import cn.edu.seu.lone.common.web.vo.TradeUserVo;
import cn.edu.seu.lone.entity.TradeUser;
import cn.edu.seu.lone.service.TradeUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Log4j2
@Validated
@RequiredArgsConstructor
public class TradeUserController {

    private final TradeUserService tradeUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiRespResult<TradeUser> register(@Valid TradeUserVo tradeUserVo) {

        ApiRespResult<TradeUser> result = null;

        try {
            TradeUser newTradeUser = tradeUserService.register(tradeUserVo);
            result = ApiRespResult.success(newTradeUser);
        } catch (BusinessException e) {
            log.error(e.getMessage(), e);
            result = ApiRespResult.error(e.getErrorCodeEnum());
        } catch (ComponentException e) {
            log.error(e.getMessage(), e);
            result = ApiRespResult.error(e.getErrorCodeEnum());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result = ApiRespResult.systemError(e.getMessage());
        }
        return result;
    }
}
