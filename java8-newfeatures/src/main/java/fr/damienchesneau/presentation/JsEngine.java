package fr.damienchesneau.presentation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class JsEngine {
    public static void main(String[] d) {

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JavaScript");
        try {
            engine.eval("function sum(a, b) { return a+b; }");
            System.out.println(engine.eval("sum(1, 2);"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}
