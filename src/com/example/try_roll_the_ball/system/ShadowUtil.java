package com.example.try_roll_the_ball.system;

import java.lang.reflect.InvocationTargetException;

import com.example.try_gameengine.action.MovementAction;
import com.example.try_gameengine.application.GameGlobalVariable;
import com.example.try_gameengine.framework.ALayer;
import com.example.try_gameengine.framework.ILayer;
import com.example.try_gameengine.framework.Layer;
import com.example.try_gameengine.framework.Sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ShadowUtil extends ALayer{
	private ILayer layer;
	private Bitmap bitmap;
	private float layerXInScence,layerYInScence,x,y,centerX,centerY,w,h;
	private RectF collisionRectF;
	private RectF moveRage;
	private PointF shadowSize;
	private PointF shadowTouchPoint;
	private float shadowOffsetX;
	private float shadowOffsetY;
	
	private float shadowTouchOffsetX;
	private float shadowTouchOffsetY;
	
	boolean first = true;
	boolean finish = false;
	
	Parcel shadowParcel;
	Surface surface;
	Bitmap bufferBitMap;
	
	public ShadowUtil(ILayer layer) {
		// TODO Auto-generated constructor stub
		super(0,0,true);
		
		this.layer = layer;
		
		if(layer instanceof Sprite){
			collisionRectF = ((Sprite) layer).getCollisionRectF();
			moveRage = ((Sprite) layer).getMoveRage();
		}
		
		bitmap = layer.getBitmap();
//		x = layer.getX();
//		y = layer.getY();
		x = layer.getLeft();
		y = layer.getTop();
		w = layer.getBitmap().getWidth();
		h = layer.getBitmap().getHeight();
		
		shadowSize = new PointF(w, h);
		shadowTouchPoint = new PointF(shadowSize.x/2, shadowSize.y/2);
		onProvideShadowMetrics(shadowSize, shadowTouchPoint);
		
		PointF locationInScene = layer.getParent().locationInSceneByCompositeLocation(x, y);
//		shadowOffsetX = locationInScene.x - layerX;
//		shadowOffsetY = locationInScene.y - layerY;
		shadowOffsetX = layerXInScence = locationInScene.x;
		shadowOffsetY = layerYInScence = locationInScene.y;
		
		setzPosition(10);
	}
	
	public void setTouchPointXY(float touchX, float touchY){
		shadowTouchOffsetX = touchX - layerXInScence;
		shadowTouchOffsetY = touchY - layerYInScence;
	}
	
	public void onProvideShadowMetrics(PointF shadowSize, PointF shadowTouchPoint){
		
	}
	
	public void startDrag(){
//		layer.setTouching(false);
//		layer.setPressed(false);
	}
	
	public PointF getCenter(){
		return new PointF(shadowOffsetX + w/2, shadowOffsetY + h/2);
	}
	
	@Override
	public void drawSelf(Canvas canvas, Paint paint){
		
		if(first){
			first = false;
			if(bufferBitMap==null)
//				bufferBitMap=BitmapUtil.brick_once_bmp;
			 bufferBitMap=Bitmap.createBitmap((int)w,(int)h, Bitmap.Config.ARGB_8888);
			 Canvas canvasbufferBitMap =new Canvas(bufferBitMap);
			 canvasbufferBitMap.translate(-layer.getDst().left, -layer.getDst().top);
			 layer.drawSelf(canvasbufferBitMap, paint);
			 finish = true;
//			canvas.save();
//			canvas.translate(shadowOffsetX,shadowOffsetY);
//			layer.drawSelf(canvas, paint);
//			canvas.restore();
		}else{
			if(finish){
				canvas.save();
				canvas.translate(shadowOffsetX,shadowOffsetY);
				canvas.drawBitmap(bufferBitMap, 0, 0, paint);
				canvas.restore();
			}
		}
		
//		if(first){
//			SurfaceHolder surfaceView = GameGlobalVariable.surfaceHolder;	
//			if(surfaceView==null)
//				return;
//			surface = surfaceView.getSurface();
//			try {
//				surface = Surface.class.getConstructor().newInstance();
//			} catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				
//			surface = new Surface(new SurfaceTexture(0));
//			
//			canvas = surface.lockCanvas(null);
//			int w = canvas.getWidth();
//			int h = canvas.getHeight();
//			first=false;
//			canvas.save();
//			canvas.translate(shadowOffsetX,shadowOffsetY);
//			layer.drawSelf(canvas, paint);
//			canvas.restore();
//			shadowParcel = Parcel.obtain();
//		}else{
//			if(surface.isValid())
//				canvas = surface.lockCanvas(null);
//		}
//		surface.unlockCanvasAndPost(canvas);
////		canvas = surface.lockCanvas(null);
		
//		if(first){
//			
////			android.os.Parcel _data = android.os.Parcel.obtain();
////			android.os.Parcel _reply = android.os.Parcel.obtain();
////			boolean _result;
//////			try {
////			_data.writeInterfaceToken(DESCRIPTOR);
////			_data.writeStrongBinder(nul));
////			_data.writeStrongBinder(null);
////			_data.writeFloat(10);
////			_data.writeFloat(10);
////			_data.writeFloat(20);
////			_data.writeFloat(20);
//////			if ((data!=null)) {
//////			_data.writeInt(1);
//////			data.writeToParcel(_data, 0);
//////			}
//////			else {
////			_data.writeInt(0);
//////			}
//////			mRemote.transact(Stub.TRANSACTION_performDrag, _data, _reply, 0);
////			_reply.readException();
////			_result = (0!=_reply.readInt());
//////			}
//			
////			android.os.Parcel _data = android.os.Parcel.obtain();
////			android.os.Parcel _reply = android.os.Parcel.obtain();
////			android.os.IBinder _result;
//////			try {
////			_data.writeInterfaceToken("");
////			_data.writeStrongBinder(null);
//////			_reply.writeInt(1);//调用Surface?�writeToParcel，�?信息?�入reply
//////			surfaceView.getSurface().writeToParcel(_reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
////				_reply.writeInt(0);
////				_reply.writeInt(20);
////			_reply.writeInt(20);
//////			mRemote.transact(Stub.TRANSACTION_prepareDrag, _data, _reply, 0);
////			_reply.readException();
////			_result = _reply.readStrongBinder();
////			if ((0!=_reply.readInt())) {
////				surface.readFromParcel(_reply);
////			}
//			
//			
////			shadowParcel = Parcel.obtain();
////			surfaceView.getSurface().unlockCanvasAndPost(canvas);
////			surfaceView.getSurface().writeToParcel(shadowParcel, 0);
////			surface.readFromParcel(shadowParcel);
////			surface = Surface.CREATOR.createFromParcel(shadowParcel);
////			canvas = surface.lockCanvas(new Rect(0, 0, 0, 0));
//			canvas = surface.lockCanvas(null);
//			first=false;
//			canvas.save();
//			canvas.translate(shadowOffsetX,shadowOffsetY);
//			layer.drawSelf(canvas, paint);
//			canvas.restore();
//			shadowParcel = Parcel.obtain();
//			
//			surface.unlockCanvasAndPost(canvas);
//			canvas = surface.lockCanvas(null);
//			surface.writeToParcel(shadowParcel, 0);
////			surface.release();
//		}else{
//			if(shadowParcel!=null)
//			surfaceView.getSurface().readFromParcel(shadowParcel);
//		}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		final float x = event.getX();
		final float y = event.getY();
		
		if(event.getAction()==MotionEvent.ACTION_MOVE){
//			PointF locationInScene = layer.locationInSceneByCompositeLocation(x, y);
//			shadowOffsetX = locationInScene.x - layerXInScence - shadowTouchOffsetX;
//			shadowOffsetY = locationInScene.y - layerYInScence - shadowTouchOffsetY;

			shadowOffsetX = x - shadowTouchOffsetX;
			shadowOffsetY = y - shadowTouchOffsetY;
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event, int touchEventFlag) {
		final float x = event.getX();
		final float y = event.getY();
		
		if(event.getAction()==MotionEvent.ACTION_MOVE){
//			PointF locationInScene = layer.locationInSceneByCompositeLocation(x, y);
//			shadowOffsetX = locationInScene.x - layerXInScence - shadowTouchOffsetX;
//			shadowOffsetY = locationInScene.y - layerYInScence - shadowTouchOffsetY;

			shadowOffsetX = x - shadowTouchOffsetX;
			shadowOffsetY = y - shadowTouchOffsetY;
			
			return true;
		}
		
		return false;
	}

	@Override
	public void onTouched(MotionEvent event) {
		// TODO Auto-generated method stub
		
	}
	

}
