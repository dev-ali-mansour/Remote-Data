# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Add this global rule
-keepattributes *Annotation,Signature

# To preserve the info Crashlytics needs for readable crash reports
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# For faster builds with ProGuard, exclude Crashlytics.
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

# This rule will properly ProGuard all the model classes in
# the package com.yourcompany.models. Modify to fit the structure
# of your app.
-keep class dev.alimansour.remotedata.data.pojo.** { *; }

-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-keep class com.android.** { *; }
-keep class com.google.** { *; }
-keep class org.jsoup.** { *; }
-keep class org.joda.** { *; }
-keep class com.github.siyamed.shapeimageview.**{ *; }
-keep class dmax.dialog.** { *; }
-keep class me.cowpay.model.** { *; }
# Archeticture
-keep class androidx.room.RoomDataBase { *; }
-keep class androidx.room.Room { *; }
-keep class android.arch.** { *; }

# Keep the class names used to isConnected for availablility
-keepnames class com.facebook.login.LoginManager
-keepnames class com.twitter.sdk.android.core.identity.TwitterAuthClient
# Don't note a bunch of dynamically referenced classes
-dontwarn com.android.**
-dontwarn com.google.**
-dontwarn org.jsoup.**
-dontnote com.facebook.**
-dontnote com.twitter.**
-dontnote com.squareup.okhttp.**
-dontnote okhttp3.internal.**
-dontwarn org.joda.**
-dontwarn com.github.siyamed.**

# 3P providers are optional
-dontwarn com.facebook.**
-dontwarn com.twitter.**

# Recommended flags for Firebase Auth
-keepattributes Signature
-keepattributes *Annotation*