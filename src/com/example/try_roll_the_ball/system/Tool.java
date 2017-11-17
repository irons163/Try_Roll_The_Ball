package com.example.try_roll_the_ball.system;

import java.util.ArrayList;
import java.util.List;

import com.example.try_gameengine.framework.ALayer;
import com.example.try_gameengine.framework.ILayer;
import com.example.try_gameengine.framework.Layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;

public class Tool extends Layer implements Cloneable{
	private ToolCallback toolCallback;
	private String toolName;
	private float touchX, touchY;
	
	public interface ToolCallback{
		public void touchedTool(Tool tool);
		public void willMoveTool(Tool tool);
		public void didMoveTool(Tool tool, float moveToX, float moveToY);
		public void movingTool(Tool tool, float moveToX, float moveToY);
	}
	
	public Tool(float x, float y, boolean autoAdd) {
		super(x, y, autoAdd);
		// TODO Auto-generated constructor stub
//		useBehavior = new UseNoWay();
		setOnLayerLongClickListener(new OnLayerLongClickListener() {
			
			@Override
			public boolean onLongClick(ILayer layer) {
				// TODO Auto-generated method stub
				shadowUtil = new ShadowUtil(layer);
				shadowUtil.setTouchPointXY(touchX, touchY);
				shadowUtil.startDrag();
				if(toolCallback!=null)
					toolCallback.willMoveTool((Tool)layer);
				return true;
			}
		});
	}
	
	public Tool(String toolName, float x, float y, boolean autoAdd) {
		this(x, y, autoAdd);
		this.toolName = toolName;
	}

	ShadowUtil shadowUtil;

	private boolean isUseable;
	private boolean isOverlapable;
	private IUseBehavior useBehavior;
	

	
	public void setUseBehavior(IUseBehavior useBehavior){
		this.useBehavior = useBehavior;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public void touch() {
		// TODO Auto-generated method stub
		
	}
	
	public void willMoveTool(){
		
	}
	
	public Tool didMoveTool(){
//		try {
//			return (Tool) this.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
		return null;
	}

	public void setToolCallback(ToolCallback toolCallback) {
		this.toolCallback = toolCallback;
	}

	public ToolCallback getToolCallback() {
		return toolCallback;
	}



	@Override
	public void drawSelf(Canvas canvas, Paint paint) {
		// TODO Auto-generated method stub
		super.drawSelf(canvas, paint);
		
//		if(shadowUtil!=null)
//			synchronized (shadowUtil) {
//				shadowUtil.drawSelf(canvas, paint);
//			}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event, int touchEventFlag) {
		// TODO Auto-generated method stub
		if(shadowUtil!=null){
			super.onTouchEvent(event, touchEventFlag);
			
			switch (event.getAction()) {
			case MotionEvent.ACTION_UP:			
			case MotionEvent.ACTION_CANCEL:
				
				didMoveTool();
				if(toolCallback!=null)
					toolCallback.didMoveTool(this,shadowUtil.getCenter().x,shadowUtil.getCenter().y);
				
				if(shadowUtil!=null){
					synchronized (shadowUtil){
						shadowUtil.removeFromAuto();
						shadowUtil = null;
					}
				}
				break;
			case MotionEvent.ACTION_MOVE:
	
				if(shadowUtil!=null){
					synchronized (shadowUtil) {
						shadowUtil.onTouchEvent(event, touchEventFlag);
						
						if(toolCallback!=null)
							toolCallback.movingTool(this,shadowUtil.getCenter().x,shadowUtil.getCenter().y);
					}
				}
				
				break;
			default:
				break;
			}
		}else if(super.onTouchEvent(event, touchEventFlag)){
			
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if(toolCallback!=null)
					toolCallback.touchedTool(this);
				touchX = event.getX();
				touchY = event.getY();
				break;
			case MotionEvent.ACTION_UP:			
			case MotionEvent.ACTION_CANCEL:
				
					if(shadowUtil!=null){
						synchronized (shadowUtil) {
							shadowUtil = null;
						}
					}
						
//				didMoveTool();
//				if(toolCallback!=null)
//					toolCallback.didMoveTool(this);
				break;
			case MotionEvent.ACTION_MOVE:

					if(shadowUtil!=null){
						synchronized (shadowUtil) {
							shadowUtil.onTouchEvent(event, touchEventFlag);
						}
					}
				
				break;
			default:
				break;
			}
			
			return true;
		}
		return false;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
