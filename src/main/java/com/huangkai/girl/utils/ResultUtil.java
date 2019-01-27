package com.huangkai.girl.utils;

import com.huangkai.girl.domain.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("Succeeded!");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String meg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(meg);
        result.setData(null);
        return result;
    }
}
