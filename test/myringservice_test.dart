import 'package:flutter_test/flutter_test.dart';
import 'package:myringservice/myringservice.dart';
import 'package:myringservice/myringservice_platform_interface.dart';
import 'package:myringservice/myringservice_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockMyringservicePlatform
    with MockPlatformInterfaceMixin
    implements MyringservicePlatform {

  @override
  Future<String?> start() => Future.value('42');
}

void main() {
  final MyringservicePlatform initialPlatform = MyringservicePlatform.instance;

  test('$MethodChannelMyringservice is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelMyringservice>());
  });

  test('getPlatformVersion', () async {
    Myringservice myringservicePlugin = Myringservice();
    MockMyringservicePlatform fakePlatform = MockMyringservicePlatform();
    MyringservicePlatform.instance = fakePlatform;

    expect(await myringservicePlugin.getPlatformVersion(), '42');
  });
}
