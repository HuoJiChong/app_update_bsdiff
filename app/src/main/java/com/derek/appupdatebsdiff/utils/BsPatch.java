package com.derek.appupdatebsdiff.utils;

/**
 * Created by J.C. on 19/06/2019.
 */

public class BsPatch {
    static {
        System.loadLibrary("bspatch");
    }

    public native static void patch(String oldFile,String newFile,String patchFile);

    public native static void diff(String oldFile,String newFile,String patchFile);

}
