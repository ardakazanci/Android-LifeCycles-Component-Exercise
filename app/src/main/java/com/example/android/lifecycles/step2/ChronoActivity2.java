/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step2;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.widget.Chronometer;

import com.example.android.codelabs.lifecycle.R;

public class ChronoActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The ViewModelStore provides a new ViewModel or one previously created.
        ChronometerViewModel chronometerViewModel
                = new ViewModelProvider(this).get(ChronometerViewModel.class);

        // Get the chronometer reference
        Chronometer chronometer = findViewById(R.id.chronometer);

        if (chronometerViewModel.getStartTime() == null) {
            // ViewModel ilk kez oluşturulduysa çalışacak kısım.
            // getStartTime üzerinden null değerinden anladık.
            long startTime = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            // ViewModel korunduysa çalışacak kısım.
            Log.i("ChromeActivity2","Çalıştı");
            chronometer.setBase(chronometerViewModel.getStartTime());
            Log.i("ChromeActivity2","Çalıştı -> "+chronometerViewModel.getStartTime());
        }

        chronometer.start();
    }
}
