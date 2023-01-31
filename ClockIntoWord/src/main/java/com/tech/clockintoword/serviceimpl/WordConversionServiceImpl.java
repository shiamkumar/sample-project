package com.tech.clockintoword.serviceimpl;

import org.springframework.stereotype.Service;

import com.tech.clockintoword.exceptions.InvalidMinutesCustomException;
import com.tech.clockintoword.service.InvalidHoursCustomException;
import com.tech.clockintoword.service.WordConversionService;
import com.tech.clockintoword.utils.HoursUtil;
import com.tech.clockintoword.utils.MinutesUtil;

@Service
public class WordConversionServiceImpl implements WordConversionService {

	@Override
	public String generateHourToWord(int number) throws Exception {
		String word = "";
		if (number == 0) {
			word += HoursUtil.getHoursMap().get(number);
		} else if (number > 0 && number <= 10) {
			word += HoursUtil.getHoursMap().get(number);
		} else if (number >= 11 && number < 20) {
			word += HoursUtil.getHoursMap().get(number);
		} else if (number >= 21 && number < 24) {
			word += HoursUtil.getHoursMap().get(number);
		} else {
			//word = "INVALID_INPUT_GIVEN";
			String errorCode = "ERR-001";
			String errorDescribtion = "Invalid input format. please enter your valid hours";
			throw new InvalidHoursCustomException(errorCode, errorDescribtion);
		}
		return word;
	}

	@Override
	public String generateMinuteToWord(int number) throws Exception {
		String word = "";
		if (number >= 0 && number <= 10) {
			word += MinutesUtil.getHoursMap().get(number);
		} else if (number >= 11 && number < 20) {
			word += MinutesUtil.getHoursMap().get(number);
		} else if (number >= 21 && number < 30) {
			word += MinutesUtil.getHoursMap().get(number);
		} else if (number >= 31 && number < 40) {
			word += MinutesUtil.getHoursMap().get(number);
		} else if (number >= 41 && number < 50) {
			word += MinutesUtil.getHoursMap().get(number);
		} else if (number >= 51 && number < 60) {
			word += MinutesUtil.getHoursMap().get(number);
		} else {
			String errorCode = "ERR-001";
			String errorDescribtion = "Invalid input format. please enter your valid minutes";
			throw new InvalidMinutesCustomException(errorCode, errorDescribtion);
		}
		return word;
	}

	@Override
	public String generateMidDay(int hr, int min) {
		return (hr == 12 && min == 00) ? "It's Midday" : "";
	}

	@Override
	public String generateMidNight(int hr, int min) {
		return (hr == 0 && min == 00) ? "It's Midnight" : "";
	}

}
