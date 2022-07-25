package com.example.settingpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.settingpage.fragment.ControlFragment;
import com.example.settingpage.fragment.SafeFragment;
import com.example.settingpage.fragment.ShootingFragment;
import com.example.settingpage.fragment.SystemFragment;
import com.example.settingpage.fragment.connectFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView safeView,
            connectView,
            shootingView,
            controlView,
            systemView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        replaceFragment(new SafeFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main_centent,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_button_safe:
                replaceFragment(new SafeFragment());
                break;
            case R.id.main_button_connect:
                replaceFragment(new connectFragment());
                break;
            case R.id.main_button_shooting:
                replaceFragment(new ShootingFragment());
                break;
            case R.id.main_button_control:
                replaceFragment(new ControlFragment());
                break;
            case R.id.main_button_system:
                replaceFragment(new SystemFragment());
                break;
            default:
                break;
        }
    }

    /*
     *初始化View
     */
    private void initView() {
        safeView = findViewById(R.id.main_button_safe);
        safeView.setOnClickListener(this::onClick);
        connectView = findViewById(R.id.main_button_connect);
        connectView.setOnClickListener(this::onClick);
        shootingView = findViewById(R.id.main_button_shooting);
        shootingView.setOnClickListener(this::onClick);
        controlView = findViewById(R.id.main_button_control);
        connectView.setOnClickListener(this::onClick);
        systemView = findViewById(R.id.main_button_system);
        systemView.setOnClickListener(this::onClick);
    }

}