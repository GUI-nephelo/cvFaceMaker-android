#include <jni.h>
#include <string>

extern "C"{
    JNIEXPORT jstring JNICALL
    Java_com_gui_cvfacemaker_JniWarpper_stringFromJNI(JNIEnv* env,jclass jc) {
        std::string hello = "Hello from C";
        return env->NewStringUTF(hello.c_str());
    }
}

