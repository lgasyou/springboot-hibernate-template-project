package com.xenon.xenonweb.util;

import java.util.HashMap;
import java.util.Map;

public class ControllerUtil {

    public static Map<String, Object> generateReturnValue(boolean isSucceed) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("status", isSucceed ? "success" : "failure");
        return ret;
    }

}
