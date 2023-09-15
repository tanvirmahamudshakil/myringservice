
import 'myringservice_platform_interface.dart';

class Myringservice {
  Future<String?> Start() {
    return MyringservicePlatform.instance.start();
  }
  Future<String?> Stop() {
    return MyringservicePlatform.instance.stop();
  }
}
