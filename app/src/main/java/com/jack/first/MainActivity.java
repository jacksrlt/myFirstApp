package com.jack.first;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

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
        return super.onOptionsItemSelected(item);
    }


}