import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'myringservice_platform_interface.dart';

/// An implementation of [MyringservicePlatform] that uses method channels.
class MethodChannelMyringservice extends MyringservicePlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('myringservice');

  @override
  Future<String?> start() async {
    final version = await methodChannel.invokeMethod<String>('start');
    return version ?? "";
  }

  @override
  Future<String?> stop() async {
    final version = await methodChannel.invokeMethod<String>('stop');
    return version ?? "";
  }
}
