package com.example.mycalculator;

import junit.framework.TestCase;

import javax.script.ScriptException;

public class EvaluateTest extends TestCase {

    public void testEvaluate_add() throws ScriptException {
        Evaluate e = new Evaluate();
        double actual = e.evaluate("2+2").doubleValue();
        double expected = 4.0;
        assertEquals(expected, actual);
    }

    public void testEvaluate_add_failed() throws ScriptException {
        Evaluate e = new Evaluate();
        double actual = e.evaluate("2+2").doubleValue();
        double expected = 5.0;
        assertEquals(expected, actual);
    }
}