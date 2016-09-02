package com.example.try_roll_the_ball.system;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.example.try_gameengine.framework.LabelLayer;
import com.example.try_gameengine.framework.Layer;
import com.example.try_gameengine.framework.Sprite;
import com.example.try_gameengine.stage.StageManager;
import com.example.try_roll_the_ball.BitmapUtil;
import com.example.try_roll_the_ball.system.Tool.ToolCallback;

public class Backpack extends Layer{
	private int maxNum = 10;
	private int numInOneRow = 4;
	private BackpackCallback backpackCallback;
	private LabelLayer moveAbleTitle;
	
	private boolean isSplitMode;
	private int splitNum = 1;
	
	private MoveToolDialogLayer moveToolDialogLayer;
	
	public interface BackpackCallback{
		public void isTouched();
		public void touchedTool(Tool tool);
		public void willMoveTool(Tool tool);
		public void didMoveTool(Tool tool);
//		public void movingTool(Tool tool);
	}

	public Backpack(Bitmap bitmap, float x, float y, boolean autoAdd) {
		super(bitmap, x, y, autoAdd);
		// TODO Auto-generated constructor stub
		initBackpackCeils();
	}
	
	public Backpack(Bitmap bitmap, int w, int h, boolean autoAdd){
		super(bitmap, w, h, autoAdd);
		initBackpackCeils();
	}

	private List<BackpackCeil> backpackCeils = new ArrayList<BackpackCeil>();
	
