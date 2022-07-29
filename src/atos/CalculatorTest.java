package atos;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.File;

class CalculatorTest {
    private final Calculator calculator = new Calculator(new File("eurofxref-daily.xml"));
    @Test
    public void getUSDCalculatedValue() {
        Assert.assertEquals(calculator.getCalculatedValue(10, "USD"), "10.15");
    }

    @Test
    public void getCZKCalculatedValue() {
        Assert.assertEquals(calculator.getCalculatedValue(10, "CZK"), "245.75");
    }

    @Test
    public void getPLNCalculatedValue() {
        Assert.assertEquals(calculator.getCalculatedValue(10, "PLN"), "47.98");
    }

    @Test
    public void getISKCalculatedValue() {
        Assert.assertEquals(calculator.getCalculatedValue(10, "ISK"), "1391");
    }

    @Test
    public void getCNYCalculatedValue() {
        Assert.assertEquals(calculator.getCalculatedValue(10, "CNY"), "68.53");
    }

    @Test
    public void getMXNCalculatedValue() {
        Assert.assertEquals(calculator.getCalculatedValue(10, "MXN"), "207.53");
    }

    @Test
    public void getZARCalculatedValue() {
        Assert.assertEquals(calculator.getCalculatedValue(10, "ZAR"), "171.35");
    }



}