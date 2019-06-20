#include <jni.h>
#include <stddef.h>
#include "com_derek_appupdatebsdiff_utils_BsPatch.h"
#include "bs.h"

JNIEXPORT void JNICALL Java_com_derek_appupdatebsdiff_utils_BsPatch_patch
        (JNIEnv * env, jclass jcls, jstring oldfile_jstr, jstring newfile_jstr, jstring patchfile_jstr){


    int argc = 4;
    char* oldfile = (char*)(*env)->GetStringUTFChars(env,oldfile_jstr, NULL);
    char* newfile = (char*)(*env)->GetStringUTFChars(env,newfile_jstr, NULL);
    char* patchfile = (char*)(*env)->GetStringUTFChars(env,patchfile_jstr, NULL);

    //参数（第一个参数无效）
    char *argv[4];
    argv[0] = "bspatch";
    argv[1] = oldfile;
    argv[2] = newfile;
    argv[3] = patchfile;

    bspatch_main(argc,argv);

    (*env)->ReleaseStringUTFChars(env,oldfile_jstr, oldfile);
    (*env)->ReleaseStringUTFChars(env,newfile_jstr, newfile);
    (*env)->ReleaseStringUTFChars(env,patchfile_jstr, patchfile);
}


JNIEXPORT void JNICALL Java_com_derek_appupdatebsdiff_utils_BsPatch_diff
        (JNIEnv * env, jclass jcls, jstring oldfile_jstr, jstring newfile_jstr, jstring patchfile_jstr){
    int argc = 4;
    char* oldfile = (char*)(*env)->GetStringUTFChars(env,oldfile_jstr, NULL);
    char* newfile = (char*)(*env)->GetStringUTFChars(env,newfile_jstr, NULL);
    char* patchfile = (char*)(*env)->GetStringUTFChars(env,patchfile_jstr, NULL);

    //参数（第一个参数无效）
    char *argv[4];
    argv[0] = "bsdiff";
    argv[1] = oldfile;
    argv[2] = newfile;
    argv[3] = patchfile;

    bsdiff_main(argc,argv);

    (*env)->ReleaseStringUTFChars(env,oldfile_jstr, oldfile);
    (*env)->ReleaseStringUTFChars(env,newfile_jstr, newfile);
    (*env)->ReleaseStringUTFChars(env,patchfile_jstr, patchfile);
}


