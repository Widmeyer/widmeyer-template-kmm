LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE    := api-keys-dev
LOCAL_SRC_FILES := dev/api-keys-dev.c
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := api-keys-prod
LOCAL_SRC_FILES := prod/api-keys-prod.c
include $(BUILD_SHARED_LIBRARY)