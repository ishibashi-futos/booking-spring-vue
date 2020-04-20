package com.example.edu.booking.domain.model;

import java.util.UUID;

public abstract class StringIdentifierEntity implements Entity<String> {
  /**
   * サロゲートキー.
   */
  protected String id;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  /**
   * エンティティの永続化状態.
   */
  protected boolean isTransient;

  /**
   * 新規IDを生成し、IDへ設定します.
   *
   * @return 生成したUUIDの値
   */
  public String generateId() {
    String uuid = UUID.randomUUID().toString();
    setId(uuid);
    return uuid;
  }
}
