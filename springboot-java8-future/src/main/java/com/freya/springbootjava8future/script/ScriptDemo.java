package com.freya.springbootjava8future.script;

import org.apache.commons.lang3.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Version 0.0.1
 * @Description ScriptDemo
 * @Date 2020-11-14 15:08
 * @Author Cheng Pin.Y & Nick
 */
public class ScriptDemo {
    public static void main(String[] args) {
        System.out.println(eval(100,">=",10));
    }
    /**
     * 基于字符串比较表达式返回结果的方法 如“100 >= 1000”
     *
     * @param first  比较值
     * @param symbol 符号 如 >,>=...
     * @param second 被比较值
     * @return
     */
    public static boolean eval(Number first, String symbol, Number second) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("js");
        try {
            StringBuilder evalBuilder = new StringBuilder();
            evalBuilder.append(first);
            evalBuilder.append(StringUtils.SPACE);
            evalBuilder.append(symbol);
            evalBuilder.append(StringUtils.SPACE);
            evalBuilder.append(second);
            boolean flag = (boolean) scriptEngine.eval(evalBuilder.toString());
            return flag;
        } catch (ScriptException e) {
            return false;
        }
    }
}
