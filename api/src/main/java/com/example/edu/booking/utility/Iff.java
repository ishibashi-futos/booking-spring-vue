package com.example.edu.booking.utility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Iff<T, R> {
  Map<Predicate<T>, Supplier<R>> evaluations = new LinkedHashMap<>();
  private Supplier<R> elsef;

  public Iff(Predicate<T> condition, Supplier<R> then) {
    evaluations.put(condition, then);
  }

  public Iff<T, R> elseIf(Predicate<T> condition, Supplier<R> then) {
    evaluations.put(condition, then);
    return this;
  }

  public Iff<T, R> elsef(Supplier<R> elsef) {
    this.elsef = elsef;
    return this;
  }

  public Optional<R> eval(T target) {
    for (Map.Entry<Predicate<T>, Supplier<R>> entry : this.evaluations.entrySet()) {
      if (entry.getKey().test(target)) {
        var value = entry.getValue().get();
        return Objects.isNull(value) ? Optional.empty() : Optional.of(value);
      }
    }
    if (this.elsef == null) {
      return Optional.empty();
    } else {
      var result = this.elsef.get();
      if (Objects.isNull(result)) {
        return Optional.empty();
      }
      return Optional.of(result);
    }
  }
}
