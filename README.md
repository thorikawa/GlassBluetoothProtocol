GlassBluetoothProtocol
================

Android library to communicate Google Glass via Bluetooth connection.

### Usage

1. This library does not support pairing with Glass. Please pair with Glass in advance.
2. Open socket with Glass using the following UUID.

  ```
public static final UUID SECURE_UUID = UUID.fromString("F15CC914-E4BC-45CE-9930-CB7695385850");
...
BluetoothSocket socket = bluetoothDevice.createRfcommSocketToServiceRecord(SECURE_UUID);
socket.connect();
  ```

3. Create new message as following.

  ```
// Envelope is the root of the message hierarchy.
Proto.Envelope envelope = CompanionMessagingUtil.newEnvelope();
// This example is for obtaining screenshot.
ScreenShot screenShot = new ScreenShot();
screenShot.startScreenshotRequestC2G = true;
envelope.screenshot = screenShot;
GlassProtocol.writeMessage(envelope, socket.getOutputStream());
  ```

4. Read incoming message as following. (You might want to do it in the dedicated thread.)

  ```
Envelope envelope = (Envelope) GlassProtocol.readMessage(new Envelope(), socket.getInputStream());
if (envelope.screenshot != null) {
	// screenshot response includes screenshot field in envelope
	// …do something…
}
  ```

## Download

Download [the latest JAR][1] or grab via Maven:
```xml
<dependency>
  <groupId>com.polysfactory.lib.glass.bluetooth</groupId>
  <artifactId>glass-bluetooth</artifactId>
  <version>(insert latest version)</version>
</dependency>
```
or Gradle:
```groovy
compile 'com.polysfactory.lib.glass.bluetooth:glass-bluetooth:(insert latest version)'
```

### License
```
Copyright 2013 Poly's Factory

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[1]: http://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.polysfactory.lib.glass.bluetooth&a=glass-bluetooth&v=LATEST
