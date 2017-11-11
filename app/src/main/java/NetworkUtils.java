import android.net.Uri;

import com.example.jelani.whowroteit.MainActivity;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * Created by jelani on 11/11/17.
 */


public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //Base URI for the books API
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    private static final String QUERY_PARAM = "q";//Query for the search string
    private static final String MAX_RESULTS = "maxResults";//Parameter that limits search results
    private static final String PRINT_TYPE = "printType";//Parameter to filter by print type

    static String getBookInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;

        try {
            //Build your URI query, limiting results to 10 items and printed books
            Uri builtUri = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();

            URL requestURL = new URL(builtUri.toString());



        }catch (Exception e){

        }finally {
            return bookJSONString;
        }
    }



}
