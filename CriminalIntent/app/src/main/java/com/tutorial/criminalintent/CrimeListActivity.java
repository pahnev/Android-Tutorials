package com.tutorial.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by kirill on 2/16/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
