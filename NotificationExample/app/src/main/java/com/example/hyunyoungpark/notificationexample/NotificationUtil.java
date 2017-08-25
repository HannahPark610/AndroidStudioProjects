package com.example.hyunyoungpark.notificationexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by hyunyoungpark on 2017-08-25.
 */

public class NotificationUtil {

    private static final int REMINDER_NOTIFICATION_ID = 1138;
    private static final int REMINDER_PENDING_INTENT_ID = 3417;

    private static final int ACTION_DRINK_PENDING_INTENT_ID = 1;
    private static final int ACTION_IGNORE_PENDING_INTENT_ID = 14;

    private static PendingIntent contentIntent (Context context)
    {
        Intent startActivityIntent = new
                Intent(context, com.example.hyunyoungpark.notificationexample.Notification.class); //mainActivity

        return PendingIntent.getActivity(
                context,
                REMINDER_PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
    }

    private static Bitmap largeIcon(Context context)
    {
        Resources res = context.getResources();
        Bitmap largeIcon = BitmapFactory.decodeResource(res, R.mipmap.ic_drink);
        return largeIcon;
    }

    public  static  void reminderUser (Context context) {

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                        .setSmallIcon(R.mipmap.ic_drink)
                        .setLargeIcon(largeIcon(context))
                        .setContentTitle(context.getString(R.string.title))
                        .setContentText(context.getString(R.string.content))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(
                                context.getString(R.string.content)))
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(contentIntent(context))
                        .addAction(drinkWaterAction(context))
                        .addAction(ignoreReminderAction(context))
                        .setAutoCancel(true);
        //If build version is grater than JELLY BEAN than set priority
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        }
        //get NotificationManager ,using
        //context.getSystemService(Context.NOTIFICATION_SERVICE)
        NotificationManager notificationManager =
                (NotificationManager) context
                        .getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(REMINDER_NOTIFICATION_ID,
                notificationBuilder.build());
    }

    //add a static method to drink
    private static NotificationCompat.Action drinkWaterAction(Context context)
    {
        //create intent to launch the reminder set action of intent create a pending ti launch the intentService
        //create an cation for user to notify return ths action
        Intent drinkWaterintent = new Intent(context, HandleIntent.class);

        //set action of intent
        drinkWaterintent.setAction(HandleAction.ACTION_DRINK_WATER);
        //create a pending intent to launch the intentService
        PendingIntent drinkWaterPI = PendingIntent.getService(
                context,
                ACTION_DRINK_PENDING_INTENT_ID,
                drinkWaterintent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );
        NotificationCompat.Action drinkwaterAction =
                new NotificationCompat.Action(R.mipmap.ic_drink,"DRINK IT",
                        drinkWaterPI);
        return drinkwaterAction;
    }

    private static NotificationCompat.Action ignoreReminderAction(Context context)
    {
        //create a intent to launch the reminder
        Intent ignoreWaterintent = new Intent(context, HandleIntent.class);

        //set action of intent
        ignoreWaterintent.setAction(HandleAction.ACTION_IGNORE);
        //create a pending intent to launch the intentService
        PendingIntent ignoreWaterPI = PendingIntent.getService(
                context,
                ACTION_IGNORE_PENDING_INTENT_ID,
                ignoreWaterintent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );
        //create an action for user to notify
        NotificationCompat.Action ignorewaterAction =
                new NotificationCompat.Action(R.mipmap.ic_drink,"DISMISS",
                        ignoreWaterPI);
        //return the action
        return ignorewaterAction;
    }

    public static void clearAllNotifications(Context context)
    {
        NotificationManager notificationManager =
                (NotificationManager)
                        context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }



}