package com.example.dell.hi_kitu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.view.animation.AnimationUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.fragment;
import static java.net.Proxy.Type.HTTP;

public class Navigation_Main_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Animation Fade_in, Fade_out;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title_txt;
        title_txt = (TextView) findViewById(R.id.nav_title_txt);
        String message = getIntent().getStringExtra("MESSAGE");
        title_txt.setText(message);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_staggered_view);
        recyclerView.setHasFixedSize(true);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        List<Posts> gaggeredList = getListItemData();
        My_Staggered_Recycler_View_Adapter rcAdapter = new My_Staggered_Recycler_View_Adapter(Navigation_Main_Activity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        viewFlipper = (ViewFlipper) headerView.findViewById(R.id.slideshow_view);
        Fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Fade_out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        viewFlipper.setAnimation(Fade_in);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation__main_, menu);
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
        if (id == R.id.action_log_out) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();
        PackageManager packageManager = getPackageManager();


        if (id == R.id.nav_camera) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
               // Toast.makeText(this, "You dont have permissoin to access camera..", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
            } else {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        } else if (id == R.id.nav_gallery) {

            Intent intent = new Intent();
            // Show only images, no videos or anything else
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 102);

        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(getApplicationContext(), Slideshow_All.class);
            startActivity(i);
        }
        else if(id==R.id.nav_musicplayer){
            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            File file = new File("Internal storage\\Music");
            intent.setDataAndType(Uri.fromFile(file), "audio/*");
            startActivity(intent);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            fragment = new ShareFragment();

        } else if (id == R.id.nav_send) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
           // emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"rajdeep194@gmail.com "}); // recipients
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sending a mail through my app");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I did it!!");
           // emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris

        }
        ft.replace(R.id.floating_icon_fragment, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void addListenerOnButton() {

    }


        private List<Posts> getListItemData() {

        List<Posts> listViewItems = new ArrayList<Posts>();
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.e));
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.c));
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.a));
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.ee));
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.g));
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.aa));
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.i));
        listViewItems.add(new Posts("abc", "xyz", R.mipmap.alley));

        return listViewItems;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==102){
                Uri uri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    // Log.d(TAG, String.valueOf(bitmap));
                    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                    View headerView = navigationView.getHeaderView(0);
                    ImageView imageView = (ImageView) headerView.findViewById(R.id.img_header);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(this,"welcome back to activity", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
