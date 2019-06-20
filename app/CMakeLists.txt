# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

ADD_SUBDIRECTORY(src/main/cpp/bzip2)

AUX_SOURCE_DIRECTORY(. SRC)

add_library( # Sets the name of the library.
             bspatch

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.c
             src/main/cpp/bspatch.c
             src/main/cpp/bsdiff.c )


find_library( # Sets the name of the path variable.
              log-lib

              log )



target_link_libraries( # Specifies the target library.
                       bspatch

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} bzip2 )