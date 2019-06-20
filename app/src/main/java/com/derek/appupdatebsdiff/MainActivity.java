package com.derek.appupdatebsdiff;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.derek.appupdatebsdiff.utils.ApkUtils;
import com.derek.appupdatebsdiff.utils.BsPatch;
import com.derek.appupdatebsdiff.utils.Constants;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mPatch(View v){
        new ApkUpdateTask().execute();
    }


    public void mDiff(View v){
        String oldFile = ApkUtils.getSourceApkPath(getApplicationContext(),this.getPackageName());
        String newFile = Constants.NEW_APK_PATH;
        String patchFile = Constants.PATCH_FILE_PATH;
        BsPatch.diff(oldFile,newFile,patchFile);
    }


    class ApkUpdateTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            try {

                //获取当前应用的apk文件/data/app/app
                String oldfile = ApkUtils.getSourceApkPath(MainActivity.this, getPackageName());
                //2.合并得到最新版本的APK文件
                String newfile = Constants.NEW_APK_PATH;
                String patchfile = Constants.PATCH_FILE_PATH;

                BsPatch.patch(oldfile, newfile, patchfile);

                Log.d("derek", "oldfile:"+oldfile);
                Log.d("derek", "newfile:"+newfile);
                Log.d("derek", "patchfile:"+patchfile);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            //3.安装
            if(result){
                Toast.makeText(MainActivity.this, "您正在进行无流量更新", Toast.LENGTH_SHORT).show();
                ApkUtils.installApk(MainActivity.this, Constants.NEW_APK_PATH);
            }
        }

    }
}
