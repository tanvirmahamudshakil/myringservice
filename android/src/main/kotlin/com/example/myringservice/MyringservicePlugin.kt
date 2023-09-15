package com.example.myringservice

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.Intent
import android.util.Log
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** MyringservicePlugin */
class MyringservicePlugin: FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  private lateinit var context: Context
  private lateinit var activity: Activity

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "myringservice")
    context = flutterPluginBinding.applicationContext
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(call: MethodCall, result: Result) {

    if (call.method == "start") {
      var intent = Intent(context, RingToneService::class.java);
      if (isMyServiceRunning(RingToneService::class.java)){
        activity.stopService(intent)
        activity.startService(intent)
      }else{
        activity.startService(intent)
      }
    } else if(call.method == "stop") {
      var intent = Intent(context, RingToneService::class.java);
      activity.stopService(intent)
    }
    else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    context = binding.applicationContext
    channel.setMethodCallHandler(null)
  }


  private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
    val manager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
    for (service in manager.getRunningServices(Int.MAX_VALUE)) {
      if (serviceClass.name == service.service.className) {
        return true
      }
    }
    return false
  }



  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    activity = binding.activity;
  }

  override fun onDetachedFromActivityForConfigChanges() {
    Log.d("TAG", "onAttachedToService");
  }

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    Log.d("TAG", "onAttachedToService");
  }

  override fun onDetachedFromActivity() {
    Log.d("g", "onAttachedToService");
  }
}
