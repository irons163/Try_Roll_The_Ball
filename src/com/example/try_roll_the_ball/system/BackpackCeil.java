package com.example.try_roll_the_ball.system;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.try_gameengine.framework.ALayer;
import com.example.try_gameengine.framework.LabelLayer;
import com.example.try_gameengine.framework.Layer;
import com.example.try_roll_the_ball.system.Tool.ToolCallback;

public class BackpackCeil extends Layer{
	private Tool tool;
//	private ALayer toolNum = new LabelLayer(0, 0, false);
	private ToolNum2 toolNum2 = new ToolNum2("0", 0, 0);
	private int num;
	private ToolCallback toolCallback;
	
	public BackpackCeil(Bitmap bitmap, float x, float y, boolean autoAdd) {
		super(bitmap, x, y, autoAdd);
		// TODO Auto-generated constructor stub
		toolNum2.setTextSize(30);
	}

	public Tool setTool(Tool tool){
		if(tool==null){
			this.tool = tool;
			return null;
		}else if(this.tool==null){
			this.tool = tool;
			tool.removeFromParent();
			addChild(tool);
			toolNum2.getNumLayer().removeFromParent();
			addChild(toolNum2.getNumLayer());
			toolNum2.setNum(num);
			if(tool.getToolCallback()==null)
				tool.setToolCallback(toolCallback);
			return null;
		}
		/*
		else if(tool.getClass() == this.tool.getClass()
				|| (tool.getToolName()!=null && tool.getToolName().equals(this.tool.getToolName()))){
//			if(((BackpackCeil)tool.getParent()).getNum()>1)
//				try {
//					Tool cloneTool = (Tool) tool.clone();
//				} catch (CloneNotSupportedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			this.setNum(this.getNum() + ((BackpackCeil)tool.getParent()).getNum());
			return null;
		}*/
		else{
			Tool orgTool = this.tool;		
			this.tool = tool;
			remove(orgTool);
			tool.removeFromParent();
			addChild(tool);
			toolNum2.getNumLayer().removeFromParent();
			addChild(toolNum2.getNumLayer());
			toolNum2.setNum(num);
			if(tool.getToolCallback()==null)
				tool.setToolCallback(toolCallback);
			return orgTool;
		}
	}
	
//	public Tool setTool(Tool tool){
//		if(tool==null){
//			this.tool = tool;
//			return null;
//		}else{
//			Tool orgTool = this.tool;
//			this.tool = tool;
//			return orgTool;
//		}
//	}
	
	public Tool getTool(){
		return tool;
	}
	
	public void setToolCallback(ToolCallback toolCallback){
		this.toolCallback = toolCallback;
	}
	
	public void touch(){
		if(tool!=null)
			tool.touch();
	}
	
	public boolean isTouched(float x, float y){
//		if(x >= getX() && x <= getX()+w && y >= getY() && y <= getY()+h)
		if(x >= getLeft() && x <= getLeft()+getWidth() && y >= getTop() && y <= getTop()+getHeight())
			return true;
		else
			return false;
	}
	
	public boolean hashTool(){
		return tool!=null;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void drawSelf(Canvas canvas, Paint paint) {
		// TODO Auto-generated method stub
		super.drawSelf(canvas, paint);
		
		if(tool!=null && toolNum2!=null)
			toolNum2.drawSelf(canvas, paint);
	}
}
