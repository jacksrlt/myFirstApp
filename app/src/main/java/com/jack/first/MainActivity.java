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
    //private String webUrl = miVisorWeb.getUrl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //WebView mycontext = (WebView) findViewById(R.id.vistaweb);
        //registerForContextMenu(mycontext);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        miVisorWeb.getSettings().setBuiltInZoomControls(false);
        miVisorWeb.loadUrl("https://en.wikipedia.org/wiki/Special:Random");
        miVisorWeb.setWebViewClient(new WebViewClient());
    }

    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        MaterialAlertDialogBuilder builder = new
                MaterialAlertDialogBuilder(MainActivity.this);
        builder.setTitle("Hey!");
        builder.setMessage("Are you sure you want to leave?");
        builder.setIcon(R.drawable.ic_baseline_emoji_people_24);

        // add the buttons
        builder.setPositiveButton("Yes", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
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
                        // do something like...
                        dialog.dismiss();
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Get wiser! :-)", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.loadUrl("https://en.wikipedia.org/wiki/Special:Random");
            swipeLayout.setRefreshing(false);
        }

    };

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v,
//                                    ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.menu_context, menu);
//    }

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.item1:
//    //            Toast toast = Toast.makeText(this,"Item copied",
//    //                    Toast.LENGTH_LONG );
//    //            toast.show();
//
//                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);
//
//                Snackbar snackbar = Snackbar
//                        .make(mLayout, "Item copied to clipboard", Snackbar.LENGTH_LONG)
//                        .setAction("UNDO", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action restored", Snackbar.LENGTH_SHORT);
//                                snackbar1.show();
//                            }
//                        });
//
//                snackbar.show();
//                return true;
//
//            case R.id.item2:
//                Toast toast2 = Toast.makeText(this,"Item downloaded",
//                        Toast.LENGTH_LONG );
//                toast2.show();
//                return true;
//                default:
//                return super.onContextItemSelected(item);
//       }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast toast = Toast.makeText(this,"Copied!",Toast.LENGTH_LONG );
            toast.show();
            return true;
        }

        if (id == R.id.item2) {
            return true;
        }

        if (id == R.id.item3) {
            return true;
        }

        if (id == R.id.item4) {
            showAlertDialogButtonClicked(MainActivity.this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}