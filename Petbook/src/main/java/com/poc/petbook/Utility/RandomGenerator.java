package com.poc.petbook.Utility;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomGenerator {
	
	public static final String character = "ABCDEFGHIJKMNOPQRSTUVWXYZ" ;
    public static int number = 0;

    public String generateMessageId() 
    {
    	return "MI-" + getRandomNum() + getRandomNum();
    }
    
    private static String getRandomAlpha() 
    {
        Random r = new Random();
        int offset = r.nextInt(character.length());
        return character.substring(offset, offset+3);
    }
    
    public static int getRandomNum()
	{
    	number = (int)((Math.random() * 900)+100);
		return number;
	}
}