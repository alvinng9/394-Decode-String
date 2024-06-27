package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void decodeStringTest() {
        Solution solution = new Solution();
        Assert.assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
    }

}