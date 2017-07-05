## 设计图展示:
![](https://leanote.com/api/file/getImage?fileId=595bbe66ab64417d4b001bfb)
---
![](https://leanote.com/api/file/getImage?fileId=595bbe66ab64417d4b001bfc)
效果图展示:
![](https://leanote.com/api/file/getImage?fileId=595c796dab64413dd2000e08)

## 使用开源库步骤:
### 1.项目的build.gradle设置
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### 2.app的build.gradle下设置
```
	dependencies {
	        compile 'com.github.Brioal:TimeCountDowner:1.0'
	}
```
## 使用文档
### 使用方式见GitHub项目测试Activity内容
### 属相设置见attrs内容
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="CountDownerView">
        <!--背景颜色-->
        <attr name="bgColor" format="color" />
        <!--剩余的毫秒数-->
        <attr name="timeLeft" format="integer" />
        <!--文字大小-->
        <attr name="textSize" format="dimension" />
        <!--标签文字颜色-->
        <attr name="labelTextColor" format="color" />
        <!--文字颜色-->
        <attr name="numTextColor" format="color" />
    </declare-styleable>
</resources>
```
### 有相应的java代码对上述的属相进行设置
## 完毕!
