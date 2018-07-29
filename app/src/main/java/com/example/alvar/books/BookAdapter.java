package com.example.alvar.books;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alvar.books.databinding.ActivityMainBinding;
import com.example.alvar.books.databinding.MainActivityBookItemBinding;
import com.squareup.picasso.Picasso;
import java.util.List;
import static com.example.alvar.books.GlobalConstants.TITLE;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BindingHolder>{

    private final Context context;
    private List<Book> bookList;
    ActivityMainBinding binding;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.main_activity_book_item, viewGroup, false);

        BindingHolder bindingHolder = new BindingHolder(v);

        return bindingHolder;
    }

    @Override
    public void onBindViewHolder(BindingHolder bindingHolder, final int position) {

        Book book = bookList.get(position);
        bindingHolder.getBinding().setVariable(BR.ActivityMainBinding,book);


    }
    @Override
    public int getItemCount () {
        return bookList.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public BindingHolder(View rowView) {

            super(rowView);

            binding = DataBindingUtil.bind(rowView);

        }

        public ViewDataBinding getBinding() {

            return binding;

        }

    }


}