/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marcie
 */
public class Constants {

	public static final MathContext MATH_CONTEXT = new MathContext(10, RoundingMode.CEILING);

	public static final List<String> OPERATORS = Arrays.asList("+", "-", "/", "*");

}
