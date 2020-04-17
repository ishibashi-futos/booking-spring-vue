package com.example.edu.booking.booking.thread;

import java.util.HashMap;

public class ThreadLocalHolder {
  private static final ThreadLocal<HashMap<String, Object>> threadLocal
    = new ThreadLocal<HashMap<String, Object>>() {
    @Override
    protected HashMap<String, Object> initialValue() {
      return new HashMap<String, Object>();
    }
  };

  /**
   * スレッドローカルで管理しているHashMapを取得します。.
   *
   * @return スレッドローカル管理のHashMap
   */
  public static HashMap<String, Object> get() {
    return threadLocal.get();
  }

  /**
   * スレッドローカルで管理しているHashMapからキーkeyで指定した値を取得する。.
   *
   * @param key キー
   * @return 値
   */
  public static Object getValue(String key) {
    HashMap<String, Object> map = threadLocal.get();
    return map.getOrDefault(key, null);
  }

  /**
   * スレッドローカルで管理しているHashMapからキーkeyで指定した値を取得する。.
   *
   * @param key キー
   * @return 値（Integer型のみ、それ以外は-1）
   */
  public static Integer getIntValue(String key) {
    HashMap<String, Object> map = threadLocal.get();
    if (map.containsKey(key)) {
      Object obj = map.get(key);
      if (Integer.class.isAssignableFrom(obj.getClass())) {
        return (Integer) obj;
      } else {
        return -1;
      }
    } else {
      return -1;
    }
  }
}
