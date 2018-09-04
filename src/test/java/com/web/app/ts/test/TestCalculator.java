package com.web.app.ts.test;

import javafx.beans.binding.When;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.web.app.ts.Calculator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestCalculator {
	
	@Mock
	private Calculator calc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}
	@Test
	public void testAbs(){
		//when(calc.abs(-20)).thenReturn(-20);
		when(calc.abs(-20)).thenReturn(4);
		assertEquals(4, calc.abs(-20));
		
	}

}
