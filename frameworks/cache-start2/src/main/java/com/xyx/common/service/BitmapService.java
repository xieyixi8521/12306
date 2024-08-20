package com.xyx.common.service;

public interface BitmapService {
    boolean contains(String bitmapKey, Long offset);

    void setbit(String bitmapKey, Long offset, boolean b);
}
