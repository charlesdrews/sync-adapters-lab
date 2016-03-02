package com.charlesdrews.syncadapterslab;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by charlie on 3/2/16.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {
    private static final String TAG = SyncAdapter.class.getCanonicalName();

    ContentResolver mContentResolver;

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        mContentResolver = context.getContentResolver();
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,ContentProviderClient provider, SyncResult syncResult) {
        String data ="";
        try {
            //TODO - use the stock price api
            URL url = new URL("http://api.nytimes.com/svc/news/v3/content/all/all/all.json?limit=20&api-key=a8764563ef5394eb7142e890d45f914b:0:50241826");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inStream = connection.getInputStream();
            data = getInputData(inStream);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        /*
        Gson gson = new Gson();
        SearchResult result = gson.fromJson(data,SearchResult.class);

        int numArticles = result.getResults().size();
        int max = numArticles > 5 ? 5 : numArticles;
        for (int i = 0; i < max; i++) {
            Log.d(TAG, "Latest story: " + result.getResults().get(i).getTitle());
        }
        */
    }

    private String getInputData(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
