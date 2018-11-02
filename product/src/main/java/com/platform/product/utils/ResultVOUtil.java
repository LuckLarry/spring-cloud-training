package com.platform.product.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.product.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        return resultVO;
    }
}
