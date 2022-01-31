package y2020.aoc.bayan.taleb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

//this is the broadcast receiver class.
class NotificationReceiver extends BroadcastReceiver {
    //    public MyReceiver() {
    // }
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, NotificationIntentService.class);
        context.startService(intent1);
    }
}
