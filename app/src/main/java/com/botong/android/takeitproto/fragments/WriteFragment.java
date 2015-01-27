package com.botong.android.takeitproto.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.botong.android.takeitproto.R;
import com.botong.android.takeitproto.WriteActivity;
import com.botong.android.takeitproto.fragments.dialogs.NoticeDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class WriteFragment extends Fragment implements NoticeDialogFragment.NoticeDialogListener{

    public WriteFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write, container, false);
        Button write = (Button) view.findViewById(R.id.btnWriteWriteFragment);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v);
            }
        });
        return view;
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Intent intent = new Intent(dialog.getActivity(), WriteActivity.class);
        dialog.getActivity().startActivity(intent);
//        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(dialog.getActivity(), R.string.submit_completion, Toast.LENGTH_LONG).show();
    }

    private void showDialog(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("message", getString(R.string.dialog_question_write_fragment));
        bundle.putString("positive", getString(R.string.dialog_positvie_write_fragment));
        bundle.putString("negative", getString(R.string.dialog_negative_write_fragment));

        DialogFragment dialogFragment = new NoticeDialogFragment();
        dialogFragment.setArguments(bundle);
        dialogFragment.show(getChildFragmentManager(), getString(R.string.dialog_tag_write_fragment));
    }
}
