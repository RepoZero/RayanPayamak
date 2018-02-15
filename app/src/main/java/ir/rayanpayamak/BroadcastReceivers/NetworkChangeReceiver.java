package ir.rayanpayamak.BroadcastReceivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver {


        private static NetworkListener net;
        @Override
        public void onReceive(final Context context, final Intent intent) {


                try {
                    net.network(checkInternet(context));
                }catch (Exception e){
                    Log.e("NetworkChangeReceiver",e.toString());
                }

        }


        boolean checkInternet(Context context) {
            ServiceManager serviceManager = new ServiceManager(context);
            if (serviceManager.isNetworkAvailable()) {
                return true;
            } else {
                return false;
            }
        }


    public static void internet(NetworkListener network) {
        net = network;
    }

    }

