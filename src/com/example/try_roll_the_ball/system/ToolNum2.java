package com.example.try_roll_the_ball.system;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.try_gameengine.framework.ALayer;
import com.example.try_gameengine.framework.LabelLayer;

public class ToolNum2 {
	private ALayer numLayer;
	private int num;
	private DrawToolNumListener drawToolNumListener = new DrawToolNumListener() {
		
		@Override
		public void drawNum(Canvas canvas, Paint paint, int num) {
			// TODO Auto-generated method stub
			numLayer.drawSelf(canvas, paint);
		}
	};
	
	public interface DrawToolNumListener{
		public void drawNum(Canvas canvas, Paint paint, int num); 
	}
	
	public ToolNum2() {
		// TODO Auto-generated constructor stub
		LabelLayer numLayer = new LabelLayer("5", 0f, 0f, false);
		numLayer.setTextColor(Color.RED);
		this.numLayer = numLayer;
		numLayer = null;
	}
	
	public ToolNum2(String num, float x, float y) {
		// TODO Auto-generated constructor stub
		LabelLayer numLayer = new LabelLayer("5", x, y, false);
		numLayer.setTextColor(Color.RED);
		this.numLayer = numLayer;
		numLayer = null;
	}
	
	public void drawSelf(Canvas canvas, Paint paint){
		drawToolNumListener.drawNum(canvas, paint, num);
	}
	
	public void setAlpha(int alpha){
		numLayer.setAlpha(alpha);
	}
	
	public void setNumLayer(ALayer numLayer){
		if(this.numLayer!=null)
			this.numLayer.removeFromParent();
		this.numLayer = numLayer;
	}
	
	public ALayer getNumLayer(){
		return numLayer;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public void setTextSize(float textSize){
		if(numLayer instanceof LabelLayer)
			((LabelLayer)numLayer).setTextSize(textSize);
	}
}