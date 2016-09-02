package com.example.try_roll_the_ball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class BitmapUtil {

	static Context context;

	public static Bitmap bg1;
	public static Bitmap chair02;
	public static Bitmap chair02_1;
	public static Bitmap chair02_2;
	public static Bitmap chair02_3;
	public static Bitmap chair02_4;
	public static Bitmap lemon;
	public static Bitmap grapes;
	public static Bitmap orange;
	public static Bitmap watermelon;

	public static Bitmap redPoint, bluePoint;
	public static Bitmap yellowPoint;
	public static Bitmap greenPoint;
	public static Bitmap mapBg1;

	public static Bitmap[] jewelBitmaps;
	
	public static Bitmap hamster;
	
	public static Bitmap bg;
	public static Bitmap flower;
	public static Bitmap fireball;
	public static Bitmap cloud1;
	public static Bitmap cloud2;
	public static Bitmap cloud3;
	
	public static Bitmap restartBtn01;
	public static Bitmap restartBtn02;
	public static Bitmap gameover;
	
	public static Bitmap sheep;
	public static Bitmap sheepJump;
	public static Bitmap sheepJump2;
	public static Bitmap sheepJump3;
	
	public static int sheepHW = 250;
	
	public static Bitmap tool_BallSpeedUp_bmp;
	public static Bitmap tool_BallSpeedDown_bmp;
	public static Bitmap tool_StickLongUp_bmp;
	public static Bitmap tool_StickLongDown_bmp;
	public static Bitmap tool_BallCountUpToThree_bmp;
	public static Bitmap tool_LifeUp_bmp;
	public static Bitmap tool_Weapen_bmp;
	public static Bitmap tool_BallReset_bmp;
	public static Bitmap tool_StickLongMax_bmp;
	public static Bitmap tool_BallRadiusUp_bmp;
	public static Bitmap tool_BallRadiusDown_bmp;
	public static Bitmap tool_BlackHole_bmp;
//	public static Bitmap tool_BallLevelUpOnce_bmp;
	public static Bitmap tool_BallLevelUpTwice_bmp;
	public static Bitmap tool_BallLevelDownOnce_bmp;
	
	public static Bitmap brick_iron_break_bmp;
	
	public static Bitmap backpack_bg;
	public static Bitmap backpack_cell_bg;
	
	public static void initBitmap(Context context) {
		if(BitmapUtil.context==null){
			BitmapUtil.context = context;
			initBitmap();
		}	
	}

	private static void initBitmap() {
		// redPoint = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.red_point, null);
		 greenPoint = BitmapFactory.decodeResource(context.getResources(),
		 R.drawable.green_point);
		// blackPoint = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.black_point);
		// whitePoint = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.white_point);
		// bluePoint =
		// createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.blue_point),
		// 200, 200);

		BitmapFactory.Options options = new BitmapFactory.Options();
		// Make sure it is 24 bit color as our image processing algorithm
		// expects this format
		options.inPreferredConfig = Config.ARGB_8888;
		// �]�w���n�۰�scale�Ϥ�
		options.inScaled = false;
		
		mapBg1 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.ic_launcher, options);
		redPoint = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.red_point, options);
		bluePoint = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.blue_point, options);
		yellowPoint = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.yellow_point, options);
		
		BitmapUtil.sheep = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.sheep1), sheepHW, sheepHW);
//		BitmapUtil.sheep2 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.sheep2), MainActivity.sheepHW, MainActivity.sheepHW);
//		BitmapUtil.sheep3 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.sheep3), MainActivity.sheepHW, MainActivity.sheepHW);
		BitmapUtil.sheepJump = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.sheep_jump1), sheepHW, sheepHW);
		BitmapUtil.sheepJump2 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.sheep_jump2), sheepHW, sheepHW);
		BitmapUtil.sheepJump3 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.sheep_jump3), sheepHW, sheepHW);
		
		hamster = BitmapUtil.createSpecificSizeBitmap(
				context.getResources().getDrawable(
						R.drawable.hamster), 150*7, 150*2);
