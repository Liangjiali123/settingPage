package com.example.settingpage;

import androidx.fragment.app.Fragment;

import com.example.settingpage.base.BasePresent;
import com.example.settingpage.fragment.ControlFragment;
import com.example.settingpage.fragment.SafeFragment;
import com.example.settingpage.fragment.ShootingFragment;
import com.example.settingpage.fragment.SystemFragment;
import com.example.settingpage.fragment.connectFragment;

public class MainActivityPresenter extends BasePresent<IMainActivityContract.Iview> implements IMainActivityContract.IPresenter{

    private Fragment[] fragments = new Fragment[5];

    public MainActivityPresenter(IMainActivityContract.Iview view){
        super(view);
    }

    private void newCurrentFragment(int index){
        Fragment fragment = null;
        switch (index){
            case 0 :
                fragment = new SafeFragment();
                break;
            case 1:
                fragment = new connectFragment();
                break;
            case 2:
                fragment = new ShootingFragment();
                break;
            case 3:
                fragment = new ControlFragment();
                break;
            case 4:
                fragment = new SystemFragment();
                break;
            default:
                break;
        }
        fragments[index] = fragment;
        addAndShowFragment(fragment);
    }

    private void addAndShowFragment(Fragment fragment) {
        if (fragment.isAdded()){

        }
    }

    @Override
    public void replaceFragment(int index) {

        for (int i = 0;i < fragments.length;i++){
            if (index != i){
                if (fragments[i] != null){
                    hideFragment(fragments[i]);
                }
            }
        }

    }

    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()) {
            hideFragment(fragment);
        }
    }
}
