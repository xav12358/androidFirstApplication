LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := nativelib
LOCAL_SRC_FILES := nativelib.cpp

include $(BUILD_SHARED_LIBRARY)
