#include <jni.h>

jstring getString(JNIEnv *env, jstring string) {
    return (*env)->NewStringUTF(env, string);
}

JNIEXPORT jstring JNICALL
Java_com_widmeyertemplate_data_infrastructure_NativeHost_1androidKt_url(JNIEnv *env, jclass clazz) {
    return getString(env, "https://dev.courier.api.mealstream.ru");
}