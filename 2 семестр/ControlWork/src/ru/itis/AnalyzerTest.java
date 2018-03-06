package ru.itis;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

public class AnalyzerTest {
    private Analyzer analyzer;
    private LinkedHashMap<String, Integer> map;

    @Before
    public void setUp(){
        analyzer = new Analyzer();
        map = new LinkedHashMap<>();
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze1(){
        String input = "X1:==128;Y2:=13;Z1:=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze2(){
        String input = "X1:=128d;Y2:=13;Z1:=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze3(){
        String input = "x1:=128;Y2:=13;Z1:=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze4(){
        String input = "X1:=128;=Y2:=13;Z1:=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze5(){
        String input = "X1:=128;Y2:=1t3;Z1:=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze6(){
        String input = "X1:=128;Y2:=13;Z1:=X1+1Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze7(){
        String input = "X1:=128;Y2:=13;Z1:=X1+Y2";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze8(){
        String input = "X1:=128;Y2:=13;Z1:=X1)Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze9(){
        String input = "X1:=128;Y2:=13;Z1:=X1++Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze10(){
        String input = "X1:=128;Y2:=13;Z1=X1++Y2;";
        analyzer.analyze(input);
    }

    @Test
    public void testAnalyze11(){
        String input = "X1:=128;Y2:=13;Z1:=X1+Y2;";
        analyzer.analyze(input);
        Assert.assertEquals(0, analyzer.getState());
    }

    @Test
    public void testAnalyze12(){
        String input = "X1:=124548;Y2:=Z2-T5;Z1:=X1+Y2;C2:=G5/H5;";
        analyzer.analyze(input);
        Assert.assertEquals(0, analyzer.getState());
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze13(){
        String input = "X1:=128;Y2:=13;Z1=X1+Y2;A";
        analyzer.analyze(input);
    }

    @Test
    public void testAnalyze14(){
        analyzer.analyze(null);
        Assert.assertEquals(0, analyzer.getState());
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze15(){
        String input = "X1:=128;YY:=13;Z1=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze16(){
        String input = "X1:128;Y2:=13;Z1=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze17(){
        String input = "X1:=+128;Y1:=13;Z1=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test(expected = SyntaxException.class)
    public void testAnalyze18(){
        String input = "1:=128;Y3:=13;Z1=X1+Y2;";
        analyzer.analyze(input);
    }

    @Test
    public void testAnalyze19(){
        String input = "X1:=124548;Y2:=Z2;Z1:=X1+Y2;C2:=G5/H5;";
        analyzer.analyze(input);
        Assert.assertEquals(0, analyzer.getState());
    }

    @Test
    public void testProcess1(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-Y2*C3/Y2*X1;Z1:=X1-Y2;Z2:=Y2/X1;Z3:=Z1-Z2;Z4:=X1;X1:=34;Z5:=-Z2*Y2;Z6:=-2;";
        map.put("Y2", 24);
        map.put("C3", 5);
        map.put("V4", -24);
        map.put("Z1", -12);
        map.put("Z2", 2);
        map.put("Z3", -14);
        map.put("Z4", 12);
        map.put("X1", 34);
        map.put("Z5", -48);
        map.put("Z6", -2);
        Assert.assertEquals(map, analyzer.process(input));
    }

    @Test(expected = NotFoundVariableException.class)
    public void testProcess2(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-C3*Y2/Y2*Z1;Z1:=X1+Y2;Z2:=Y2/X1;Z3:=Z1-Z2;Z4:=X1;X1:=34;Z4:=Z2*Y2;";
        analyzer.process(input);
    }

    @Test(expected = NotFoundVariableException.class)
    public void testProcess3(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-C3*Y2/Y2*X1;Z1:=X1+Y2;Z2:=Y2/T1;Z3:=Z1-Z2;Z4:=X1;X1:=34;Z4:=Z2*Y2;";
        analyzer.process(input);
    }

    @Test
    public void testProcess4(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-C3*Y2/Y2*X1;Z1:=X1+Y2;Z2:=Y2/X1;Z3:=Z1-Z2;Z4:=X1;X1:=34;Z4:=Z2*Y2;";
        map.put("Y2", 24);
        map.put("C3", 5);
        map.put("V4", 84);
        map.put("Z1", 36);
        map.put("Z2", 2);
        map.put("Z3", 34);
        map.put("X1", 34);
        map.put("Z4", 48);
        Assert.assertEquals(map, analyzer.process(input));
    }

    @Test
    public void testProcess5(){
        String input = "X1:=124;Y2:=0;Z1:=Y2;C2:=Y2/X1;Z3:=X1*Y2;C4:=Y2+X1-Y2;C5:=Y2+Y2+Y2-Y2*Y2;";
        map.put("X1", 124);
        map.put("Y2", 0);
        map.put("Z1", 0);
        map.put("C2", 0);
        map.put("Z3", 0);
        map.put("C4", 124);
        map.put("C5", 0);
        Assert.assertEquals(map, analyzer.process(input));
    }

    @Test(expected = RuntimeException.class)
    public void testProcess6(){
        String input = "X1:=124548;Y2:=X1-X1;Z1:=0;C2:=X1/Z1;";
        analyzer.process(input);
    }

    @Test(expected = NotFoundVariableException.class)
    public void testProcess7(){
        String input = "X1:=12;Y2:=24;C3:=5;V4:=X1-C3*Y2/Y2*X1;Z1:=X1+Y2;Z2:=Y2/T1;Z3:=Z1-Z2;Z4:=X1;X1:=Z5;Z4:=Z2*Y2;";
        analyzer.process(input);
    }

    @Test
    public void testProcess8(){
        String input = "X1:=-2;X2:=-X1;X3:=X2/X1;X4:=X1*X2;X5:=-X1*X2;";
        map.put("X1", -2);
        map.put("X2", 2);
        map.put("X3", -1);
        map.put("X4", -4);
        map.put("X5", 4);
        Assert.assertEquals(map, analyzer.process(input));
    }
}
