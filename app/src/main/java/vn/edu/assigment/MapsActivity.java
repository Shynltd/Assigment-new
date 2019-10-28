package vn.edu.assigment;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private EditText edLat,edLon,edName;
    private GoogleMap mMap;
    Button btnThem,btnSua,btnXoa;
    int position = -1;
    Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        edLat=findViewById(R.id.edLat);
        edName=findViewById(R.id.edName);
        edLon=findViewById(R.id.edLon);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        final MarkerOptions markerOptions=new MarkerOptions();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 final double lat=Double.parseDouble(edLat.getText().toString());
                 final double lon=Double.parseDouble(edLon.getText().toString());
                final String name=edName.getText().toString();
                LatLng vitri=new LatLng(lat,lon);

                 mMap.addMarker(markerOptions.position(vitri).title(name));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(vitri));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(final Marker marker) {
                        edLon.setText(marker.getPosition().longitude+"");
                        edLat.setText(marker.getPosition().latitude+"");
                        edName.setText(marker.getTitle());
                        btnXoa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                marker.remove();
                            }
                        });
                        btnSua.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                marker.remove();
                                final double lat=Double.parseDouble(edLat.getText().toString());
                                final double lon=Double.parseDouble(edLon.getText().toString());
                                final String name=edName.getText().toString();
                                LatLng vitri=new LatLng(lat,lon);
                                mMap.addMarker(markerOptions.position(vitri).title(name));
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(vitri));

                            }
                        });
                        return false;
                    }
                });
            }
        });



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }


}
