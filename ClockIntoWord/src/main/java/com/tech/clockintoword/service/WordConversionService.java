package com.tech.clockintoword.service;

public interface WordConversionService {

	public String generateHourToWord(int hr) throws Exception;

	public String generateMinuteToWord(int min) throws Exception;

	public String generateMidDay(int hr, int min);

	public String generateMidNight(int hr, int min);

}
