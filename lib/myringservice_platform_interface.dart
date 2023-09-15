import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'myringservice_method_channel.dart';

abstract class MyringservicePlatform extends PlatformInterface {
  /// Constructs a MyringservicePlatform.
  MyringservicePlatform() : super(token: _token);

  static final Object _token = Object();

  static MyringservicePlatform _instance = MethodChannelMyringservice();

  /// The default instance of [MyringservicePlatform] to use.
  ///
  /// Defaults to [MethodChannelMyringservice].
  static MyringservicePlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [MyringservicePlatform] when
  /// they register themselves.
  static set instance(MyringservicePlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> start() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
  Future<String?> stop() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
