package com.botong.android.takeitproto.fragments.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;

import com.botong.android.takeitproto.WriteHomeActivity;
import com.botong.android.takeitproto.fragments.WriteFragment;

/**
 * Created by cob_macpro on 2015. 1. 27..
 */
public class NoticeDialogFragment extends DialogFragment{

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    private NoticeDialogListener noticeDialogListener;
    private String message;
    private String positive;
    private String negative;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ViewPager viewPager = ((WriteHomeActivity) activity).getViewPager();
            activity.getFragmentManager().findFragmentById(viewPager.getCurrentItem());
//            noticeDialogListener = viewPager.get;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Bundle bundle = getArguments();
        builder.setMessage(bundle.getString("message"))
                .setPositiveButton(bundle.getString("positive"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        noticeDialogListener.onDialogPositiveClick(NoticeDialogFragment.this);
                    }
                })
                .setNegativeButton(bundle.getString("negative"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        noticeDialogListener.onDialogNegativeClick(NoticeDialogFragment.this);
                    }
                });

        return builder.create();
    }
}
