package com.example.alvar.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alvar.books.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetResults{

    private RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        JsonExtractor jsonExtractor = new JsonExtractor(this, this);
        jsonExtractor.execute();

    }

    @Override
    public void displayBookInformation(List<Book> books) {
        List<Book> ausBooks = books;
        adapter = new BookAdapter(this,ausBooks);
        recyclerView = (RecyclerView) findViewById(R.id.main_rv_books);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
