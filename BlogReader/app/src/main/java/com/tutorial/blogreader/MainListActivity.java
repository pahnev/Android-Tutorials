package com.tutorial.blogreader;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class MainListActivity extends ListActivity {

    public static final String TAG = MainListActivity.class.getSimpleName();

    protected JSONObject mBlogData;

    protected ProgressBar mProgressBar;

    public static final int NUMBER_OF_POSTS = 30;

    private final String KEY_TITLE = "title";
    private final String KEY_AUTHOR = "author";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


        if (isNetworkAvailable()) {

            executeBackgroundFetch();
        } else {
            Toast.makeText(getApplicationContext(),"Network is unavailable!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        try {
            JSONArray jsonPosts = mBlogData.getJSONArray("posts");
            JSONObject jsonPost = jsonPosts.getJSONObject(position);
            String blogUrl = jsonPost.getString("url");

            Intent intent = new Intent(this, BlogWebViewActivity.class);
            intent.setData(Uri.parse(blogUrl));
            startActivity(intent);


        } catch (JSONException e) {
            logException(e);
        }

    }

    private void logException(Exception e) {
        Log.e(TAG, "Exception caught!", e);
    }

    private void executeBackgroundFetch() {
        mProgressBar.setVisibility(View.VISIBLE);
        GetBlogPostsTask getBlogPostsTask = new GetBlogPostsTask();
        getBlogPostsTask.execute();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }


        return isAvailable;
    }


    private void handleBlogResponse() {
        mProgressBar.setVisibility(View.INVISIBLE);
        if (mBlogData == null) {
            showErrorOnDisplay();
        } else {
            try {
                JSONArray allPosts = mBlogData.getJSONArray("posts");

                ArrayList<HashMap<String, String>> blogPosts = new ArrayList<HashMap<String, String>>();
                for (int i = 0; i < allPosts.length(); i++) {
                    // Get each post and make into object
                    JSONObject singlePost = allPosts.getJSONObject(i);

                    // Go through object and get title
                    String title = singlePost.getString(KEY_TITLE);
                    // If title has special character we should convert them
                    title = Html.fromHtml(title).toString();
                    String author = singlePost.getString(KEY_AUTHOR);
                    author = Html.fromHtml(author).toString();

                    HashMap<String, String> blogPost = new HashMap<String, String>();
                    blogPost.put(KEY_TITLE, title);
                    blogPost.put(KEY_AUTHOR, author);

                    blogPosts.add(blogPost);

                }
                String[] keys = {KEY_TITLE, KEY_AUTHOR};
                int[] ids = {android.R.id.text1, android.R.id.text2};
                SimpleAdapter adapter = new SimpleAdapter(this, blogPosts, android.R.layout.simple_list_item_2, keys, ids);
                setListAdapter(adapter);

            } catch (JSONException e) {
                logException(e);
            }
        }
    }

    private void showErrorOnDisplay() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.alert_title));
        builder.setMessage(getString(R.string.alert_message));
        builder.setPositiveButton(android.R.string.ok, null);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView emptyTextView = (TextView) getListView().getEmptyView();
        emptyTextView.setText(getString(R.string.no_items));
    }

    private class GetBlogPostsTask extends AsyncTask<Object, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(Object[] params) {
            int responseCode = -1;
            JSONObject jsonResponse = null;

            try {
                URL blogFeedUrl = new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count=" + NUMBER_OF_POSTS);
                HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
                connection.connect();

                responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {

                    InputStream inputStream = connection.getInputStream();
                    Reader reader = new InputStreamReader(inputStream);

                    int contentLength = connection.getContentLength();
                    char[] charArray = new char[contentLength];

                    reader.read(charArray);

                    String responseData = new String(charArray);

                    jsonResponse = new JSONObject(responseData);


                } else {
                    Log.d(TAG, "Response code " +responseCode);
                }

            } catch (IOException | JSONException e) {
                logException(e);
            }
            return jsonResponse;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);

            mBlogData = result;
            handleBlogResponse();

        }
    }


}
