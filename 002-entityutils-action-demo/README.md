## EntityUtils实现List、数组、Map、Set等集合互转

### 前期准备

```xml
<dependency>
    <groupId>xin.altitude.cms</groupId>
    <artifactId>ucode-cms-common</artifactId>
    <version>1.6.2.3</version>
</dependency>
```

依赖版本号尽可能保持较新的版本，会不定时增加新内容。阿里云镜像同步有延迟，若找不到资源，适当降低版本号即可。工具类[源代码开源](https://gitee.com/decsa/ucode-cms-vue)

### 实战开发

#### List转List

```java
public void test1() {
        List<User> userList = this.list();
        // 1. 实体类转换
        List<UserVo> userVoList = EntityUtils.toList(userList, UserVo::new);
        // 2. 取出某列数据
        List<String> userNames = EntityUtils.toList(userList, User::getUserName);
        }
```

#### List转数组

```java
public void test2() {
        List<User> userList = this.list();
        // 1. 不改变元素类型
        User[] userArrays = EntityUtils.toArray(userList);
        // 2. 改变元素类型
        String[] userNames = EntityUtils.toArray(userList, User::getUserName);
        }
```

#### 数组转集合

```java
public void test3() {
        Integer[] arrays = {1, 2, 3, 4, 5, 6};
        // 1. 不改变元素类型
        List<Integer> integerList = EntityUtils.toList(arrays);
        // 2. 改变元素类型
        List<String> stringList = EntityUtils.toList(arrays, String::valueOf);
        }
```

#### 实体类转Map

```java
public void test4() {
        User user = this.getById(1);
        Map<String, Object> map = EntityUtils.toMap(user);
        }
```

#### List转Map

```java
public void test5() {
        List<User> userList = this.list();
        Map<Long, String> map = EntityUtils.toMap(userList, User::getUserId, User::getUserName);

        Map<Long, User> map2 = EntityUtils.toMap(userList, User::getUserId);
        }
```

#### List转Set

```java
public void test6() {
        List<User> userList = this.list();
        // User实体类equalts方法得重写
        Set<User> userSet = EntityUtils.toSet(userList);
        // 改变元素类型
        Set<String> userSets = EntityUtils.toSet(userList, User::getUserName);
        }
```

#### Arrays.asList()处理

```java
public void test7() {
        Integer[] arrays = {1, 2, 3, 4, 5, 6};
        List<Integer> integerList = Arrays.asList(arrays);
        List<Integer> newList = EntityUtils.toList(integerList, Function.identity());
        List<String> newList2 = EntityUtils.toList(integerList, String::valueOf);
        }
```
