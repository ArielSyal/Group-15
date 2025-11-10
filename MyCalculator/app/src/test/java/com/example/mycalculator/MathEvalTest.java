package com.example.mycalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathEvalTest {

    /**
     * Testing the evaluation method in the MathEval class with junit local test,
     * this test will succeed
     */
    @Test
    public void eval() {
        assertEquals("4", MathEval.eval("2+2"));
        assertEquals("0", MathEval.eval("2-2"));
        assertEquals("8", MathEval.eval("2*4"));
        assertEquals("2", MathEval.eval("4/2"));
    }


}