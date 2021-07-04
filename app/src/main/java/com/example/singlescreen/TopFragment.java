package com.example.singlescreen;



import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.singlescreen.Adapter.MyTopAdapter;
import com.example.singlescreen.model.APIData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TopFragment extends Fragment  {
    RecyclerView recyclerView;
    ArrayList<APIData> apiData = new ArrayList<>();
    MyTopAdapter myTopAdapter;
    SendMessage sm;

    interface SendMessage {
        void sendData(String name,String des);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topfragment, container, false);
        recyclerView = view.findViewById(R.id.toprecyclerview);

        myTopAdapter = new MyTopAdapter(apiData, (name, des) -> {
            Log.e(" data    -----     ",name+">>>>>>>>>> "+ des);
            sm.sendData(name,des);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myTopAdapter);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    public void getData() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String ou_response;
        Request request = new Request.Builder()
                .url("https://api.publicapis.org/entries")
                .get()
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            ou_response = response.body().string().trim();
            JSONObject result = new JSONObject(ou_response);
            JSONArray jsonArray= result.getJSONArray("entries");
            //gettong array at 0 index
            System.err.println(jsonArray.length());
            for (int i=0;i<jsonArray.length();i++){
                JSONObject apidata = jsonArray.getJSONObject(i);
                System.err.println( " >>>  "+apidata.getString("API"));
                System.err.println( " >>>  "+apidata.getString("Description"));
                apiData.add(new APIData(apidata.getString("API"), apidata.getString("Description")));
            }
            myTopAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof SendMessage){
            sm = (SendMessage) getActivity();
        }
        else{
            throw new RuntimeException(context.toString()+
                    "must implement fragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sm=null;
    }
}