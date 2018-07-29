package com.example.alvar.books;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Book {

    private String title;
    private String imageURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @BindingAdapter({"android:bookImage"})
    public static void setImageUrl(ImageView view, String imageURL){
        Picasso.get()
                .load(imageURL)
                .fit()
                .error(R.drawable.ic_launcher_background)
                .into(view);
    }


}
