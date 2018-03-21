package xmmp.com.jobschedulerdemo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

   /* private static final String TAG = MainActivity.class.getSimpleName();
    JobScheduler mJobScheduler;*/

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        ComponentName componentName = new ComponentName(getApplicationContext(), TestService.class);
//        JobInfo jobInfo = new JobInfo.Builder(1, componentName).setOverrideDeadline(10).setRequiresCharging(true).build();
//        jobScheduler.schedule(jobInfo);


        JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(), JobSchedulerService.class);
        JobInfo jobInfo = new JobInfo.Builder(1, componentName).setPeriodic(3000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY).setRequiresCharging(true).build();
        jobScheduler.schedule(jobInfo);

//
//        ComponentName componentName = new ComponentName(getApplicationContext(),JobSchedulerService.class);
//        JobInfo jobInfo =  new JobInfo.Builder(1,componentName).setMinimumLatency(1000).build();
       /* mJobScheduler = (JobScheduler)
                getSystemService(Context.JOB_SCHEDULER_SERVICE);


        JobInfo.Builder builder = new JobInfo.Builder(1,
                new ComponentName(MainActivity.this,
                        JobSchedulerService.class));
        builder.setPeriodic(3000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
*/
//        ComponentName serviceComponent = new ComponentName(MainActivity.this, JobSchedulerService.class);

      /*  if (mJobScheduler.schedule(builder.build()) <=1) {
            Log.e(TAG, "onCreate: Some error while scheduling the job");
        }*/
    }
}
