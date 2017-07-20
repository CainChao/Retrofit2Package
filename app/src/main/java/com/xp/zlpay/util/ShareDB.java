package com.xp.zlpay.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.xp.zlpay.MyApplication;
import com.xp.zlpay.constant.ConstantKey;


public class ShareDB {
	private static ShareDB mInstance;
	private static SharedPreferences mSharedPreferences;
	
	private ShareDB(){
		
	}
	
	public static synchronized ShareDB getInstance(){
		if(null == mInstance){
			mInstance = new ShareDB();
			mSharedPreferences = MyApplication.getInstance().getSharedPreferences(ConstantKey.SHAREDB_NAME, Context.MODE_PRIVATE);
		}
		return mInstance;
	}
	
	
	public void putString(String key, String value){
		mSharedPreferences.edit().putString(key, value).apply();
	}
	
	public void putInt(String key, int value){
		mSharedPreferences.edit().putInt(key, value).apply();
	}

	public void puLong(String key,long value){
        mSharedPreferences.edit().putLong(key,value).apply();
    }
	
	/**
	 * 获取int值   默认是""
	 * @param key
	 * @return
	 */
	public String getString(String key){
		return mSharedPreferences.getString(key, "");
	}
	
	/**
	 * 获取int值   默认是-1
	 * @param key
	 * @return
	 */
	public int getInt(String key){
		return mSharedPreferences.getInt(key, -1);
	}

    /**
     * 获取long值   默认是-1
     * @param key
     * @return
     */
	public long getLong(String key){return  mSharedPreferences.getLong(key,-1);}
}
