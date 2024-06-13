# [Java] 列舉 Enum

## Enum 的定義

```java
public abstract class Enum<E extends Enum<E>>
    implements Comparable<E>, Serializable {
    private final String name;
    private final int ordinal;
    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
    public String name() {
        return name;
    }
    public int ordinal() {
        return ordinal;
    }
    public String toString() {
        return name;
    }
    public final boolean equals(Object other) {
        return this==other;
    }
    public final int hashCode() {
        return super.hashCode();
    }
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    public final int compareTo(E o) {
        Enum other = (Enum)o;
        Enum self = this;
        if (self.getClass() != other.getClass() && // optimization
            self.getDeclaringClass() != other.getDeclaringClass())
            throw new ClassCastException();
        return self.ordinal - other.ordinal;
    }
    public final Class<E> getDeclaringClass() {
        Class clazz = getClass();
        Class zuper = clazz.getSuperclass();
        return (zuper == Enum.class) ? clazz : zuper;
    }
    public static <T extends Enum<T>> T valueOf(Class<T> enumType,
                                                String name) {
        T result = enumType.enumConstantDirectory().get(name);
        if (result != null)
            return result;
        if (name == null)
            throw new NullPointerException("Name is null");
        throw new IllegalArgumentException(
            "No enum constant " + enumType.getCanonicalName() + "." + name);
    }
    protected final void finalize() { }
}
```
這也太落落長了吧，我們稍微聊解一些重要的部分。

## Enum 的特性

1. `Enum` 類別是抽象類別，所以無法直接實例化。
2. `Enum` 類別繼承了 `Comparable` 介面，所以 Enum 類別可以進行比較。主要是針對 `Enum` 類別的 `ordinal` 進行比較。
    列舉在宣告時，會給予每個成員一個 `name` 和 `ordinal`，`name` 是成員的名稱，`ordinal` 是成員的編號，從 0 開始。
    可以透過 `name()` 取得成員的名稱，
    透過 `ordinal()` 取得成員的編號。
3. `Enum` 類別實作了 `Serializable` 介面，所以 Enum 類別可以進行序列化。
    為什麼我們要序列化 Enum 類別呢？因為我們會希望 `Enum` 類別可以透過序列化來使 `Enum` 包持單例，讓每個枚舉都只有一個實例。
    通常我們會把 `Enum` 用來定義常數，這樣就可以確保程式中的常數都是唯一的。
4. `Enum` 類別的建構子是 `protected`，所以無法直接建立 `Enum` 類別的實例。
5. `Enum` 類別有一個 `valueOf` 方法，可以透過 `name` 取得 `Enum` 的實例。
6. `Enum` 類別的 `equals` 方法被覆寫，且為 `final`，實作邏輯與 `Object` 類別的 `equals` 方法相同，都是比較記憶體位置。
7. `Enum` 類別的 `hashCode` 方法被覆寫，且為 `final`，實作邏輯與 `Object` 類別的 `hashCode` 方法相同，都是回傳記憶體位置的 hash code。
8. 定義 `Enum` 時，可以自定義 `constructor`，但是有個條件是不得為 `public`，且也不可於 `constructor` 中呼叫 `super()`。 

> `Comparable` 來[這裡TODO](我還沒寫)看看。     
> `Serializable` 來[這裡TODO](我還沒寫)看看。

## 來建立一個 Enum 吧

```java
public enum Priority {
    MAX(10), HIGH(8), MEDIUM(5), LOW(3), MIN(1); // 呼叫建構子

    private int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        for (Priority priority : Priority.values()) {
            System.out.println(priority + " : " + priority.getValue());
        }
    }
}
```






## Reference

[https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/lang/Enum.html](https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2Fjava/lang/Enum.html)
