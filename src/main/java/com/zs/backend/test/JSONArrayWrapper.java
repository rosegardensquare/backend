package com.zs.backend.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class JSONArrayWrapper implements Serializable {

    public JSONArrayWrapper() {
    }

    public JSONArrayWrapper(Collection<?> collection) {
        this.setData(collection);
    }

    public JSONArrayWrapper(String jsonArray) {
        this.setData(jsonArray);
    }

    private JSONArray data;

    public JSONArray getData() {
        return data;
    }

    public void setData(Collection<?> collection) {
        if (CollectionUtils.isNotEmpty(collection)) {
            data = JSONArray.parseArray(JSON.toJSONString(collection));
        }
    }

    public void setData(String jsonArray) {
        if (StringUtils.isNotEmpty(jsonArray) && jsonArray.startsWith("[")) {
            data = JSONArray.parseArray(jsonArray);
        }
    }

    public <T> List<T> getData(Class<T> targetClass) {
        if (data == null) {
            return null;
        }
        return JSONObject.parseArray(data.toJSONString(), targetClass);
    }
}
