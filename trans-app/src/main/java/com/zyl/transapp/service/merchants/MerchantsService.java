package com.zyl.transapp.service.merchants;

import com.zyl.common.SaltPassword;
import com.zyl.common.dto.merchants.MerchantsLoginDTO;
import com.zyl.common.dto.merchants.MerchantsSaveDTO;
import com.zyl.common.dto.merchants.TokenDTO;
import com.zyl.common.exception.BusinessException;
import com.zyl.entity.Merchants;
import com.zyl.repository.MerchantsRepository;
import com.zyl.utils.CodeUtils;
import com.zyl.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 商家业务
 *
 * @author zyl
 */
@Service
public class MerchantsService {

    private final MerchantsRepository merchantsRepository;

    @Value("${token.sign}")
    private String sign;

    @Value("${token.refreshSign}")
    private String refreshSign;

    public MerchantsService(MerchantsRepository merchantsRepository) {
        this.merchantsRepository = merchantsRepository;
    }

    /**
     * 保存商家
     *
     * @param merchantsSaveDTO 商家数据
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveMerchants(MerchantsSaveDTO merchantsSaveDTO) {
        Merchants merchants = merchantsRepository.findByUserName(merchantsSaveDTO.getUserName());
        if (Objects.nonNull(merchants)) {
            throw new BusinessException("user_name exist!");
        }
        merchants = new Merchants();
        SaltPassword saltPassword = CodeUtils.generatePassword(merchantsSaveDTO.getPassword());
        merchants.setSalt(saltPassword.getSalt());
        merchants.setPassword(saltPassword.getWarpPassword());
        merchants.setUserName(merchantsSaveDTO.getUserName());
        merchantsRepository.save(merchants);
    }

    public TokenDTO login(MerchantsLoginDTO loginDTO) {
        Merchants merchants = merchantsRepository.findByUserName(loginDTO.getUserName());
        if (Objects.isNull(merchants)) {
            throw new BusinessException("account not exist!");
        }
        boolean success = CodeUtils.validatePassword(merchants.getSalt(), loginDTO.getPassword(), merchants.getPassword());
        if (!success) {
            throw new BusinessException("password is wrong!");
        }
        return JwtUtils.generateToken(merchants.getMerchantsId(), sign, refreshSign);
    }
}
