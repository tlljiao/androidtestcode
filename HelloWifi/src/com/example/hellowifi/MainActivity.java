package com.example.hellowifi;

import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressLint("UseValueOf") public class MainActivity extends Activity {
	private TextView wifiText;
	private WifiManager wifiManager;
	private StringBuilder sb;
	private List<ScanResult> wifiList;
	private WifiReceiver wifiReceiver;
	private int countScan = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		sb = new StringBuilder();
		
		String strcountScan = Integer.toString(countScan);
		Log.i("ScanTimes", "ScanTimes："+strcountScan);
		
		wifiText = (TextView)findViewById(R.id.wifi);
		wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		wifiReceiver = new WifiReceiver();
		registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		wifiManager.startScan();
		wifiText.setText("\nStarting Scan\n");
		
		wifiManager.setWifiEnabled(true);
		Log.i("Enablewifi", "success");
		
//		if(wifiManager.isWifiEnabled())
//		{
//			wifiManager.setWifiEnabled(false);
//			Log.i("Enablewifi", "false");
//		}
//		else
//		{
//			wifiManager.setWifiEnabled(true);
//			Log.i("Enablewifi", "true");
//		}
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	menu.add(0, 0, 0, "Refresh");
    	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		wifiManager.startScan();
		wifiText.setText("Starting Scan");
		return super.onMenuItemSelected(featureId, item);
    }
    
	@Override
	protected void onPause() {
	unregisterReceiver(wifiReceiver);
	super.onPause();
	}

	@Override
	protected void onResume() {
		registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		super.onResume();
	}
    
	private final class WifiReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			sb = new StringBuilder();
			wifiList = wifiManager.getScanResults();
			
//			while(true)
//			{
//				if(wifiManager.isWifiEnabled())
//				{
//					wifiManager.setWifiEnabled(false);
//					Log.i("Enablewifi", "false");
//				}
//				else if(false)
//				{
//					break;
//				}
//				else
//				{
//					wifiManager.setWifiEnabled(true);
//					Log.i("Enablewifi", "true");
//				}
//			}

			
			
			for(int i = 0;i < wifiList.size();i++)
			{
				sb.append(new Integer(i + 1).toString() + ".");  
                sb.append((wifiList.get(i)).toString()).append("\n\n");
			}
			wifiText.setText(sb.toString());
			countScan++;
			String strcountScan = Integer.toString(countScan);
			Log.i("ScanTimes", "ScanTimes："+strcountScan);
		}
	}
}
