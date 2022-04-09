package cn.edu.seu.lone.service.impl;

import cn.edu.seu.lone.common.utils.encrypt.EncryptUtil;
import cn.edu.seu.lone.common.utils.exception.BusinessException;
import cn.edu.seu.lone.common.utils.exception.ComponentException;
import cn.edu.seu.lone.common.utils.exception.enums.ApplicationErrorCodeEnum;
import cn.edu.seu.lone.entity.Company;
import cn.edu.seu.lone.entity.TradeUser;
import cn.edu.seu.lone.entity.repository.CompanyRepository;
import cn.edu.seu.lone.entity.repository.TradeUserRepository;
import cn.edu.seu.lone.service.TradeUserService;
import cn.edu.seu.lone.common.web.vo.TradeUserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2
@RequiredArgsConstructor
public class TradeUserServiceImpl implements TradeUserService {

    private final TradeUserRepository tradeUserRepository;

    private final CompanyRepository companyRepository;

    /**
     * 用户注册功能业务接口
     * @param tradeUserVo
     * @return
     * @throws BusinessException
     * @throws ComponentException
     */
    @Override
    public TradeUser register(TradeUserVo tradeUserVo) throws BusinessException, ComponentException {
        // 1.判断用户是否已经注册
        TradeUser newTradeUser = new TradeUser();
        Integer checkResult = tradeUserRepository.checkRegister(tradeUserVo.getUserNo(), tradeUserVo.getEmail(), tradeUserVo.getPhone());
        if (Objects.nonNull(checkResult) && checkResult > 0) {
            throw new BusinessException(ApplicationErrorCodeEnum.USER_EXISTS);
        }

        // 2.对公司信息做校验（传递的公司是合法的）
        Company company = companyRepository.getById(tradeUserVo.getCompanyId());
        if (Objects.isNull(company)) {
            throw new BusinessException(ApplicationErrorCodeEnum.USER_COMPANY_NOT_FOUND);
        }

        // 3.构造生成用户信息
        BeanUtils.copyProperties(tradeUserVo, newTradeUser);
        newTradeUser.setUserNo(generateUserNo());
        newTradeUser.setPassword(EncryptUtil.encryptSigned(tradeUserVo.getPassword()));

        // 4.完善并冗余必要的用户信息
        newTradeUser.setInstitutionTypeId(company.getInstitutionTypeId());
        newTradeUser.setInstitutionId(company.getInstitutionId());
        tradeUserRepository.save(newTradeUser);

        return newTradeUser;
    }

    // TODO：简化生成
    private String generateUserNo() {
        // 获取用户账号
        return String.valueOf(Math.random());
    }
}
