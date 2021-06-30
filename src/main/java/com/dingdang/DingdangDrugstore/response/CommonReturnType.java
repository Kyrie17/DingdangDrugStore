package com.dingdang.DingdangDrugstore.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/2/20 23:11
 */
@Getter
@Setter
public class CommonReturnType {

    // 对应请求返回处理结果，success或fail
    private String status;

    // 若status=success，则data内返回前端需要的json数据
    // 若status=fail，则data内使用通用的错误码格式
    private Object data;

    // 定义一个通用的创建方法
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create("success", result);
    }

    public static CommonReturnType create(String status, Object result) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
}
