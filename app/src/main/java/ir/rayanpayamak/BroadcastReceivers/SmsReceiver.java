package ir.rayanpayamak.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;


public class SmsReceiver extends BroadcastReceiver {



    private static SmsListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {

        try {


            Log.e("SmsReceiver", "Run");

            Bundle data = intent.getExtras();

            Object[] pdus = (Object[]) data.get("pdus");

            for (int i = 0; i < pdus.length; i++) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);

                String sender = smsMessage.getDisplayOriginatingAddress();


                //You must check here if the sender is your provider and not another one with same text.

                String messageBody = smsMessage.getMessageBody();

                //Pass on the text to our listener.
                mListener.messageReceived(sender, messageBody);
            }

        }catch (Exception e){
            Log.e("SmsReceiver",e.toString());
        }

    }

    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}
