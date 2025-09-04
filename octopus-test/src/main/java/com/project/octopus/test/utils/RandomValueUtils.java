package com.project.octopus.test.utils;

import java.util.Random;
import java.util.UUID;

public class RandomValueUtils {
	
	private static final Random RANDOM = new Random();
	
	private RandomValueUtils() {
		throw new IllegalStateException("Utility class");
	}

    public static String randomString(int size) {
    	var repeat = size<32 ? 1 : (size/32) + 1;

    	var valor = new StringBuilder();
    	for(int i=0; i<repeat; i++)
    		valor.append(UUID.randomUUID().toString().replace("-", ""));
    	
    	return valor.substring(0, size);
    }

    public static int randomInt(int bound) {
        return randomInt(1, bound);
    }

    public static int randomInt(int least, int bound) {
        return RANDOM.nextInt(least, bound);
    }

    public static Long randomLong() {
        return Long.valueOf(RANDOM.nextLong());
    }

    public static Long randomLong(long least, long bound) {
        return Long.valueOf(RANDOM.nextLong(least, bound));
    }

    public static Boolean randomBoolean() {
        return Boolean.valueOf(RANDOM.nextBoolean());
    }

    public static boolean headsOrTails() {
        return randomBoolean().booleanValue();
    }

}
