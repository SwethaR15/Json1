package com.example.admin.json1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById( R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        List<GS> jobListItems = new ArrayList<>();
        /*   List<JobListItem> jobListItems1 = new ArrayList<>();*/
        String json="{"+
                "\"Students\":["+
                "{"+
                "\"StudentName\" :\"MD.Asif\","+
                "\"College\"      :\"Jayamukhi\","+
                "\"Branch\"       :\"ECE\","+
                "\"Rollno\"      :\"404\""+
                "},{"+
                "\"StudentName\" :\"Surya\","+
                "\"College\"      :\"Jayamukhi\","+
                "\"Branch\"       :\"ECE\","+
                "\"Rollno\"      :\"406\""+
                "},{"+
                "\"StudentName\" :\"Thirupathi\","+
                "\"College\"      :\"Jayamukhi\","+
                "\"Branch\"       :\"ECE\","+
                "\"Rollno\"      :\"444\""+
                "},{"+
                "\"StudentName\" :\"Ramesh\","+
                "\"College\"      :\"Jayamukhi\","+
                "\"Branch\"       :\"ECE\","+
                "\"Rollno\"      :\"501\""+
                "}] }";
        try {
            JSONObject object= new JSONObject( json );
            JSONArray array=object.getJSONArray( "Students");

            for (int i=0;i<array.length();i++)
            {
                GS item = new GS();
                JSONObject list_obj = array.getJSONObject(i);
                item.setStudentName(list_obj.getString("StudentName"));
                item.setCollege(list_obj.getString("College"));
                item.setBranch(list_obj.getString("Branch"));
                item.setRollno(list_obj.getString("Rollno"));
                jobListItems.add( item );

            }
            recyclerView.setAdapter( new StudentAdapter( getApplicationContext(),jobListItems ) );
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
