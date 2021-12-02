package com.jack.first;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

    //Links and variables for WebView
    String link = "https://en.wikipedia.org/wiki/Special:Random";
    String link2;
    String oldlang;
    String newlang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Swipe
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //WebView
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        miVisorWeb.getSettings().setBuiltInZoomControls(false);
        miVisorWeb.loadUrl(link);
        miVisorWeb.setWebViewClient(new WebViewClient());
    }

    //Alert dialogs

    //Signout alert dialog
    public void showAlertDialogButtonClicked(MainActivity view) {

        //Setup for signout alert dialog
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);
        builder.setTitle("Hey!");
        builder.setMessage("Are you sure you want to leave?");
        builder.setIcon(R.drawable.ic_baseline_emoji_people_24);

        //Buttons for signout alert dialog
        builder.setPositiveButton("Yes", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Function sends user to Login activity
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
        builder.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Closes alert dialog
                        dialog.dismiss();
                    }
                });
        //Create and show the signout alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //Language alert dialog
    public void showAlertDialogButtonClicked2(MainActivity view) {
        //Language alert dialog setup
        MaterialAlertDialogBuilder builder2 = new MaterialAlertDialogBuilder(MainActivity.this);
        builder2.setTitle("Pick a language");
        builder2.setMessage("Keep in mind the article might not be available in the selected language");
        builder2.setIcon(R.drawable.ic_baseline_language_24);

        //Buttons for language alert dialog
        builder2.setPositiveButton("Spanish", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Function sets Wikipedias article URL to spanish and loads new URL
                        oldlang = "en";
                        newlang = "es";
                        link2 = miVisorWeb.getUrl();
                        link2 = link2.replaceFirst(oldlang, newlang);
                        link = link.replaceFirst(oldlang, newlang);
                        miVisorWeb.loadUrl(link2);
                    }
                });
        builder2.setNeutralButton("English", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Function sets Wikipedia's article URL to english and loads new URL
                        oldlang = "es";
                        newlang = "en";
                        link2 = miVisorWeb.getUrl();
                        link2 = link2.replaceFirst(oldlang, newlang);
                        link = link.replaceFirst(oldlang, newlang);
                        miVisorWeb.loadUrl(link2);
                    }
                });
        //Create and show language alert dialog
        AlertDialog dialog2 = builder2.create();
        dialog2.show();
    }

    //Swiperefresh loads the random Wikipedia website again to show a different article
    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Get wiser! :-)", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.loadUrl(link);
            swipeLayout.setRefreshing(false);
        }

    };

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    //Selected menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //Saves WebView URL to Bookmarked Array
        if (id == R.id.item1) {
            Toast toast = Toast.makeText(this,"Saved to bookmark!",Toast.LENGTH_LONG );
            Bookmarked.bookmarks.add(miVisorWeb.getUrl());
            toast.show();
            return true;
        }

        //Shows Language alert dialog
        if (id == R.id.item2) {
            showAlertDialogButtonClicked2(MainActivity.this);
            return true;
        }

        //Sends user to Bookmarks activity
        if (id == R.id.item3) {
            Intent intent = new Intent(MainActivity.this, Bookmarked.class);
            startActivity(intent);
            return true;
        }

        //Shows Signout alert dialog
        if (id == R.id.item4) {
            showAlertDialogButtonClicked(MainActivity.this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}