package com.dingdang.DingdangDrugstore.error;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/2/20 23:41
 */
public interface CommonError {

    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);
}
