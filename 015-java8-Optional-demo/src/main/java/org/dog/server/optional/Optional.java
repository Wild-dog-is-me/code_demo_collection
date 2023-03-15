package org.dog.server.optional;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <p>处理空指针包装器</p>
 */
public final class Optional<T> {

    private static final Optional<?> EMPTY = new Optional<>();


    private final T value;


    private Optional() {
        this.value = null;
    }


    private Optional(T value) {
        this.value = java.util.Objects.requireNonNull(value);
    }

    public static <T> Optional<T> empty() {
        @SuppressWarnings("unchecked")
        Optional<T> t = (Optional<T>) EMPTY;
        return t;
    }

    /**
     * <p>创建{@code Optional}包装器实例</p>
     * <p>使用此方法需要严格保证参数<code>value</code>不能为<code>null</code>，否则请使用另一个方法{@link #ofNullable(Object)}</p>
     *
     * @param value 普通的对象实例
     * @param <T>   对象的类型
     * @return {@code Optional}包装器实例
     */
    public static <T> Optional<T> of(T value) {
        return new Optional<>(value);
    }


    /**
     * <p>创建{@code Optional}包装器实例</p>
     * <p>不确定参数<code>value</code>是否为<code>null</code>，则使用本方法，大多数情况下如此</p>
     *
     * @param value 普通的对象实例
     * @param <T>   对象的类型
     * @return {@code Optional}包装器实例
     */
    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }


    /**
     * <p>创建{@code Optional}包装器实例中取出真实的对象实例</p>
     * <p>调用本方法之前 需要先调用{@link #isPresent()}方法判断真实对象是否为<code>null</code>，如果存在再调用本方法</p>
     * <pre>
     *     if(opt.isPresent()){
     *         T t = opt.get();
     *     }
     * </pre>
     * <p>如果不判断直接调用本方法 很可能抛出{@link NoSuchElementException}</p>
     *
     * @return 真实对象实例
     */
    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }


    /**
     * 判断{@code Optional}包装器实例中真实对象是否存在
     */
    public boolean isPresent() {
        return value != null;
    }


    /**
     * <p>如果包包裹的对象存在 则执行回调方法</p>
     * <p>高频使用方法</p>
     *
     * @param consumer
     */
    public void ifPresent(Consumer<? super T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    /**
     * <p>本方法使用不多</p>
     */
    public Optional<T> filter(Predicate<? super T> predicate) {
        java.util.Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }


    /**
     * 将被包裹的对象从{@code T}实例转化成{@code U}实例
     * <pre>
     *     Long userId = Optional.ofNullable(user).map(User::getUserId).orElse(null);
     * </pre>
     * <p>传统方式只能按照如下方式编码</p>
     * <pre>
     *     if(user != null){
     *         Long userId = user.getUserId();
     *     }
     * </pre>
     * <p>高频使用方法</p>
     *
     * @param mapper 转换规则 Lambda或者方法引用表示
     * @param <U>    转换后的对象类型
     * @return {@code U}类型的新的包装器实例
     */
    public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        java.util.Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Optional.ofNullable(mapper.apply(value));
        }
    }


    public <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
        java.util.Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return java.util.Objects.requireNonNull(mapper.apply(value));
        }
    }

    /**
     * <p>从{@code Optional}包装器实例尝试获取值 如果不存在 则返回参数<code>other</code>指定的值</p>
     * <p>使用方法参考{@link #map(Function)}参考实例</p>
     * <p>高频使用方法</p>
     */
    public T orElse(T other) {
        return value != null ? value : other;
    }

    /**
     * <p>使用场景与{@link #orElse(Object)}类似，区别是能够通过回调方法动态指定<i>默认值</i></p>
     * <p>高频使用方法</p>
     */
    public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }

    /**
     * <p>使用场景与{@link #orElse(Object)}类似，区别是如果真实对象不存在，则抛出指定回调异常</p>
     */
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Optional)) {
            return false;
        }

        Optional<?> other = (Optional<?>) obj;
        return java.util.Objects.equals(value, other.value);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }


    @Override
    public String toString() {
        return value != null
                ? String.format("Optional[%s]", value)
                : "Optional.empty";
    }
}

