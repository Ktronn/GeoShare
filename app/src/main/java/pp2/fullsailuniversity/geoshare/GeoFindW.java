package pp2.fullsailuniversity.geoshare;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;



public class GeoFindW extends AppWidgetProvider {




    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetID : appWidgetIds) {



            // Create a Uri from an intent string. Use the result to create an Intent.
            Uri gmmIntentUri = Uri.parse("google.streetview:cbll=longitude,latitude");

            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");

            //Intent intent = new Intent(context, MapsActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, mapIntent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.geo_widget);
            views.setOnClickPendingIntent(R.id.geo_find_button, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetID, views);
        }
    }





}
