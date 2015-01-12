// Copyright 2013 Square, Inc.

package com.squareup.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.squareup.timessquare.MonthCellDescriptor.RangeState;
import com.squareup.timessquare.MonthCellDescriptor.TensionState;

public class CalendarCellView extends TextView {
  private static final int[] STATE_SELECTABLE = {
      R.attr.state_selectable
  };
  private static final int[] STATE_CURRENT_MONTH = {
      R.attr.state_current_month
  };
  private static final int[] STATE_TODAY = {
      R.attr.state_today
  };
  private static final int[] STATE_HIGHLIGHTED = {
      R.attr.state_highlighted
  };
  private static final int[] STATE_RANGE_FIRST = {
      R.attr.state_range_first
  };
  private static final int[] STATE_RANGE_MIDDLE = {
      R.attr.state_range_middle
  };
  private static final int[] STATE_RANGE_LAST = {
      R.attr.state_range_last
  };
  
  private static final int[] TENSION_LEVEL_LOW = {
      R.attr.tension_level_low
  };
  
  private static final int[] TENSION_LEVEL_MILD = {
      R.attr.tension_level_mild
  };
  
  private static final int[] TENSION_LEVEL_MODERATE= {
      R.attr.tension_level_moderate
  };
  
  private static final int[] TENSION_LEVEL_HIGH = {
      R.attr.tension_level_high
  };
  
  private static final int[] TENSION_LEVEL_SEVERE= {
      R.attr.tension_level_severe
  };
  
  private boolean isSelectable = false;
  private boolean isCurrentMonth = false;
  private boolean isToday = false;
  private boolean isHighlighted = false;
  private RangeState rangeState = RangeState.NONE;
  private TensionState tensionState = TensionState.NONE;
  
  @SuppressWarnings("UnusedDeclaration") //
  public CalendarCellView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void setSelectable(boolean isSelectable) {
    this.isSelectable = isSelectable;
    refreshDrawableState();
  }

  public void setCurrentMonth(boolean isCurrentMonth) {
    this.isCurrentMonth = isCurrentMonth;
    refreshDrawableState();
  }

  public void setToday(boolean isToday) {
    this.isToday = isToday;
    refreshDrawableState();
  }

  public void setRangeState(MonthCellDescriptor.RangeState rangeState) {
    this.rangeState = rangeState;
    refreshDrawableState();
  }

  public void setHighlighted(boolean highlighted) {
    isHighlighted = highlighted;
    refreshDrawableState();
  }
  
	public void setDailyTensionLevel(MonthCellDescriptor.TensionState teState) {
		this.tensionState = teState;
		refreshDrawableState();
	}

  @Override protected int[] onCreateDrawableState(int extraSpace) {
    final int[] drawableState = super.onCreateDrawableState(extraSpace + 6);

    if (isSelectable) {
      mergeDrawableStates(drawableState, STATE_SELECTABLE);
    }

    if (isCurrentMonth) {
      mergeDrawableStates(drawableState, STATE_CURRENT_MONTH);
    }

    if (isToday) {
      mergeDrawableStates(drawableState, STATE_TODAY);
    }

    if (isHighlighted) {
      mergeDrawableStates(drawableState, STATE_HIGHLIGHTED);
    }

    if (rangeState == MonthCellDescriptor.RangeState.FIRST) {
      mergeDrawableStates(drawableState, STATE_RANGE_FIRST);
    } else if (rangeState == MonthCellDescriptor.RangeState.MIDDLE) {
      mergeDrawableStates(drawableState, STATE_RANGE_MIDDLE);
    } else if (rangeState == RangeState.LAST) {
      mergeDrawableStates(drawableState, STATE_RANGE_LAST);
    }
    
    if(tensionState ==  TensionState.LOW){
    	mergeDrawableStates(drawableState, TENSION_LEVEL_LOW);
    }else if(tensionState == TensionState.MILD){
    	mergeDrawableStates(drawableState, TENSION_LEVEL_MILD);
    }else if(tensionState == TensionState.MODERATE){
    	mergeDrawableStates(drawableState, TENSION_LEVEL_MODERATE);    	
    }else if(tensionState == TensionState.HIGH){
    	mergeDrawableStates(drawableState, TENSION_LEVEL_HIGH);
    }else if(tensionState == TensionState.SEVERE){
    	mergeDrawableStates(drawableState, TENSION_LEVEL_SEVERE);
    }
    return drawableState;
  }
}
