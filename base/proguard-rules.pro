-dontobfuscate

#trial and error
# i am keeping android.support.v7.widget.** because i got a NPE involving AppCompatImageButton and AppCompatBackgroundHelper and i have no idea how to fix it.
-keep public class android.support.v7.widget.** {*;}

# I am getting multiple NoSuchMethodError or NoClassDefFoundError because some of the classes are not used in base module but used in feature module. Proguard erroneously remove them.
-keep public class app.eccweizhi.androidinstantapptemplate.base.** { *;}

#I am getting NoClassDefFoundError for multiple dagger.internal class
-keep public class dagger.internal.** { *; }

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
 public static **[] values();
 public static ** valueOf(java.lang.String);
}

#Glide
-keep public interface com.bumptech.glide.manager.LifecycleListener {*;}
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

#jackson
-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry
-dontwarn java.beans.**

#dagger
-dontwarn com.google.errorprone.annotations.*

#retrofit
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

#retrofit uses okio under the hood
-dontwarn okio.**