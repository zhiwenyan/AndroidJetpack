package com.steven.androidjetpack.workManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.steven.androidjetpack.R;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class WorkManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);
        OneTimeWorkRequest compressionWork = new OneTimeWorkRequest.Builder(CompressWorker.class).build();
        WorkManager.getInstance().enqueue(compressionWork);

    }
}
