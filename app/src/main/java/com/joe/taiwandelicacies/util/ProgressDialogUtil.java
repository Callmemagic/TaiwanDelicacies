package com.joe.taiwandelicacies.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.joe.taiwandelicacies.R;

public class ProgressDialogUtil {
    private static AlertDialog mAlertDialog;

    /**
     * 彈出耗時對話方塊
     * @param context
     */
    public static void showProgressDialog(Context context, boolean isCancelable) {
        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(context, R.style.CustomProgressDialog).create();
        }

        View loadView = LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog_view, null);
        mAlertDialog.setView(loadView, 0, 0, 0, 0);
        mAlertDialog.setCanceledOnTouchOutside(isCancelable);

        TextView tvTip = loadView.findViewById(R.id.tvTip);
        tvTip.setText("愛的魔力轉圈圈...");

        mAlertDialog.show();
    }

    public static void showProgressDialog(Context context, String tip, boolean isCancelable) {
        if (TextUtils.isEmpty(tip)) {
            tip = "載入中...";
        }

        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(context, R.style.CustomProgressDialog).create();
        }

        View loadView = LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog_view, null);
        mAlertDialog.setView(loadView, 0, 0, 0, 0);
        mAlertDialog.setCanceledOnTouchOutside(false);

        TextView tvTip = loadView.findViewById(R.id.tvTip);
        tvTip.setText(tip);

        mAlertDialog.show();
    }

    /**
     * 隱藏耗時對話方塊
     */
    public static void dismiss() {
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }
}
