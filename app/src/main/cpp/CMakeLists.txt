# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html



#Needed Library 'libdl.so'
#Needed Library 'libm.so'
#Needed Library 'liblog.so'
#Needed Library 'libjnigraphics.so'
#Needed Library 'libz.so'
#Needed Library 'libmediandk.so'
#Needed Library 'libc.so'
#Needed Library 'libc++_shared.so'

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

project("cvfacemaker")

set(libs "${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}")

add_library(native-lib SHARED native-lib.cpp)
add_library(main STATIC cvFaceMaker.cpp)

add_library(dlib SHARED IMPORTED)
set_target_properties(dlib PROPERTIES
        IMPORTED_LOCATION "${libs}/libdlib.so")
#add_library(opencv_java4 SHARED IMPORTED )
#set_target_properties(opencv_java4 PROPERTIES
#        IMPORTED_LOCATION "${libs}/libopencv_java4.so")


find_library( # Sets the name of the path variable.
              log-lib
              log )

#导入头文件
include_directories(${CMAKE_SOURCE_DIR}/include)
#导入库文件
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${libs}")


target_link_libraries( # Specifies the target library.
        native-lib

        opencv_java4
        android
        ${log-lib} )