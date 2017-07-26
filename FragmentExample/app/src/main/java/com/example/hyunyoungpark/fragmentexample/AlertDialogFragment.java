package com.example.hyunyoungpark.fragmentexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by hyunyoungpark on 2017-07-26.
 */

public class AlertDialogFragment extends android.app.DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog ad = new AlertDialog.Builder(getActivity())
                .setTitle("alert Dialog")
                .setMessage("Choose anyone option 10cancel or 2ok")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();

        return ad;
    }
}
