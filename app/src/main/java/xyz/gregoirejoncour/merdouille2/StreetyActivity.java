package xyz.gregoirejoncour.merdouille2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import xyz.gregoirejoncour.merdouille2.model.StreetModel;

public class StreetyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streety);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ServiceStreet serv = new ServiceStreet();
                List<StreetModel> List = serv.getStreets();
            }
        }).start();

    }
}
