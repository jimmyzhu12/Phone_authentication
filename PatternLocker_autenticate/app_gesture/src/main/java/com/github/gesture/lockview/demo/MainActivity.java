// Copyright (c) 2019-present, iQIYI, Inc. All rights reserved.
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//

// Created by caikelun on 2019-03-07.
package com.github.gesture.lockview.demo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.github.gesture.lockview.OnPatternChangeListener;
import com.github.gesture.lockview.PatternIndicatorView;
import com.github.gesture.lockview.PatternLockerView;

public class MainActivity extends AppCompatActivity {

    // this is from android dev

//    private static final String DEBUG_TAG = "Velocity";
//
//    private VelocityTracker mVelocityTracker = null;
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int index = event.getActionIndex();
//        int action = event.getActionMasked();
//        int pointerId = event.getPointerId(index);
//
//        switch(action) {
//            case MotionEvent.ACTION_DOWN:
//                if(mVelocityTracker == null) {
//                    // Retrieve a new VelocityTracker object to watch the
//                    // velocity of a motion.
//                    mVelocityTracker = VelocityTracker.obtain();
//                }
//                else {
//                    // Reset the velocity tracker back to its initial state.
//                    mVelocityTracker.clear();
//                }
//                // Add a user's movement to the tracker.
//                mVelocityTracker.addMovement(event);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mVelocityTracker.addMovement(event);
//                // When you want to determine the velocity, call
//                // computeCurrentVelocity(). Then call getXVelocity()
//                // and getYVelocity() to retrieve the velocity for each pointer ID.
//                mVelocityTracker.computeCurrentVelocity(1000);
//                // Log velocity of pixels per second
//                // Best practice to use VelocityTrackerCompat where possible.
//                Log.d("", "X velocity: " + mVelocityTracker.getXVelocity(pointerId));
//                Log.d("", "Y velocity: " + mVelocityTracker.getYVelocity(pointerId));
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                // Return a VelocityTracker object back to be re-used by others.
//                mVelocityTracker.recycle();
//                break;
//        }
//        return true;
//    }
    // this is the original lockview code
    private PatternLockerView patternLockerView;
    private PatternIndicatorView patternIndicatorView;
    private Context context;
    private Button btn_show, btn_dismiss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        patternIndicatorView = (PatternIndicatorView) findViewById(R.id.patternIndicatorView);
        patternIndicatorView.updateState(integers, false);

        patternLockerView = (PatternLockerView) findViewById(R.id.patternLockerView);

        patternLockerView.setOnPatternChangedListener(new OnPatternChangeListener() {
            @Override
            public void onStart(PatternLockerView view) {

            }

            @Override
            public void onChange(PatternLockerView view, List<Integer> hitIndexList) {

            }





            @Override
            public void onComplete(PatternLockerView view, List<Integer> hitIndexList) {
                patternIndicatorView.updateState(hitIndexList, false);
                if (hitIndexList.size() < 4) {
                    Toast.makeText(context,"Must longer than 3", Toast.LENGTH_LONG).show();
                    view.updateStatus(true);
                }
            }

            @Override
            public void onClear(PatternLockerView view) {

            }
        });

    }
}
