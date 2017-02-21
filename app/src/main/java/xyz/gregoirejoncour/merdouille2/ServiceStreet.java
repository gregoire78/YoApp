package xyz.gregoirejoncour.merdouille2;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import xyz.gregoirejoncour.merdouille2.model.StreetModel;

/**
 * Created by gregoire on 21/02/2017.
 */

public class ServiceStreet {
    private final String URL = "https://opendata.paris.fr/api/records/1.0/search/?dataset=voiesactuellesparis2012&facet=typvoie&facet=date_arret&facet=quartier&facet=arron";

    private Gson gson;

    public ServiceStreet() {
        gson = new Gson();
    }

    private InputStream sendRequest (URL url) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                return urlConnection.getInputStream();
            }
        } catch (Exception e) {
            return  null;
        }
        return null;
    }

    public List<StreetModel> getStreets(){
        try {
            InputStream inputStream = sendRequest(new URL(URL));
            if (inputStream != null){
                InputStreamReader reader = new InputStreamReader(inputStream);
                return gson.fromJson(reader, new TypeToken<List<StreetModel>>(){}.getType());
            }
        } catch (Exception e){
            Log.e("ServiceStreet", "Impossible d'acceder au service");
        }
        return null;
    }
}
