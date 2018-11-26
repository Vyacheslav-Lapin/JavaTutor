package com.luxoft.training.java2.module1;



public class ClassCastTutor  {

	/**
	 * Возвращает строку, полученную из числа
	 */
	public String getString(int i) {
		return String.valueOf(i);
	}
	
	/**
	 *  Возвращает число типа int, полученное из строки 
	 */
	public int getInt(String i) {
		return Integer.valueOf(i);
	}
	
	/**
	 * Возвращает строковое представление для числа d
	 */
	public String getString(double d) {
		return String.valueOf(d);
	}
		
}
