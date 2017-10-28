package id.sch.smktelkom_mlg.learn.udacity_map;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    /* static final CameraPosition TBN = CameraPosition.builder()
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
            .build();*/

    GoogleMap m_map;
    boolean mapReady = false;
    /*MarkerOptions rmh;
    MarkerOptions kntr;
    MarkerOptions puskesmas;
    MarkerOptions sekolah;
    MarkerOptions polres;
    MarkerOptions alun2;*/
    LatLng renton = new LatLng(-8.400375, 114.273540);
    LatLng kirkland = new LatLng(47.7301986, -122.1768858);
    LatLng everett = new LatLng(47.978748, -122.202001);
    LatLng lynwood = new LatLng(47.819533, -122.32288);
    LatLng montlake = new LatLng(47.7973733, -122.3281771);
    LatLng kent = new LatLng(47.385938, -122.258212);
    LatLng showare = new LatLng(47.38702, -122.23986);


    /*@Override
    public Resources getResources() {
        return super.getResources();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*rmh = new MarkerOptions()
                .position(new LatLng(-7.567328, 111.277135))
                .title("My House")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        kntr = new MarkerOptions()
                .position(new LatLng(-7.568132, 111.288240))
                .title("Kantor Kecamatan Kendal")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        puskesmas = new MarkerOptions()
                .position(new LatLng(-7.536296, 111.248582))
                .title("Puskesmas")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        sekolah = new MarkerOptions()
                .position(new LatLng(-7.559236, 111.288869))
                .title("SMP 1 Kendal")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        polres = new MarkerOptions()
                .position(new LatLng(-7.399480, 111.446321))
                .title("Polres NGawi")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        alun2 = new MarkerOptions()
                .position(new LatLng(-7.402921, 111.444668))
                .title("Alun-alun Ngawi")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
*/
        /*Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                   *//* m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);*//*
                    flyTo(TOKYO);
            }
        });

        Button btnSatellit = (Button) findViewById(R.id.btnSatellite);
        btnSatellit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                   *//* m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);*//*
                    flyTo(NGAWI);
            }
        });

        Button btnHybrid = (Button) findViewById(R.id.btnHybrid);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                   *//* m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);*//*
                    flyTo(OSAKA);
            }
        });*/

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        //mapReady = true;
        m_map = map;
        /*LatLng newyork = new LatLng(40.712775, -74.005973);
        CameraPosition target = CameraPosition.builder().target(newyork).zoom(14).build();*/
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(SEATTLE));
        //map.addPolyline(new PolylineOptions().geodesic(true).add(renton).add(kirkland).add(everett).add(lynnwood).add(montlake).add(kent).add(showare).add(renton));
        //map.addPolygon(new PolygonOptions().add(renton, kirkland, everett, lynnwood).fillColor(Color.GREEN));
       /* m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(TBN);*/
        map.addCircle(new CircleOptions()
                .center(renton)
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 0)));
    }

    /*@Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = map;
        m_map.addMarker(rmh);
        m_map.addMarker(kntr);
        m_map.addMarker(puskesmas);
        m_map.addMarker(sekolah);
        m_map.addMarker(polres);
        m_map.addMarker(alun2);
    }*/

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
