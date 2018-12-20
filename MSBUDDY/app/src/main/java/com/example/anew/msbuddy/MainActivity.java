package com.example.anew.msbuddy;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.app.FragmentManager fragmentmanager = getFragmentManager();
        fragmentmanager.beginTransaction()
                .replace(R.id.content_frame
                        ,new Apply_Semester()).addToBackStack(null)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
      //  drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if(navigationView!=null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer!=null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
               // super.onBackPressed();
                if(getFragmentManager()!=null) {
                    if (getFragmentManager().getBackStackEntryCount() > 1) {
                        getFragmentManager().popBackStackImmediate();
                    } else {
                        finish();
                    }
                }
                else
                {
                    super.onBackPressed();
                }
            }
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentmanager = getFragmentManager();
        if (id == R.id.profile_evaluator) {
            FragmentManager fm = getFragmentManager();
            for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                fm.popBackStack();
            }
            fragmentmanager.beginTransaction()
                    .replace(R.id.content_frame
                    ,new Apply_Semester()).addToBackStack(null)
                    .commit();

            this.setTitle("Profile Evaluater");
        } else if (id == R.id.application_timeline) {
            FragmentManager fm = getFragmentManager();

            for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                fm.popBackStack();
            }
            fragmentmanager.beginTransaction()
                    .replace(R.id.content_frame
                            ,new applicationtimeline_fragment()).addToBackStack(null)
                    .commit();

            this.setTitle("Timeline");

        } else if (id == R.id.about_gre) {
            FragmentManager fm = getFragmentManager();
            for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                fm.popBackStack();
            }
            fragmentmanager.beginTransaction()
                    .replace(R.id.content_frame
                            ,new about_GRE_fragment()).addToBackStack(null)
                    .commit();

            this.setTitle("About GRE");

        }
        else if (id == R.id.about_toefl) {
            FragmentManager fm = getFragmentManager();
            for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                fm.popBackStack();
            }
            fragmentmanager.beginTransaction()
                    .replace(R.id.content_frame
                            ,new about_TOEFL_fragment()).addToBackStack(null)
                    .commit();

            this.setTitle("About TOEFL");

        }
        else if (id == R.id.about_ielts) {
            FragmentManager fm = getFragmentManager();
            for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                fm.popBackStack();
            }
            fragmentmanager.beginTransaction()
                    .replace(R.id.content_frame
                            ,new about_IELTS_fragment() ).addToBackStack(null)
                    .commit();

            this.setTitle("About IELTS");

        }else if (id == R.id.university_ranking) {
            FragmentManager fm = getFragmentManager();
            for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                fm.popBackStack();
            }
            fragmentmanager.beginTransaction()
                    .replace(R.id.content_frame
                            ,new universityranking_fragment()).addToBackStack(null)
                    .commit();

            this.setTitle("University Ranking");

        } else if (id == R.id.nav_share) {
            ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer!=null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

}
