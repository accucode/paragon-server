package com.app.ui.control;

import com.kodemore.collection.KmList;
import com.kodemore.geocode.KmGeocodeLocation;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.variable.ScLocalDouble;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalList;

/**
 * Display a google map in a div that can be updated dynamically
 * via ajax. This requires the googleapis library to be pre-loaded
 * as part of the page setup.
 *    <script src="https://maps.googleapis.com/maps/api/js?key=[[API_KEY]]" async defer></script>
 */
public class MyGoogleMapView
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The height must be set explicitly for google maps.
     * Dynamically sized boxes do not refresh correctly.
     */
    private ScLocalInteger _height;

    /**
     * The default location for the center of the map.
     * If markers are added, the automatic zoom/pan may override this.
     */
    private ScLocalDouble _longitude;

    /**
     * The default location for the center of the map.
     * If markers are added, the automatic zoom/pan may override this.
     */
    private ScLocalDouble _latitude;

    /**
     * The default zoom level for the map.
     * If markers are added, the automatic zoom/pan may override this.
     */
    private ScLocalInteger _zoom;

    /**
     * An optional list of markers.
     */
    private ScLocalList<MyGoogleMapMarker> _markers;

    //##################################################
    //# constructor
    //##################################################

    public MyGoogleMapView()
    {
        _height = new ScLocalInteger(400);

        _latitude = new ScLocalDouble();
        _longitude = new ScLocalDouble();
        _zoom = new ScLocalInteger(14);
        _markers = new ScLocalList<>();
    }

    //##################################################
    //# height
    //##################################################

    public int getHeight()
    {
        return _height.getValue();
    }

    public void setHeight(int e)
    {
        _height.setValue(e);
    }

    //##################################################
    //# zoom
    //##################################################

    public int getZoom()
    {
        return _zoom.getValue();
    }

    public void setZoom(int e)
    {
        _zoom.setValue(e);
    }

    //##################################################
    //# latitude
    //##################################################

    public Double getLatitude()
    {
        return _latitude.getValue();
    }

    public void setLatitude(Double e)
    {
        _latitude.setValue(e);
    }

    public boolean hasLatitude()
    {
        return _latitude.hasValue();
    }

    //##################################################
    //# longitude
    //##################################################

    public Double getLongitude()
    {
        return _longitude.getValue();
    }

    public void setLongitude(Double e)
    {
        _longitude.setValue(e);
    }

    public boolean hasLongitude()
    {
        return _longitude.hasValue();
    }

    //##################################################
    //# markers
    //##################################################

    public KmList<MyGoogleMapMarker> getMarkers()
    {
        return _markers.getValue();
    }

    public void addMarker(MyGoogleMapMarker e)
    {
        _markers.add(e);
    }

    public void addMarker(KmGeocodeLocation loc)
    {
        MyGoogleMapMarker e;
        e = new MyGoogleMapMarker();
        e.setTitle(loc.getAddress());
        e.setLatitude(loc.getLatitude());
        e.setLongitude(loc.getLongitude());
        addMarker(e);
    }

    //##################################################
    //# convenience
    //##################################################

    public boolean hasLocation()
    {
        return hasLatitude() && hasLongitude();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
        getInner().style().height(getHeight());
    }

    //##################################################
    //#
    //##################################################

    @Override
    public final void renderControlOn(KmHtmlBuilder out)
    {
        super.renderControlOn(out);

        showMap(out);
    }

    private void showMap(KmHtmlBuilder out)
    {
        if ( !hasLocation() )
            return;

        KmJsonMap options;
        options = new KmJsonMap();
        options.setString("id", getInner().getHtmlId());
        options.setInteger("zoom", getZoom());
        options.setDouble("latitude", getLatitude());
        options.setDouble("longitude", getLongitude());

        KmJsonArray markers = options.setArray("markers");
        for ( MyGoogleMapMarker e : getMarkers() )
        {
            KmJsonMap marker;
            marker = markers.addMap();
            marker.setString("title", e.getTitle());
            marker.setDouble("latitude", e.getLatitude());
            marker.setDouble("longitude", e.getLongitude());
        }

        out.getPostDom().run("Kmu.showGoogleMap(%s);", options);
    }

}
