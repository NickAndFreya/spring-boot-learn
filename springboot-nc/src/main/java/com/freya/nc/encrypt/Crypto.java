package com.freya.nc.encrypt;

import java.security.Key;

/**
 * @author linjinbo
 * @create 2019-08-06
 * @Descriptioin
 * @since
 */
public interface Crypto<T, R> {

    R encrypt(Key key, T data);

    T decrypt(Key key, R encryptedData);

}
