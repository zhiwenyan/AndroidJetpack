package com.steven.androidjetpack.workManager;

import android.content.Context;
import android.support.annotation.NonNull;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Description:
 * Data：10/12/2018-11:12 AM
 *
 * @author yanzhiwen
 */
public class CompressWorker extends Worker {

    public CompressWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {


        return Result.SUCCESS;
    }
}
