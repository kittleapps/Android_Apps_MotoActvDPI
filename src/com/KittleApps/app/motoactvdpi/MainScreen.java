package com.KittleApps.app.motoactvdpi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.tezlastorme.buildprop.*;
import com.stericson.RootTools.*;

public class MainScreen extends Activity {
	public Button _90,_100,_stock;
	public static Context context;
	public String key = "ro.sf.lcd_density";
	CMDProcessor cmd = new CMDProcessor();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.main_screen);
		_90 = (Button) findViewById(R.id.set90dpibutton); 
		_100 = (Button) findViewById(R.id.set100dpibutton); 
		_stock = (Button) findViewById(R.id.stockdpibutton); 
		_90.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	if (RootTools.isAccessGiven()){
            	BuildProp.setProp(key, "90");
            	cmd.su.run("reboot");
            	}
            } 
        });
		_100.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	if (RootTools.isAccessGiven()){
                	BuildProp.setProp(key, "100");
                	cmd.su.run("reboot");
                }
            }
        });
		_stock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	if (RootTools.isAccessGiven()){
                	BuildProp.setProp(key, "120");
                	cmd.su.run("reboot");
                }
            }
        });
	}
}
