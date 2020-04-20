package com.example.edu.booking.domain.model;

public interface Entity<K> {
  /**
   * エンティティのキーを取得します.
   *
   * @return エンティティのキー情報.
   */
  K getId();

  /**
   * エンティティのキーをセットします.
   *
   * @param id エンティティのキー情報.
   */
  void setId(K id);

  /**
   * エンティティが永続化されているかの状態を取得します。.
   * ストア等の永続化されて取得している場合はfalse、登録前の状態はtrueを返却するようにします。
   *
   * @return エンティティが永続化されている場合はtrue, そうでない場合はfalse
   */
  boolean isTransient();

  /**
   * エンティティの永続化状態をセットします。.
   *
   * @param isTransient 永続化の状態
   */
  void setTransient(boolean isTransient);

  /**
   * キー項目が一致しているかを確認する。.
   *
   * @param root このオブジェクトとオブジェクトのキー項目が一致する場合true
   */
  @Override
  boolean equals(Object root);

  /**
   * このオブジェクトのハッシュコードを返却します。.
   */
  @Override
  int hashCode();
}
