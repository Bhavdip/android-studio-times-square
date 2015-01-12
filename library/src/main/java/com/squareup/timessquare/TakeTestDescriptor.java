package com.squareup.timessquare;

import java.util.Calendar;
import java.util.Date;

public class TakeTestDescriptor {

	public Date takeTestDay;

	public MonthCellDescriptor.TensionState tensionState;

	public Date getTestDay() {
		return takeTestDay;
	}

	public TakeTestDescriptor setTestDay(Date mCalendar) {
		this.takeTestDay = mCalendar;
		return this;
	}
	
	public Calendar getTestDayCalendar(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(takeTestDay);
		return calendar;
	}

	public MonthCellDescriptor.TensionState getTensionState() {
		return tensionState;
	}

	public TakeTestDescriptor setTensionState(
			MonthCellDescriptor.TensionState tensionState) {
		this.tensionState = tensionState;
		return this;
	}

}
