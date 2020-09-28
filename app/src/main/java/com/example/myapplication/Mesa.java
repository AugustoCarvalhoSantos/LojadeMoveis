package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Mesa extends AppCompatActivity implements SensorEventListener {
    private TextView txtAviso, txtQuebrou;
    private ImageView imgMesa;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private boolean isAccelerometerSensorAvaliable, itIsNotFirstTime = false;
    private float currentX, currentY, currentZ, lastX, lastY, lastZ;
    private float xDifference, yDifference, zDifference;
    private float shakeThreshold = 5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesa);

        txtAviso = findViewById(R.id.txtAviso);
        txtQuebrou = findViewById(R.id.txtQuebrou);
        imgMesa = findViewById(R.id.imgMesa);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!= null){
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isAccelerometerSensorAvaliable = true;
        }else{
            txtAviso.setText("Acelerômetro não disponível.");
            isAccelerometerSensorAvaliable=false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        currentX = event.values[0];
        currentY = event.values[1];
        currentZ = event.values[2];

        if(itIsNotFirstTime){
            xDifference = Math.abs(lastX-currentX);
            yDifference = Math.abs(lastY-currentY);
            zDifference = Math.abs(lastZ-currentZ);

            if((xDifference > shakeThreshold && yDifference > shakeThreshold) ||
                    (xDifference > shakeThreshold && zDifference > shakeThreshold) ||
                    (yDifference > shakeThreshold && zDifference > shakeThreshold))
            {
                imgMesa.setImageResource(R.drawable.mesa2);
                txtQuebrou.setText("Parabéns! você quebrou sua única mesa!");
            }
        }
        lastX = currentX;
        lastY = currentY;
        lastZ = currentZ;
        itIsNotFirstTime = true;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(isAccelerometerSensorAvaliable)sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(isAccelerometerSensorAvaliable)sensorManager.unregisterListener(this);
    }
}