	private void initBackpackCeils(){
		ToolCallback toolCallback = new ToolCallback() {
			BackpackCeil backpackCeil;
			
			@Override
			public void willMoveTool(Tool tool) {
				// TODO Auto-generated method stub
//				for(BackpackCeil backpackCeil : backpackCeils){
//					if(backpackCeil.isTouched(tool.getCenterX(), tool.getCenterY())){
//						this.backpackCeil = backpackCeil;
//						break;
//					}
//				}
				
				this.backpackCeil = (BackpackCeil) tool.getParent();
				
				if(isSplitMode){
					try {
						Tool cloneTool = (Tool) tool.clone();
						for(BackpackCeil backpackCeil : backpackCeils){
							if(backpackCeil.getTool()==null){
								backpackCeil.setTool(cloneTool);
								backpackCeil.setNum(7);
							}
						}
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				if(backpackCallback!=null)
					backpackCallback.willMoveTool(tool);
			}
			
			@Override
			public void touchedTool(Tool tool) {
				// TODO Auto-generated method stub
				if(moveToolDialogLayer==null && isSplitMode)
					moveToolDialogLayer = new MoveToolDialogLayer(StageManager.getCurrentStage(), 100, 100);
				
				if(backpackCallback!=null)
					backpackCallback.touchedTool(tool);
			}
			
			@Override
			public void didMoveTool(Tool tool, float moveToX, float moveToY) {
				// TODO Auto-generated method stub
				
				PointF locationInLayer = Backpack.this.locationInLayer(moveToX, moveToY);
				for(BackpackCeil backpackCeil : backpackCeils){
					if(backpackCeil.isTouched(locationInLayer.x, locationInLayer.y)){
						if(backpackCeil.getTool()==tool)
							break;
						Tool targetToolOfBackpackCeil = backpackCeil.setTool(tool);
						this.backpackCeil.setTool(targetToolOfBackpackCeil);						
					}
				}
				
				if(backpackCallback!=null)
					backpackCallback.didMoveTool(tool);
			}

			@Override
			public void movingTool(Tool tool, float moveToX, float moveToY) {
				// TODO Auto-generated method stub
				PointF locationInLayer = Backpack.this.locationInLayer(moveToX, moveToY);
				BackpackCeil backpackCeilWithDragTool = null;
				for(BackpackCeil backpackCeil : backpackCeils){
					if(backpackCeil.getTool()==tool){
						backpackCeilWithDragTool = backpackCeil;
						break;
					}
				}
				for(BackpackCeil backpackCeil : backpackCeils){
					if(backpackCeil.isTouched(locationInLayer.x, locationInLayer.y)){
						if(backpackCeil.getTool()==tool)
							break;
						Tool targetToolOfBackpackCeil = backpackCeil.setTool(tool);
						backpackCeilWithDragTool.setTool(targetToolOfBackpackCeil);						
					}
				}
				
//				if(backpackCallback!=null)
//					backpackCallback.didMoveTool(tool);
			}

		};
//		int num = 10;
		int cellWidth = BitmapUtil.backpack_cell_bg.getWidth();
		int cellHeight = BitmapUtil.backpack_cell_bg.getHeight();
		for(int i = 0; i < maxNum; i++){
			int witchCol = i % numInOneRow;
			int witchRow = i / numInOneRow;
			BackpackCeil backpackCeil = new BackpackCeil(BitmapUtil.backpack_cell_bg, cellWidth + witchCol*cellWidth, cellHeight + witchRow*cellHeight, false);
			addChild(backpackCeil);
			backpackCeil.setToolCallback(toolCallback);
			backpackCeils.add(backpackCeil);
			backpackCeil.setAnchorPoint(1, 1);
		}
	}
	
	private void initBackpackBG(){
//		bitmap = BitmapFactory.decodeResource(res, id)
	}
	
//	private void setToolCallback(){
//		
//		
//		for(BackpackCeil backpackCeil : backpackCeils){
//			backpackCeil.setToolCallback(toolCallback);
//		}
//	}
	
	public boolean isFull(){
		for(BackpackCeil backpackCeil : backpackCeils){
			if(!backpackCeil.hashTool())
				return false;
		}
		return true;
	}
	
	public boolean addTool(Tool tool, int index){
		if(index >= backpackCeils.size())
			return false;
		BackpackCeil backpackCeil = backpackCeils.get(index);
		if(!backpackCeil.hashTool()){
			backpackCeil.setTool(tool);
			return true;
		}
		return false;
	}
	
	public boolean addTool(Tool tool){
		for(BackpackCeil backpackCeil : backpackCeils){
			if(!backpackCeil.hashTool()){
				backpackCeil.setTool(tool);
				return true;
			}
		}
		return false;
	}
	
	public void isTouched(float x, float y){
		for(BackpackCeil backpackCeil : backpackCeils){
			backpackCeil.isTouched(x, y);
			break;
		}
	}
	
	public Tool touchTool(float x, float y){
		PointF locationInLayer = locationInLayer(x, y);
		for(BackpackCeil backpackCeil : backpackCeils){
			if(backpackCeil.isTouched(locationInLayer.x, locationInLayer.y)){
				backpackCeil.touch();
				backpackCeil.setAlpha(0);
				return backpackCeil.getTool();
			}
		}
		return null;
	}
	
	public void putDownTool(Tool tool, float x, float y){
		for(BackpackCeil backpackCeil : backpackCeils){
			if(backpackCeil.isTouched(x, y)){
				backpackCeil.setTool(tool);
				break;
			}
		}
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getNumInOneRow() {
		return numInOneRow;
	}

	public void setNumInOneRow(int numInOneRow) {
		this.numInOneRow = numInOneRow;
	}

	public void setBackpackCallback(BackpackCallback backpackCallback) {
		this.backpackCallback = backpackCallback;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(super.onTouchEvent(event)){
			if(event.getAction()==MotionEvent.ACTION_DOWN){
				if(backpackCallback!=null){
					backpackCallback.isTouched();			
				}
			}else if(event.getAction()==MotionEvent.ACTION_UP && isSplitMode){
				if(moveToolDialogLayer==null)
					moveToolDialogLayer = new MoveToolDialogLayer(StageManager.getCurrentStage(), 100, 100);
				moveToolDialogLayer.onTouchEvent(event);
			}
			
//			Tool tool = touchTool(event.getX(), event.getY());
//			if(backpackCallback!=null){
//				backpackCallback.isTouched();			
//			}
			return true;
		}
		return false;
	}
}
