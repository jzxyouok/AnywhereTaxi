package com.ycc.app;

import com.ycc.anywheretaxi.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/**
 * Ӧ�ó��������ࣺ��ʾ��ӭ���沢��ת��������
 * 
 * @author YY
 * 
 */
public class AppStart extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ���ر���
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// ����ȫ��
		 final View view = View.inflate(this, R.layout.start, null);
		 setContentView(view); 
		// ����չʾ������
		AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
		aa.setDuration(2000);
		 view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation arg0) {
				UIManage.ShowAppMain(AppStart.this);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationStart(Animation animation) {
			}
		});

		// ���ݵͰ汾cookie��1.5�汾���£�����1.5.0,1.5.1��
		/*
		 * AppContext appContext = (AppContext) getApplication(); String cookie
		 * = appContext.getProperty("cookie"); if (StringUtils.isEmpty(cookie))
		 * { String cookie_name = appContext.getProperty("cookie_name"); String
		 * cookie_value = appContext.getProperty("cookie_value"); if
		 * (!StringUtils.isEmpty(cookie_name) &&
		 * !StringUtils.isEmpty(cookie_value)) { cookie = cookie_name + "=" +
		 * cookie_value; appContext.setProperty("cookie", cookie);
		 * appContext.removeProperty("cookie_domain", "cookie_name",
		 * "cookie_value", "cookie_version", "cookie_path"); } }
		 */

	}
}