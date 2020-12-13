package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] names = {"wp2622932","bi","di","fi","hi","ji","ki","li","mi","ui","vi","wi"};
    int[] images = {R.drawable.wp2622932,R.drawable.bi,R.drawable.di,R.drawable.fi,R.drawable.hi,R.drawable.ji,R.drawable.ki,R.drawable.li,R.drawable.mi,R.drawable.ui,R.drawable.vi,R.drawable.wi};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter( names,images,this );

        gridView.setAdapter(customAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selectedName = names[i];
                int selectedImage = images[i];



                startActivity(new Intent(MainActivity.this,ClickedItemActivity.class).putExtra( "name", selectedName).putExtra( "image", selectedImage));
            }
        });
    }

    public class CustomAdapter extends BaseAdapter{
        private String[] imageNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

           if (view == null){
               view = layoutInflater.inflate(R.layout.row_items, viewGroup, false);
           }


            TextView tvName = view.findViewById(R.id.tvName);
            ImageView imageView = view.findViewById(R.id.imageView);


            tvName.setText(imageNames[i]);
            imageView.setImageResource(imagesPhoto[i]);




            return view;
        }
    }
}

