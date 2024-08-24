package com.zyl.transapp.controller.merchants;

import com.zyl.common.dto.merchants.MerchantsLoginDTO;
import com.zyl.common.dto.merchants.MerchantsSaveDTO;
import com.zyl.common.dto.merchants.TokenDTO;
import com.zyl.common.web.EmptyMeta;
import com.zyl.common.web.ResponseBody;
import com.zyl.transapp.service.merchants.MerchantsService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

/**
 * 商家控制层
 *
 * @author zyl
 */
@Validated
@RestController
@RequestMapping("merchants")
public class MerchantsController {

    @Resource
    private MerchantsService merchantsService;


    @PostMapping
    public ResponseBody<Void, EmptyMeta> saveMerchants(@RequestBody @Validated MerchantsSaveDTO merchantsSaveDTO) {
        merchantsService.saveMerchants(merchantsSaveDTO);
        return ResponseBody.success(null);
    }


    @PostMapping("login")
    public ResponseBody<TokenDTO, EmptyMeta> login(@RequestBody @Validated MerchantsLoginDTO merchantsLoginDTO) {
        TokenDTO tokenDTO = merchantsService.login(merchantsLoginDTO);
        return ResponseBody.success(tokenDTO);
    }
}
