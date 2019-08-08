package cn.wangz.clientutil.web;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * java 调用 JavaScript 脚本
 */
public class JavaScriptUtils {

    private static ScriptEngineManager manager;
    private static ScriptEngine engine;
    static {
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
    }

    public ScriptEngine getScriptEngine() {
        return engine;
    }

    public static Object eval(String jsStr) {
        Object result = null;
        try {
            if (engine != null) {
                result = engine.eval(jsStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void put(String key, Object value) {
        try {
            if (engine != null) {
                engine.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object get(String name) {
        Object result = null;
        try {
            if (engine != null) {
                result = engine.get(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object invokeFunction(String name, Object... args) {
        Object result = null;
        try {
            if (engine != null) {
                Invocable inv = (Invocable) engine;
                result = inv.invokeFunction(name, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
