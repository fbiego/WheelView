WheelView
=========

> 最后打个广告哈，阿里巴巴，杭州招技术，支持电话视频面试，有兴趣的同学戳这里：https://github.com/wangjiegulu/jobs

<img src='image/image04.png' height='500px'/>

### Usage

#### layout: 
```xml
<com.wangjie.wheelview.WheelView
        android:id="@+id/main_wv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
    />
```

#### Activity: 

```kotlin   
val planets = arrayListOf("Mercury", "Venus", "Earth", "Mars")
val wva = findViewById<WheelView>(R.id.main_wv)
wva.offset = 1
wva.setItems(PLANETS)
wva.onWheelViewListener = object  : WheelView.OnWheelViewListener(){
    override fun onSelected(index:Int, item:String?) {
        Log.d(TAG, "selectedIndex: $index, item: $item")
    }
}
```

#### Show in dialog: 

```kotlin
val planets = arrayListOf("Mercury", "Venus", "Earth", "Mars")
val outerView = LayoutInflater.from(this).inflate(R.layout.wheel_view, null)
val wv = outerView.findViewById(R.id.wheel_view_wv) as WheelView
wv.offset = 2
wv.setItems(PLANETS)
wv.setSelection(3)
wv.onWheelViewListener = object :WheelView.OnWheelViewListener() {
     override fun onSelected(index:Int, item:String?) {
        Log.d(TAG, "[Dialog]selectedIndex: $index, item: $item")
     }
}

val dialog = AlertDialog.Builder(this)
dialog.setTitle("WheelView in Dialog")
        .setView(outer)
        .setPositiveButton("OK", null)
        .show()
```
    
License
=======

    Copyright 2014 Wang Jie

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-WheelView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1433)
