package atos;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

class GUITest {

    @Test
    public void is123Numeric() {
        Assert.assertTrue(GUI.isNumeric("123"));
    }

    @Test
    public void is12309Numeric() {
        Assert.assertTrue(GUI.isNumeric("123.09"));
    }

    @Test
    public void isASDNumeric() {
        Assert.assertFalse(GUI.isNumeric("ASD"));
    }

    @Test
    public void is123ASDNumeric() {
        Assert.assertFalse(GUI.isNumeric("123ASD"));
    }

    @Test
    public void is123ASD09Numeric() {
        Assert.assertFalse(GUI.isNumeric("123ASD.09"));
    }
}