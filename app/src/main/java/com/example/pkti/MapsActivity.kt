package com.example.pkti

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build.ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.google.android.material.shape.MarkerEdgeTreatment
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.navigation_button.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private var locationPermissionGranted = false
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
//    private val defaultLocation = LatLng(-33.8523341, 151.2106085)
    private lateinit var locationCallback: LocationCallback
    private lateinit var locationRequest: LocationRequest
    private var locationUpdateState = false
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                super.onLocationResult(p0)

                lastLocation = p0.lastLocation
//                placeMarkerOnMap(LatLng(lastLocation.latitude, lastLocation.longitude))
//                mMap.addMarker(MarkerOptions().position(LatLng(lastLocation.latitude, lastLocation.longitude)).title("Marker"))
            }
        }
        createLocationRequest()

        //RecyclerView
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mapRecyclerView.layoutManager = linearLayoutManager
        mapRecyclerView.adapter = NearbyAdapter()


        bottomNavigationView.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.person -> {
                    val intentperson = Intent(this, MainProfileActivity::class.java)
                    startActivity(intentperson)
                }
                R.id.list -> {
                    val intentlist = Intent(this, MainActivityList::class.java)
                    startActivity(intentlist)
                }
                R.id.map -> {
                    val intentmap = Intent(this, MapsActivity::class.java)
                    startActivity(intentmap)
                }
            }
            true
        }

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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //Add zoom controller
//        mMap.uiSettings.isZoomControlsEnabled = true
//        mMap.setOnMarkerClickListener(this)

        // Add a marker in Sydney and move the camera
        addMarker(-34.0, 151.0, "Marker in Sydney")
        addMarker(40.758895, -73.985131, "Marker in New York Times Square")
        addMarker(3.58772967702887, 98.69074755419068, "Mirkoskil")
        addMarker(3.5872049942387148, 98.69186335311466, "Stasiun KA Medan")
        addMarker(3.590256476345836, 98.67381096768324, "UPH")
        addMarker(3.329961454914897, 99.16207969651815, "Food Court")
        addMarker(3.3267619019602845, 99.15503485418974, "Hotel")
//        mMap.setMinZoomPreference(0f)
//        mMap.setMaxZoomPreference(14.0f)

        getLocationPermission()
        getLocationUpdate()
//        getCurrentLocation()
    }

    override fun onMarkerClick(p0: Marker?): Boolean = false

    private fun getLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION)
            return
        }
        locationPermissionGranted = true
        mMap.isMyLocationEnabled = true
        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) { loc ->
            if (loc != null){
                lastLocation = loc
                val currentLatLng = LatLng(loc.latitude, loc.longitude)
//                placeMarkerOnMap(currentLatLng)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
            }else{
                Log.d(TAG, "Current location is null. Using defaults.")
                getLocationUpdate()
            }
        }

    }

    private fun placeMarkerOnMap(location: LatLng){
        val markerOption = MarkerOptions().position(location)
        mMap.addMarker(markerOption)
    }

    private fun getLocationUpdate() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION)
            return
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null)
        getLocationPermission()
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)

        val client = LocationServices.getSettingsClient(this)
        val task = client.checkLocationSettings(builder.build())

        task.addOnSuccessListener {
            locationUpdateState = true
            getLocationUpdate()
        }
        task.addOnFailureListener { e ->
            if (e is ResolvableApiException) {
                try {
                    e.startResolutionForResult(this@MapsActivity,
                        REQUEST_CHECK_SETTINGS)
                } catch (sendEx: IntentSender.SendIntentException) {
                    // Ignore the error.
                }
            }
        }
    }

    fun addMarker(lat: Double, lng: Double, text: String? = null){
        val place = LatLng(lat, lng)
        mMap.addMarker(MarkerOptions().position(place).title("$text"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 12f))
    }



    companion object {
        private val TAG = MapsActivity::class.java.simpleName
        private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
        private const val REQUEST_CHECK_SETTINGS = 2

    }


}