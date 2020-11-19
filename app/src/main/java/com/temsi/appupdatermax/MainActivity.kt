package com.temsi.appupdatermax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.temsi.appupdater.*
import com.temsi.appupdater.enums.AppUpdaterError
import com.temsi.appupdater.enums.UpdateFrom
import com.temsi.appupdater.interfaces.IProgressListener
import com.temsi.appupdater.objects.Update
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { checkUpdate() }
    }

    private fun checkUpdate() {
//        val appUpdaterUtils = AppUpdaterUtils(this)
//            .setUpdateFrom(UpdateFrom.JSON)
//            .setUpdateJSON("http://89.22.54.72:80/api/UpdateService/Firmware_CheckLastAlphaUpdate")
//            .withListener(object : AppUpdaterUtils.UpdateListener {
//                override fun onSuccess(update: Update, isUpdateAvailable: Boolean) {
//                    Log.d("Latest Version", update.latestVersion)
//                    Log.d("Latest Version Code", update.latestVersionCode.toString())
//                    Log.d("URL", update.urlToDownload.toString())
//                    Log.d("Is update available?", java.lang.Boolean.toString(isUpdateAvailable))
//                }
//
//                override fun onFailed(error: AppUpdaterError) {
//                    Log.d("AppUpdater Error", "Something went wrong")
//                }
//            })
//        appUpdaterUtils.start()
        val appUpdater = AppUpdater(this)
            .setUpdateFrom(UpdateFrom.JSON)
            .setProgressListener(object : IProgressListener{
                override fun onStartAction() {
                    //show progress
                }

                override fun FinishActionFailed() {
                    //hide progress
                }

                override fun FinishActionSuccess() {
                    //hide progress
                }
            })
            .setUpdateJSON("http://89.22.54.72:80/api/UpdateService/Firmware_CheckLastAlphaUpdate")
        appUpdater.start()

    }


}
