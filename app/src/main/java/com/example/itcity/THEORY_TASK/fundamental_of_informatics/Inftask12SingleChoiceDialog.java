package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.itcity.R;

public class Inftask12SingleChoiceDialog extends DialogFragment {
    int position = -1;//default

    public interface SingleChoiceListener {
        void onPositiveButtonClicked(String[] list, int position);

        void onNegativeButtonClicked();
    }

    Inftask12SingleChoiceDialog.SingleChoiceListener mLisener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mLisener = (Inftask12SingleChoiceDialog.SingleChoiceListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + "SingleChoise must implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String[] list = getActivity().getResources().getStringArray(R.array.infchoice_items12);
        builder.setTitle("selest your choice")
                .setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {
                        position = i;
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick (DialogInterface dialogInterface,int i)
                    {
                        mLisener.onPositiveButtonClicked(list,position);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        mLisener.onNegativeButtonClicked();
                    }
                });
        return builder.create();
    }
}