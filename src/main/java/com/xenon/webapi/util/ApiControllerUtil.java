package com.xenon.webapi.util;

import java.util.HashMap;
import java.util.Map;

public class ApiControllerUtil {

    public static Map<String, Object> generateReturnValue(boolean isSuccessful) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("status", isSuccessful ? "success" : "failure");
        return ret;
    }

}
