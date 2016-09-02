package com.example.try_roll_the_ball.system;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.try_gameengine.framework.ButtonLayer;
import com.example.try_gameengine.framework.DialogLayer;
import com.example.try_roll_the_ball.BitmapUtil;

public class MoveToolDialogLayer extends DialogLayer{

	public MoveToolDialogLayer(Context context, float x, float y) {
		super();
		setPosition(x, y);
		// TODO Auto-generated constructor stub
		final EditText editText = new EditText(context);
		editText.setX(100);
		editText.setY(100);
		editText.setWidth(100);
		editText.setHeight(100);
		editText.layout(100, 100, 200, 200);
		editText.setEnabled(true);
		editText.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		ButtonLayer buttonLayer = new ButtonLayer(100, 100, true);
		buttonLayer.setButtonBitmap(BitmapUtil.tool_StickLongMax_bmp, BitmapUtil.tool_StickLongDown_bmp, BitmapUtil.tool_StickLongUp_bmp);
		buttonLayer.setBitmapAndAutoChangeWH(BitmapUtil.tool_StickLongMax_bmp);
		buttonLayer.setOnClickListener(new ButtonLayer.OnClickListener() {
			
			@Override
			public void onClick(ButtonLayer buttonLayer) {
				// TODO Auto-generated method stub
//				int moveNum = Integer.parseInt(editText.getText().toString());
//				if(moveNum > )
			}
		});
		
		addChild(buttonLayer);
		
		setBitmapAndAutoChangeWH(BitmapUtil.brick_iron_break_bmp);
		
		initWithOneButton();
	}

	@Override
	public void drawSelf(Canvas canvas, Paint paint) {
		// TODO Auto-generated method stub
		super.drawSelf(canvas, paint);
		
//		viewGroupLayer.drawSelf(canvas, paint);
	}
}
