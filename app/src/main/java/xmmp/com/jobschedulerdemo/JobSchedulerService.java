package xmmp.com.jobschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by unepali on 3/20/2018.
 */

public class JobSchedulerService extends JobService {

    JobParameters params;
    DoItTask doIt;

    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        Log.d("TestService", "Work to be called from here");
        doIt = new DoItTask();
        doIt.execute();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d("TestService", "System calling to stop the job here");
        if (doIt != null)
            doIt.cancel(true);
        return false;
    }

    private class DoItTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {
            Log.d("DoItTask", "Working here...");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d("DoItTask", "Clean up the task here and call jobFinished...");
            jobFinished(params, false);

            Toast.makeText(JobSchedulerService.this, "done", Toast.LENGTH_SHORT).show();
            super.onPostExecute(aVoid);
        }


    }
}