//		
		bg = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.bgmainmenu_hd), CommonUtil.screenWidth, CommonUtil.screenHeight);
		
		flower = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.bgfood_hd), CommonUtil.screenWidth, (int) (CommonUtil.screenHeight/4.0f));
		
		fireball = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.fireball), 150, 200);
//		
		cloud1 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.c1_hd), 250, 150);
		cloud2 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.c2_hd), 300, 200);
		cloud3 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.c3_hd), 350, 150);
//		
		restartBtn01 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.game_restart_btn01), 350, 200);
		restartBtn02 = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.game_restart_btn02), 350, 200);
//		
		gameover = BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.game_over), CommonUtil.screenWidth, (int) (CommonUtil.screenWidth/6.0f));
		
		tool_BallSpeedUp_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool01, null);
		tool_BallSpeedDown_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool02, null);
		tool_StickLongUp_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool03, null);
		tool_StickLongDown_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool04, null);
		tool_BallCountUpToThree_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool05, null);
		tool_LifeUp_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool06, null);
		tool_Weapen_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool07, null);
		tool_BallReset_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool08, null);
		tool_StickLongMax_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool09, null);
		tool_BallRadiusUp_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool10, null);
		tool_BallRadiusDown_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool11, null);
		tool_BlackHole_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool12, null);
		tool_BallLevelUpTwice_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool13, null);
		tool_BallLevelDownOnce_bmp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.tool14, null);
		
		BitmapFactory.Options backpack_bg_options = new BitmapFactory.Options();
		backpack_bg_options.inSampleSize = 3;
		backpack_bg_options.inJustDecodeBounds = false;
		backpack_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bgbottom_hd, backpack_bg_options);
		
		backpack_cell_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
		
//		mapBg1 = BitmapFactory.decodeResource(context.getResources(),
//				R.drawable.images, options);

		// bg1 = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.bg1, options);
		// chair02 = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.chair02, options);
		// chair02_1 = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.chair02_1, options);
		// chair02_2 = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.chair02_2);
		// chair02_3 = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.chair02_3);
		// chair02_4 = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.chair02_4);
		// lemon = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.lemon);
		// grapes = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.grapes);
		// orange = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.orange);
		// watermelon = BitmapFactory.decodeResource(context.getResources(),
		// R.drawable.waternelon);

	}

	// ��l�Ʀn������I
	public static Bitmap createSpecificSizeBitmap(Drawable drawable, int width,
			int height) {
		// �s�ؤ@��bitmap�A���e20�A�ϥ�ARGB_8888�]�w�A��bitmap�{�b�ť�bitmap���Dnull�C
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap); // �s�صe���A�Ϊť�bitmap��e��
		drawable.setBounds(0, 0, width, height);// �]�wdrawable�����(��Ϥ����ۤv�����e)
		drawable.draw(canvas); // �b�e���W�e�W��drawable(����bitmap�w�g�Q�e�W�F��A���O�ťդF)
		return bitmap;
	}

	public static void createJewelBitmaps(int w, int h) {
		jewelBitmaps = new Bitmap[] {
				BitmapUtil.yellowPoint = BitmapUtil.createSpecificSizeBitmap(
						context.getResources().getDrawable(
								R.drawable.orange_point), w, h),
				BitmapUtil.yellowPoint = BitmapUtil.createSpecificSizeBitmap(
						context.getResources().getDrawable(
								R.drawable.yellow_point), w, h),
				BitmapUtil.yellowPoint = BitmapUtil.createSpecificSizeBitmap(
						context.getResources().getDrawable(
								R.drawable.green_point), w, h),
				BitmapUtil.yellowPoint = BitmapUtil.createSpecificSizeBitmap(
						context.getResources().getDrawable(
								R.drawable.blue_point), w, h),
				BitmapUtil.yellowPoint = BitmapUtil.createSpecificSizeBitmap(
						context.getResources().getDrawable(
								R.drawable.brown_point), w, h) };
	}
}
