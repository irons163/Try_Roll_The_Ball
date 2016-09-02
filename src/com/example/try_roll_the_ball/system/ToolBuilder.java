package com.example.try_roll_the_ball.system;

public class ToolBuilder {
	
	enum ToolType{
		t1, t2
	}
	
	public static Tool createT(ToolType toolType){
		
		Tool tool = null;
		
		switch (toolType) {
		case t1:
			tool = createTool();
			break;

		default:
			break;
		}
		
		return tool;
	}
	
	private static Tool createTool(){
		Tool tool = new Tool(0, 0, false);
//		tool.setUseBehavior(new UseNoWay());
		return tool;
	}
	
	private static Tool createTool2(){
		Tool tool = new Tool(0, 0, false);
//		tool.setUseBehavior(new Use());
		return tool;
	}
	
	private void hashTool(){
		
	}
}
