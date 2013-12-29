package com.ycc.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.ycc.anywheretaxi.R;
import com.ycc.app.ui.AppMain;

/**
 * ����UI֮�����ת��
 * 
 * @author YY
 * 
 */
public class UIManage extends Activity {

	/**
	 * ��ʾAPP������
	 * 
	 * @param activity
	 */
	public static void ShowAppMain(Activity activity) {
		Intent intent = new Intent(activity, AppMain.class);
		activity.startActivity(intent);
		activity.finish();
	}

	/**
	 * @param mContext
	 *            ������
	 * @param msg
	 *            toast�ı�
	 */
	public static void ShowToast(Context mContext, String msg) {
		Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
	}

	/**
	 * @param mContext
	 *            ������
	 * @param msg
	 *            toast�ı�
	 * @param time
	 *            ��ʾʱ��
	 */
	public static void ShowToast(Context mContext, String msg, int time) {
		Toast.makeText(mContext, msg, time).show();
	}
	
	/**
	 * ����App�쳣��������
	 * 
	 * @param cont
	 * @param crashReport
	 */
	public static void sendAppCrashReport(final Context cont,
			final String crashReport) {
		AlertDialog.Builder builder = new AlertDialog.Builder(cont);
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setTitle(R.string.app_error);
		builder.setMessage(R.string.app_error_message);
		builder.setPositiveButton(R.string.submit_report,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						// �����쳣����
						Intent i = new Intent(Intent.ACTION_SEND);
						i.setType("text/plain"); //ģ����
						//i.setType("message/rfc822"); // ���
						i.putExtra(Intent.EXTRA_EMAIL,new String[] { "zhoutao_vips@163.com" });
						i.putExtra(Intent.EXTRA_SUBJECT,"����Android�ͻ��� - ���󱨸�");
						i.putExtra(Intent.EXTRA_TEXT, crashReport);
						cont.startActivity(Intent.createChooser(i, "���ʹ��󱨸�"));
						// �˳�
						AppManager.getAppManager().AppExit(cont);
					}
				});
		builder.setNegativeButton(R.string.sure,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						// �˳�
						AppManager.getAppManager().AppExit(cont);
					}
				});
		builder.show();
	}
}
