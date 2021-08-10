package com.gui.cvfacemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gui.cvfacemaker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    static {
        System.loadLibrary("native-lib");
    }

    public static native String stringFromJNI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //init jni
        JniWarpper.init();

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(JniWarpper.stringFromJNI());
    }
}