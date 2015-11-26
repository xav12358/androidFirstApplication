package com.example.myfirstapplication;

import android.widget.EditText;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends Activity implements SensorEventListener{

	private SensorManager mSensorManager;
	private Sensor mAccelerometer,mGyrometer,mMagnetometer;
	private Sensor mGPSSensor;
	private EditText TValAccx,TValAccy,TValAccz;
	private EditText TValGx,TValGy,TValGz;
	private EditText TValMagx,TValMagy,TValMagz;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//		if (savedInstanceState == null) {
		//			getFragmentManager().beginTransaction()
		//					.add(R.id.container, new PlaceholderFragment()).commit();
		//		}

		TValAccx = (EditText)findViewById(R.id.AccX);
		TValAccy = (EditText)findViewById(R.id.AccY);
		TValAccz = (EditText)findViewById(R.id.AccZ);
		TValGx = (EditText)findViewById(R.id.Gx);
		TValGy = (EditText)findViewById(R.id.Gy);
		TValGz = (EditText)findViewById(R.id.Gz);
		TValMagx = (EditText)findViewById(R.id.Magx);
		TValMagy = (EditText)findViewById(R.id.Magy);
		TValMagz = (EditText)findViewById(R.id.Magz);

		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mGyrometer		= mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		mMagnetometer	= mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

		mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
		mSensorManager.registerListener(this, mGyrometer, SensorManager.SENSOR_DELAY_UI);
		mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_UI);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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


	public void onSensorChanged(SensorEvent event) {
		//if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
		//    return;

		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
		{ 
			TValAccx.setText(String.format("%.2f",event.values[0]));
			TValAccy.setText(String.format("%.2f",event.values[1]));
			TValAccz.setText(String.format("%.2f",event.values[2]));
		}

		if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE)
		{ 
			TValGx.setText(String.format("%.2f",event.values[0]) );
			TValGy.setText(String.format("%.2f",event.values[1]) );
			TValGz.setText(String.format("%.2f",event.values[2]) );
		}

		if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
		{ 
			TValMagx.setText(String.format("%.2f",event.values[0]));
			TValMagy.setText(String.format("%.2f",event.values[1]));
			TValMagz.setText(String.format("%.2f",event.values[2]));
		}

		return;
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	//	public static class PlaceholderFragment extends Fragment {
	//
	//		public PlaceholderFragment() {
	//		}
	//
	//		@Override
	//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
	//				Bundle savedInstanceState) {
	//			View rootView = inflater.inflate(R.layout.activity_main, container,
	//					false);
	//			return rootView;
	//		}
	//	}
}
