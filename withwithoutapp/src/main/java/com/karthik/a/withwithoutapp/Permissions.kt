package com.karthik.a.withwithoutapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
fun Context.hasNotificationPermission():Boolean{
    return ContextCompat.checkSelfPermission(
        this, Manifest.permission.POST_NOTIFICATIONS)== PackageManager.PERMISSION_GRANTED
}