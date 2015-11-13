package com.colombosoft.ednasalespad.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.colombosoft.ednasalespad.R;
import com.colombosoft.ednasalespad.libs.ProgressWheel;

/**
 * Created by DragonSlayer on 11/6/2015.
 */
public class CustomProgressDialog extends Dialog {

    private TextView mProgressText;
    private ProgressWheel mProgressWheel;
    private Context mContext;

    public CustomProgressDialog(Context context) {

        super(context, false, null);
        this.mContext = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom_progress);

        mProgressText = (TextView)findViewById(R.id.progress_dialog_progress_txt);
        mProgressWheel = (ProgressWheel)findViewById(R.id.progress_dialog_progress_wheel);

        mProgressWheel.setBarColor(mContext.getResources().getColor(R.color.light_400));
        mProgressWheel.spin();

    }

    public void setMessage(String message) {
        if(mProgressText != null) {
            mProgressText.setText(message);
        }
    }

    public void setProgress(float progress){
        mProgressWheel.setProgress(progress);
    }

    public void setIndeterminate(){
        mProgressWheel.spin();
    }


}
