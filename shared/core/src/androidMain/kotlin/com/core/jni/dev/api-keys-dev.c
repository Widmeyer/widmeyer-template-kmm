#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_core_data_utils_NativeHost_1androidKt_url(JNIEnv *env, jclass clazz) {
    return (*env)->NewStringUTF(env, "https://test.com/");
}