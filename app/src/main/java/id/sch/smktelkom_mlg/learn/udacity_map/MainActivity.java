package id.sch.smktelkom_mlg.learn.udacity_map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition TBN = CameraPosition.builder()
            .target(new LatLng(-6.895485, 112.029752))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition TOKYO = CameraPosition.builder()
            .target(new LatLng(35.689487, 139.691706))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition NGAWI = CameraPosition.builder()
            .target(new LatLng(-7.402921, 111.444668))
            .zoom(20)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition OSAKA = CameraPosition.builder()
            .target(new LatLng(34.693738, 135.502165))
            .zoom(45)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                   /* m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);*/
                    flyTo(TOKYO);
            }
        });

        Button btnSatellit = (Button) findViewById(R.id.btnSatellite);
        btnSatellit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                   /* m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);*/
                    flyTo(NGAWI);
            }
        });

        Button btnHybrid = (Button) findViewById(R.id.btnHybrid);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                   /* m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);*/
                    flyTo(OSAKA);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = map;
       /* LatLng newyork = new LatLng(40.712775, -74.005973);
        CameraPosition target = CameraPosition.builder().target(newyork).zoom(14).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));*/
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(TBN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}
