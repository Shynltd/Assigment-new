package vn.edu.assigment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
public Context context;
public List<News> newsList;


    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDes=view.findViewById(R.id.tvDes);
        final News news=newsList.get(position);
        tvTitle.setText(news.title);
        tvDes.setText(news.description);
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,WebViewActivity.class);
                intent.putExtra("link",news.link);
                context.startActivity(intent);
            }
        });
        return view;
    }


}
