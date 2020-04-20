package com.example.edu.booking.usecase;

import java.util.List;

public interface ListUsecase<T extends Request, R extends Response> {
  /**
   * ユースケースを実行します.
   *
   * @param request ユースケースに対するリクエスト
   * @return responseのList
   */
  List<R> execute(T request);
}
