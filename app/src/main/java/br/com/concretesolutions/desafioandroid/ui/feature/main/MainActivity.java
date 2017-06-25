package br.com.concretesolutions.desafioandroid.ui.feature.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.databinding.AMainBinding;
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity;
import br.com.concretesolutions.desafioandroid.ui.base.BaseFragment;
import br.com.concretesolutions.desafioandroid.ui.feature.movie.PopularMoviesFragment;
import br.com.concretesolutions.desafioandroid.ui.feature.profile.ProfileFragment;
import br.com.concretesolutions.desafioandroid.ui.feature.tv.TVShowFragment;
import br.com.concretesolutions.desafioandroid.ui.util.FragmentUtils;

import static br.com.concretesolutions.desafioandroid.ui.feature.main.MainTabs.MOVIE;
import static br.com.concretesolutions.desafioandroid.ui.feature.main.MainTabs.PROFILE;
import static br.com.concretesolutions.desafioandroid.ui.feature.main.MainTabs.TV_SHOW;

public class MainActivity extends BaseActivity {

    private static final String SELECTED_TAB_KEY = "SELECTED_TAB_KEY";
    private AMainBinding binding;
    private @MainTabs String selectedTab = MOVIE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.a_main);
        setupBottomNavigation();
        restoreState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull final Bundle outState) {
        outState.putString(SELECTED_TAB_KEY, selectedTab);
        super.onSaveInstanceState(outState);
    }

    private void restoreState(Bundle savedState) {
        if (savedState != null)
            //noinspection WrongConstant
            selectedTab = savedState.getString(SELECTED_TAB_KEY, MOVIE);
        changeToFragment(selectedTab);
    }

    private void setupBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bot_nav_item_movies:
                    selectedTab = changeToFragment(MOVIE);
                    break;
                case R.id.bot_nav_item_tv_shows:
                    selectedTab = changeToFragment(TV_SHOW);
                    break;
                case R.id.bot_nav_item_profile:
                    selectedTab = changeToFragment(PROFILE);
                    break;
            }
            return true;
        });
    }

    private @MainTabs String changeToFragment(@NonNull final String fragmentTag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction = removeCurrentFragment(transaction, fragmentTag);
        transaction = attachNewFragment(transaction, fragmentTag);
        transaction.commit();
        return fragmentTag;
    }

    private FragmentTransaction removeCurrentFragment(final FragmentTransaction transaction, @NonNull String fragmentTag) {
        final BaseFragment currentFragment = FragmentUtils.findById(this, R.id.main_fragment_root);

        if (currentFragment != null) {
            if (fragmentTag.equals(currentFragment.getTag()))
                return transaction;
            transaction.detach(currentFragment);
        }
        return transaction;
    }

    private FragmentTransaction attachNewFragment(final FragmentTransaction transaction, @NonNull String fragmentTag) {
        final BaseFragment fragment = FragmentUtils.findByTag(this, fragmentTag);
        if (fragment == null)
            transaction.add(R.id.main_fragment_root, createFragmentByTag(fragmentTag), fragmentTag);
        else
            transaction.attach(fragment);

        return transaction;
    }

    private BaseFragment createFragmentByTag(@NonNull @MainTabs final String fragmentTag) {
        switch (fragmentTag) {
            case MOVIE:
            default:
                return PopularMoviesFragment.newInstance();
            case TV_SHOW:
                return TVShowFragment.newInstance();
            case PROFILE:
                return ProfileFragment.newInstance();
        }
    }
}
