package com.example.alvar.books;
import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

import static com.example.alvar.books.GlobalConstants.BOOK_URL;

public class JsonExtractor extends AsyncTask<String, Void, List<Book>>{
    private Context context;
    private GetResults getResults;


    public JsonExtractor(Context context, GetResults getResults){
        this.context = context;
        this.getResults = getResults;
    }

    @Override
    protected List<Book> doInBackground(String... strings) {

        String result = NetworkOperations.getJsonFromApi(BOOK_URL);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Book>>(){}.getType();
        List<Book> books = gson.fromJson(result, listType);

        if(books == null || books.isEmpty()){

            return null;
        }

        return books;
    }

    @Override
    protected void onPostExecute(List<Book> books) {
        super.onPostExecute(books);
        getResults.displayBookInformation(books);
        }

    }
