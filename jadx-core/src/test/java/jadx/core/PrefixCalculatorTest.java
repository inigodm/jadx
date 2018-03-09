package jadx.core;

import jadx.core.deobf.PrefixCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrefixCalculatorTest {
    @Test
    public void testGenerateName(){
        PrefixCalculator pc = new PrefixCalculator("nounsTest.txt");
        assertEquals("aardvark", pc.getNextName());
        assertEquals("abacus", pc.getNextName());
        assertEquals("abbey", pc.getNextName());
        assertEquals("aardvarkAbacus", pc.getNextName());
        assertEquals("aardvarkAbbey", pc.getNextName());
        assertEquals("abacusAardvark", pc.getNextName());
        assertEquals("abacusAbbey", pc.getNextName());
        assertEquals("abbeyAardvark", pc.getNextName());
        assertEquals("abbeyAbacus", pc.getNextName());
        assertEquals("aardvarkAardvarkAbacus", pc.getNextName());
        assertEquals("aardvarkAardvarkAbbey", pc.getNextName());
        assertEquals("aardvarkAbacusAardvark", pc.getNextName());
        //assertTrue(pc.getNextName().equals("aardvarkAbacus"));
        //assertTrue(pc.getNextName().equals("aardvarkAbbey"));
        //assertTrue(pc.getNextName().equals("abacusAardvark"));
    }
}

