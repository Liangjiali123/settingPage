package com.example.settingpage;

import androidx.fragment.app.Fragment;

public interface IMainActivityContract {

    interface Iview{
        void showFragment(Fragment fragment);
        void addFragment(Fragment fragment);
        void hideFragment(Fragment fragment);
    }
    interface IPresenter{
        void replaceFragment(int index);
    }

}
