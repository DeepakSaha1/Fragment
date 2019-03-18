package com.example.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements CountryFragment.SendMessage, View.OnClickListener {
    private static final String TAG = "123MainActivity";
    private Button mAddFragment;
    private Button mReplaceFragment;
    private Button mHideFragment;
    private Button mShowFragment;
    private Button mRemoveFragment;


    private Button mDialogFragment;
    private Button mPreferenceFragment;
    private FragmentManager fragmentManager;

    private EditText mCountryName;

    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        mAddFragment = findViewById(R.id.btn_add_fragment);
        mAddFragment.setOnClickListener(this);
        mRemoveFragment = findViewById(R.id.btn_remove_fragment);
        mRemoveFragment.setOnClickListener(this);
        mReplaceFragment = findViewById(R.id.btn_replace_fragment);
        mReplaceFragment.setOnClickListener(this);
        mHideFragment = findViewById(R.id.btn_hide_fragment);
        mHideFragment.setOnClickListener(this);
        mShowFragment = findViewById(R.id.btn_show_fragment);
        mShowFragment.setOnClickListener(this);

        mDialogFragment = findViewById(R.id.btn_dialog_fragment);
        mDialogFragment.setOnClickListener(this);
        mPreferenceFragment = findViewById(R.id.btn_preference_fragment);
        mPreferenceFragment.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();

        fragment2 = new Fragment2();
    }

    @Override
    public void sendData(String message) {
        Log.i(TAG, message);
        CountryListFragment f2 = (CountryListFragment) getSupportFragmentManager().findFragmentById(R.id.country_list_fragment);
        f2.displayRecivedMessage(message);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_fragment: {
                Log.i("add123", "btn add ");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction.add(R.id.dynamic_fragment_frame_layout, fragment1);
                fragmentTransaction.commit();
                break;
            }

            case R.id.btn_replace_fragment: {
                Log.i("replace", "btn replace");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction.replace(R.id.dynamic_fragment_frame_layout, fragment2);
                fragmentTransaction.commit();
                break;
            }

            case R.id.btn_hide_fragment: {
                Log.i("hide", "btn hide");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(fragmentManager.findFragmentById(R.id.dynamic_fragment_frame_layout));
                fragmentTransaction.commit();
                break;
            }

            case R.id.btn_show_fragment: {
                Log.i("show", "btn show");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.show(fragmentManager.findFragmentById(R.id.dynamic_fragment_frame_layout));
                fragmentTransaction.commit();
                break;
            }

            case R.id.btn_remove_fragment: {
                Log.i("remove", "btn remove");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(fragmentManager.findFragmentById(R.id.dynamic_fragment_frame_layout) != null ) {
                    fragmentManager.beginTransaction()
                            .remove(fragment2)
                            .commit();
                }

                fragmentTransaction.replace(R.id.dynamic_fragment_frame_layout, fragment2)
                        .addToBackStack(null)
                        .commit();

                break;
            }

            case R.id.btn_dialog_fragment: {
                Log.i("dialog", "btn dialog");
                openDialog();
                break;
            }

            case R.id.btn_preference_fragment: {
                Log.i("preference" ,"btn preference");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.dynamic_fragment_frame_layout, new PreferenceFragment());
                fragmentTransaction.commit();
            }
        }
    }

    public void openDialog() {
        CountryFragment countryFragment = new CountryFragment();
        countryFragment.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
