package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaFunctionHandler implements RequestHandler<CalculatorInput, CalculatorOutput> {

	@Override
	public CalculatorOutput handleRequest(CalculatorInput input, Context context) {
		// context.getLogger().log("input value is "+input.getInput());
		// TODO Auto-generated method stub

		CalculatorOutput output = new CalculatorOutput();
		try {
			output = calculate(input, output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			output.setOutputString("An error occoured while processing");
			e.printStackTrace();
		}

		return output;
	}

	private CalculatorOutput calculate(CalculatorInput input, CalculatorOutput output) {
		long number1 = input.getNumber1();
		long number2 = input.getNumber2();
		String operand = input.getOperand();

		long outputVal = 0;
		String outputString = "";
		switch (operand) {
		case "+":
			outputVal = number1 + number2;
			outputString =number1 +" + "+number2+" = "+outputVal;
			break;
		case "-":
			outputVal = number1 - number2;
			outputString =number1 +" - "+number2+" = "+outputVal;
			break;
		case "*":
			outputVal = number1 * number2;
			outputString =number1 +" * "+number2+" = "+outputVal;
			break;
		case "/":
			outputVal = number1 / number2;
			outputString =number1 +" / "+number2+" = "+outputVal;
			break;

		}

		output.setOutput(outputVal);
		output.setOutputString(outputString);
		return output;
	}
	
	

}
