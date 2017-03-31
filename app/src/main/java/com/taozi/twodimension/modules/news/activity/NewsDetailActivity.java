package com.taozi.twodimension.modules.news.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.se7en.utils.DeviceUtils;
import com.taozi.twodimension.R;
import com.taozi.twodimension.activity.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * Created by Tao Yimin on 2017/2/24.
 */
public class NewsDetailActivity extends BaseActivity{
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindViews({R.id.news_image1, R.id.news_image2, R.id.news_image3})
    List<ImageView> viewList;
    @BindView(R.id.web_view)
    WebView mWebView;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        String[] images=getIntent().getStringArrayExtra("images");
        int imageWidth=getIntent().getIntExtra("imageWidth",1);
        int imageHeight=getIntent().getIntExtra("imageHeight",1);
        String contentUrl=getIntent().getStringExtra("contentUrl");
        String title=getIntent().getStringExtra("title");
        mCollapsingToolbarLayout.setTitle(title);
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        //设置图片
        for(int i=0;i<images.length;i++){
            ImageView imageView=viewList.get(i);
            ViewGroup.LayoutParams params=imageView.getLayoutParams();
            params.height= DeviceUtils.getScreenWdith()*imageHeight/imageWidth;
            imageView.setLayoutParams(params);
            Glide.with(this).load(images[i]).into(viewList.get(i));
        }
        mWebView.getSettings().setJavaScriptEnabled(true);
        initWeb();
        mWebView.loadUrl(contentUrl);
    }

    @Override
    protected void loadData() {

    }

    /**
     * 初始化WebView
     */
    private void initWeb() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //开始加载页面的回调
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //结束加载页面的回调
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                //返回加载的进度
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
    }
}
