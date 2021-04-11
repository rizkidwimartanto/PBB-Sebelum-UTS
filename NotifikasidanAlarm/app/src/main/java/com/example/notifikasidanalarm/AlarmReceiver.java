package com.example.notifikasidanalarm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    private static final int NOTIFICATION_ID = 0;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Aktif",
                Toast.LENGTH_SHORT).show();
        Uri notif =
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION
                );
        Ringtone r = RingtoneManager.getRingtone(context,
                notif);
        r.play();
        NotificationManager notifMgr = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pi =
                PendingIntent.getActivity(context,
                        NOTIFICATION_ID, i, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder build = new
                NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_alarm_foreground)
                .setContentTitle(context.getString(R.string.head))
                .setContentText(context.getString(R.string.content))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        notifMgr.notify(NOTIFICATION_ID, build.build());
    }
}