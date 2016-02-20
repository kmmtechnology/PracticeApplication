package com.example.dell.practiceapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView redLight;
    private ImageView greenLight;
    private ImageView yellowLight;

    private Button redButton, greenButton, yellowButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redLight = (ImageView) findViewById(R.id.imageRed);
        greenLight = (ImageView) findViewById(R.id.imageGreen);
        yellowLight = (ImageView) findViewById(R.id.imageYellow);

        redButton = (Button) findViewById(R.id.redButton);
        greenButton = (Button) findViewById(R.id.greenButton);
        yellowButton = (Button) findViewById(R.id.yellowButton);

        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);


        redLight.setOnTouchListener(new View.OnTouchListener() {
                                        @Override
                                        public boolean onTouch(View v, MotionEvent event) {
                                            if (event.getAction() == event.ACTION_DOWN) {
                                                turnAllLightsOff();
                                                turnRedLight();
                                                return true;
                                            }
                                            return false;
                                        }
                                    }

        );


        greenLight.setOnTouchListener(new View.OnTouchListener() {
                                          @Override
                                          public boolean onTouch(View v, MotionEvent event) {
                                              if (event.getAction() == event.ACTION_DOWN) {
                                                  turnAllLightsOff();
                                                  turnGreenLight();
                                                  return true;
                                              }
                                              return false;
                                          }
                                      }

        );

        // explore device screen resolution and display


        yellowLight.setOnTouchListener(new View.OnTouchListener() {  // explore more....
                                           @Override
                                           public boolean onTouch(View v, MotionEvent event) {
                                               if (event.getAction() == event.ACTION_DOWN) {
                                                   turnAllLightsOff();
                                                   turnYellowLight();
                                                   return true;
                                               }
                                               return false;
                                           }
                                       }

        );


    }

    @Override
    public void onClick(View v) {
        turnAllLightsOff();
        int code = (v == redButton ? 100 : (v == yellowButton ? 200 : (v == greenButton ? 300 : -1)));

        switch (code) {

            case 100:
                turnRedLight();
                break;
            case 200:
                turnYellowLight();
                break;
            case 300:
                turnGreenLight();
                break;

        }
    }



    private void turnAllLightsOff() {
        greenLight.setImageResource(R.drawable.nosignal);
        redLight.setImageResource(R.drawable.nosignal);
        yellowLight.setImageResource(R.drawable.nosignal);
    }

    private void turnGreenLight() {

        greenLight.setImageResource(R.drawable.green);
    }

    private void turnRedLight() {
        redLight.setImageResource(R.drawable.red);

    }

    private void turnYellowLight() {
        yellowLight.setImageResource(R.drawable.yellow);
    }


}