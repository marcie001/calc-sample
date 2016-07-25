/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marcie
 */
public class RpnCalcTest {

	private RpnCalc target;

	@Before
	public void before() {
		target = new RpnCalc();
	}

	@Test
	public void execute_1plus1eq2() {
		Assert.assertEquals("1+1=2", new BigDecimal(2), target.execute("1", "1", "+"));
	}

	@Test
	public void execute_10devided4eq2point5() {
		Assert.assertEquals("10/4=2.5", new BigDecimal("2.5"), target.execute("10", "4", "/"));
	}

	@Test
	public void execute_Ok() {
		Assert.assertEquals("9 - 26 / (3 + 5) * 5", new BigDecimal("-7.25"), target.execute("9", "26", "3", "5", "+", "/", "5", "*", "-"));
	}

	@Test(expected = NumberFormatException.class)
	public void execute_NotNumber() {
		target.execute("a", "1", "+");
	}

	@Test(expected = NoSuchElementException.class)
	public void execute_Rpn() {
		target.execute("+", "1", "1");
	}

	@Test(expected = NoSuchElementException.class)
	public void execute_In() {
		target.execute("1", "+", "1");
	}

}
