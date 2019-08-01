package br.com.k19.android.cap10_02;

import java.util.List;

import android.content.Context ;
import android.graphics.drawable . Drawable ;
import android.location.Location ;
import android.location.LocationListener ;
import android.location.LocationManager ;
import android.os.Bundle;

import com.google.android.maps.GeoPoint ;
import com.google.android.maps.MapActivity ;
import com.google.android.maps.MapController ;
import com.google.android.maps.MapView ;
import com.google.android.maps.MyLocationOverlay ;
import com.google.android.maps.Overlay ;
import com.google.android.maps.OverlayItem ;



import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;

public class MainActivity extends MapActivity {
	
	private MapController mapController ;
	private MapView mapView ;
	private CustomItemizedOverlay itemizedOverlay ;
	private MyLocationOverlay myLocationOverlay ;
	
	public void onCreate (Bundle bundle) {
		super.onCreate(bundle);
		setContentView (R.layout.main);
	
		mapView = (MapView )findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		
		mapView.setSatellite(false);
		mapController = mapView.getController();
		mapController.setZoom (14);
		
		myLocationOverlay = new MyLocationOverlay (this, mapView);
		mapView.getOverlays().add(myLocationOverlay);
		
		List < Overlay > mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources ().getDrawable(R.drawable.k19_logo);
		itemizedOverlay = new CustomItemizedOverlay (this, drawable);
		
		GeoPoint point = new GeoPoint (-23570794, -46690747);
		OverlayItem overlayitem = new OverlayItem (point, "K19", "Cursos e Treinamentos");
		
		itemizedOverlay.addOverlay (overlayitem);
		mapOverlays.add (itemizedOverlay);
	}
	@Override
	protected boolean isRouteDisplayed () {
		return false ;
	}
}
