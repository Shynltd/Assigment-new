package vn.edu.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    private ListView lvListNews;
    private ArrayList<News> lvnews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        lvListNews = findViewById(R.id.lvNews);
        lvnews = new ArrayList<>();
        String url = "https://vietnamnet.vn/rss/giao-duc.rss";
        GetDATA getDATA = new GetDATA();
        getDATA.execute(url);

    }

    class GetDATA extends AsyncTask<String, Long, ArrayList<News>> {

        @Override
        protected ArrayList<News> doInBackground(String... strings) {
            String link = strings[0];

            try {
                URL url = new URL(link);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
                xmlPullParser.setInput(inputStream, "utf-8");

                int eventType = xmlPullParser.getEventType();
                News news = null;
                String text = "";
                while (eventType != xmlPullParser.END_DOCUMENT) {
                    eventType = xmlPullParser.getEventType();
                    String tag = xmlPullParser.getName();
                    switch (eventType) {
                        //Bắt đầu thẻ
                        case XmlPullParser.START_TAG:
                            if (tag.equalsIgnoreCase("item")) {
                                news = new News();
                            }
                            break;
                        case XmlPullParser.TEXT:
                            text = xmlPullParser.getText();
                            break;
                        case XmlPullParser.END_TAG:
                            if (news != null) {


                                if (tag.equalsIgnoreCase("title")) {
                                    news.title = text;
                                } else if (tag.equalsIgnoreCase("description")) {
                                    news.description = text;
                                } else if (tag.equalsIgnoreCase("pubDate")) {
                                    news.pubDate = text;
                                } else if (tag.equalsIgnoreCase("image")) {
                                    news.image = text;
                                } else if (tag.equalsIgnoreCase("link")) {
                                    news.link = text;
                                } else if (tag.equalsIgnoreCase("item")) {
                                    lvnews.add(news);
                                }
                            }
                            break;

                    }
                    xmlPullParser.next();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

            return lvnews;
        }

        @Override
        protected void onPostExecute(final ArrayList<News> news) {
            super.onPostExecute(news);
            final NewsAdapter newsAdapter = new NewsAdapter(NewsActivity.this, news);
            lvListNews.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();

        }
    }
}
