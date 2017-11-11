import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by jelani on 11/11/17.
 */

public class FetchBook extends AsyncTask<String,Void,String> {
    private TextView mTitleText;
    private TextView mAuthorText;

    public FetchBook(TextView mTitleText, TextView mAuthorText){
        mTitleText = mTitleText;
        mAuthorText = mAuthorText;
    }


    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
