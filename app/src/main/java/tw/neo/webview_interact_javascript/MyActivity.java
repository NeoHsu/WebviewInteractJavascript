package tw.neo.webview_interact_javascript;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;
import java.util.Arrays;

public class MyActivity extends ActionBarActivity {
    WebView webview;
    String mStringArray[] = { "Keelung","Taipei","Kaohsiung","Hualien","Yunlin","Nantou","Taoyuan","Chiayi","Hsinchu","Tainan","Panchiao","Ilan","Taitung","Miaoli","Taichung","Changhua","Pingtung","Penghu","Green Island","Orchid Island","Cimei","Magong","Mazu","Kinmen" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        webview = (WebView) this.findViewById(R.id.webView1);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.addJavascriptInterface(this, "android");
        webview.requestFocusFromTouch();
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl("file:///android_asset/web.html");
    }

    @JavascriptInterface
    public String getData() {
        JSONArray mJSONArray = new JSONArray(Arrays.asList(mStringArray));
        return mJSONArray.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
