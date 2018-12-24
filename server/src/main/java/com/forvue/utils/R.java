package com.forvue.utils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by gqc on 2018/12/18.
 */
public class R extends Hashtable<String, Object>{
    private String status;
    public R() {
        put("code", 0);
        put("msg", "success");
    }
    public static R error(){
        return error(500,"发生错误");

    }
    public static R error(String msg) {
        return error(500, msg);
    }
    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }
    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
