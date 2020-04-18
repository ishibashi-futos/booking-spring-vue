package com.example.edu.booking.booking.usecase;

public interface NoResultUsecase<T extends Request> {
  /**
   * 戻り値のないユースケースを実行します.
   *
   * @param request ユースケースに対するリクエスト
   */
  void execute(T request);
}
