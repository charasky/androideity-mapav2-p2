package mx.androideity.mapav2;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends android.support.v4.app.FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        GoogleMap mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        
        mapa.setMyLocationEnabled(true);
        
        mapa.addMarker(new MarkerOptions()
        .position(new LatLng(19.432247,-99.133121))
        .title("Pais: México")
        .snippet("texto detalle"));
        
        mapa.setOnMarkerClickListener(new OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(
                    MainActivity.this,
                    "Marcador presionado:\n" +
                    marker.getTitle(),
                    Toast.LENGTH_SHORT).show();
         
                return false;
            }
        });
        
        mapa.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast.makeText(
	                    MainActivity.this,
	                    "Detalle de marcador:\n" +
	                    marker.getSnippet(),
	                    Toast.LENGTH_SHORT).show();
			}
		});
        
        /*LatLng df = new LatLng(19.432247,-99.133121);
        CameraPosition camPos = new CameraPosition.Builder()
                .target(df)  	  //Centramos el mapa en DF
                .zoom(18)         //Establecemos el zoom en 18
                .bearing(45)      //Establecemos la orientación con el noreste arriba
                .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                .build();
         
        CameraUpdate camUpd3 =
            CameraUpdateFactory.newCameraPosition(camPos);
         
        mapa.animateCamera(camUpd3);*/
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    
}
