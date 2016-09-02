package com.example.try_roll_the_ball.system;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.try_gameengine.framework.LabelLayer;
import com.example.try_gameengine.framework.Layer;

public class ToolNum extends Layer{
	private int num;
	private DrawToolNumListener drawToolNumListener = new DrawToolNumListener() {
		
		@Override
		public void drawNum(Canvas canvas, Paint paint, int num) {
			// TODO Auto-generated method stub
			drawNum(canvas, paint, num);
		}
	};
	
	public interface DrawToolNumListener{
		public void drawNum(Canvas canvas, Paint paint, int num); 
	}
	
	public ToolNum(float x, float y, boolean autoAdd) {
		super(x, y, autoAdd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawSelf(Canvas canvas, Paint paint) {
		// TODO Auto-generated method stub
		if(drawToolNumListener!=null)
			drawToolNumListener.drawNum(canvas, paint, num);
	}

	public void drawNum(Canvas canvas, Paint paint, int num){
		
		switch (num) {
		case 0:
			
			break;
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			break;
		}
	}
	
	public void setNum(int num){
		this.num = num;
	}
}
