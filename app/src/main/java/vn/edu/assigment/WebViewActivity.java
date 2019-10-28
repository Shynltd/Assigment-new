package vn.edu.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
WebView wvNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wvNews=findViewById(R.id.wvNews);
        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        if (bundle != null){
            String lk= bundle.getString("link");
            wvNews.loadUrl(lk);
            wvNews.setWebViewClient(new WebViewClient());
        }
    }
}
