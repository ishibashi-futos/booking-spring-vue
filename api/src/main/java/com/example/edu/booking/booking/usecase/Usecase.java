package com.example.edu.booking.booking.usecase;

public interface Usecase<T extends Request, R extends Response> {
  /**
   * ユースケースを実行します.
   *
   * @param request ユースケースに対するリクエスト
   * @return response
   */
  R execute(T request);
}
