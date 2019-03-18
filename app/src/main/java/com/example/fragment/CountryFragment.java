package com.example.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends AppCompatDialogFragment {
    private EditText mCountryName;
    SendMessage SM;
    private static final String TAG = "123CountryFragment";

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_country_name, null);

        mCountryName = view.findViewById(R.id.et_enter_country);

        builder.setView(view)
                .setTitle("Enter Country:")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "cancelled", Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SM.sendData(mCountryName.getText().toString().trim());
                    }
                });
                return builder.create();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated");
//        mSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                SM.sendData(inData.getText().toString().trim());
//                SM.sendData(mCountryName.getText().toString().trim());
//            }
//        });
    }

    public interface SendMessage {
        void sendData(String message);
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach");
        super.onAttach(context);
        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");

    }
}
