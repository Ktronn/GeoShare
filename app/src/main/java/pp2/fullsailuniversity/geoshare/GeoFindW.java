package pp2.fullsailuniversity.geoshare;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.RemoteViews;

public class GeoFindW extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetID: appWidgetIds)
        {
            Intent intent = new Intent(context,MapsActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.geo_widget);
            views.setOnClickPendingIntent(R.id.geo_find_button,pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetID,views);
        }
    }
}
