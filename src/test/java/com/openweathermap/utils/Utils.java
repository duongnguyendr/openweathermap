package com.openweathermap.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static double convertKelvinToCelsius(double kelvin) {
		return Math.round(kelvin - 273.15);
	}
	
	public static double convertKelvinToFahrenheit(double kelvin) {
		return Math.round((kelvin - 273.15) * 9 / 5 + 32);
	}
	
	public static String GetTimeStampValue() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss_SSS");
        String systime = sdf.format(new Date());
        systime = systime.replace(":", "");
        systime = systime.replace("-", "");
        return systime;
    }
}
